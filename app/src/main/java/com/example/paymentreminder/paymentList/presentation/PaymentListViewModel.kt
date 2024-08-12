package com.example.paymentreminder.paymentList.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.paymentreminder.paymentList.presentation.components.PaymentListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentListViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(PaymentListState())
        private set

    fun onEvent(event: PaymentListEvent) {
        when (event) {
            is PaymentListEvent.OnFilter -> {

            }

            is PaymentListEvent.OnSearch -> {

            }
        }
    }
}