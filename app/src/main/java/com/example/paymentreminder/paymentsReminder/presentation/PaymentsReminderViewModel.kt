package com.example.paymentreminder.paymentsReminder.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.domain.usecase.GetPaymentsReminderSearchUseCase
import com.example.paymentreminder.paymentsReminder.domain.usecase.GetPaymentsReminderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentsReminderViewModel @Inject constructor(
    private val getPaymentsReminderUseCase: GetPaymentsReminderUseCase,
    private val getPaymentsReminderSearchUseCase: GetPaymentsReminderSearchUseCase
) : ViewModel() {

    
    var state by mutableStateOf(PaymentsReminderState())
        private set

    init {
        getPaymentsReminder()
    }

    fun onEvent(event: PaymentsReminderEvent) {
        when (event) {
            is PaymentsReminderEvent.OnFilter -> {

                val filtro = if((event.filter == "Amount") || event.filter == "Valor") {
                    "amount"
                } else {
                    "dueDate"
                }
                getPaymentsReminderSearch(state.search, filtro)
            }

            is PaymentsReminderEvent.OnSearch -> {
                getPaymentsReminderSearch(state.search, "amount")
            }

            is PaymentsReminderEvent.OnItemEdit -> {

            }

            is PaymentsReminderEvent.SearchChanged -> {
                state = state.copy(
                    search = event.search
                )
            }
        }
    }

    private fun getPaymentsReminderSearch(searchQuery: String, orderBy : String) {
        viewModelScope.launch {
            getPaymentsReminderSearchUseCase(searchQuery, orderBy).collectLatest {
                state = state.copy(
                    paymentsReminder = it
                )
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