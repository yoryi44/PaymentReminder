package com.example.paymentreminder.authentication.presentation.signup


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentreminder.authentication.domain.usecase.SignupWhitEmailUserCase
import com.example.paymentreminder.authentication.domain.usecase.ValidateEmailUseCase
import com.example.paymentreminder.authentication.domain.usecase.ValidatePasswordUseCase
import com.example.paymentreminder.authentication.presentation.util.ParserErrorPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val signupWhitEmailUserCase: SignupWhitEmailUserCase
) : ViewModel() {

    var state by mutableStateOf(SignupState())
        private set

    fun onEvent(event: SignupEvent)
    {
        when(event) {
            is SignupEvent.EmailChanged -> {
                state = state.copy(
                    email = event.email
                )
            }

            SignupEvent.Signup -> {
                signup()
            }
            is SignupEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
        }
    }

    fun signup()
    {
        state = state.copy(
            isLoading = true
        )

        state = state.copy(
            emailError = null,
            passwordError = null
        )

        if(!validateEmailUseCase(email = state.email))
        {
            state = state.copy(
                emailError = "Email is not valid"
            )
        }

        val passwordError = validatePasswordUseCase(password = state.password)
        state = state.copy(
            passwordError = ParserErrorPassword(passwordError)
        )

        if(state.emailError == null && state.passwordError == null)
        {
            viewModelScope.launch {
                signupWhitEmailUserCase(state.email,state.password)
                    .onSuccess{
                        state = state.copy(
                            isSignedIn = true
                        )
                    }
                    .onFailure{
                        state = state.copy(
                            emailError = it.message!!
                        )
                    }
            }
        } else {
            state = state.copy(
                isLoading = false
            )
        }
    }
}