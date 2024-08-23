package com.example.paymentreminder.paymentsReminder.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.domain.usecase.GetPaymentsReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsReminderViewModel @Inject constructor(
    private val getPaymentsReminderUseCase: GetPaymentsReminderUseCase
) : ViewModel() {

    var state by mutableStateOf(PaymentsReminderState())
        private set

    init {
        getPaymentsReminder()
    }

    fun onEvent(event: PaymentsReminderEvent) {
        when (event) {
            is PaymentsReminderEvent.OnFilter -> {

            }

            is PaymentsReminderEvent.OnSearch -> {

            }
        }
    }

    private fun getPaymentsReminder() {
        viewModelScope.launch {
            getPaymentsReminderUseCase().collectLatest {
                state = state.copy(
                    paymentsReminder = it
                )
            }
        }
    }

}