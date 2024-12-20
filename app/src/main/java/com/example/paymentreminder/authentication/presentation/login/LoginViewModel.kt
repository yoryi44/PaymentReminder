package com.example.paymentreminder.authentication.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentreminder.authentication.domain.usecase.LoginWhitEmailUseCase
import com.example.paymentreminder.authentication.domain.usecase.ValidateEmailUseCase
import com.example.paymentreminder.authentication.domain.usecase.ValidatePasswordUseCase
import com.example.paymentreminder.authentication.presentation.util.ParserErrorPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWhitEmailUseCase: LoginWhitEmailUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent)
    {
        when(event) {
            is LoginEvent.EmailChanged -> {
                state = state.copy(
                    email = event.email
                )
            }

            LoginEvent.Login -> {
                login()
            }
            is LoginEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
        }
    }

    fun login()
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
                loginWhitEmailUseCase(state.email,state.password)
                    .onSuccess{
                        state = state.copy(
                            isLoggedIn = true
                        )
                    }
                    .onFailure{
                        state = state.copy(
                            emailError = it.message!!
                        )
                        state = state.copy(
                            isLoading = false
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