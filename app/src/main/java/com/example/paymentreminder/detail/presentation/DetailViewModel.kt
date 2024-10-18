package com.example.paymentreminder.detail.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentreminder.detail.domain.usecase.GetPaymentReminderByIdUseCase
import com.example.paymentreminder.detail.domain.usecase.InsertPaymentReminderUseCase
import com.example.paymentreminder.extensionFunctions.numberFormatToString
import com.example.paymentreminder.extensionFunctions.toNumberFormat
import com.example.paymentreminder.home.presentation.models.PaymentReminderDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPaymentReminderByIdUseCase: GetPaymentReminderByIdUseCase,
    private val insertPaymentReminderUseCase: InsertPaymentReminderUseCase
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.amountChanged -> {
                state = state.copy(
                    amount = event.amount.numberFormatToString().toNumberFormat()
                )
            }

            is DetailEvent.dueDateChanged -> {
                state = state.copy(
                    dueDate = event.dueDate
                )
            }

            is DetailEvent.notesChanged -> {
                state = state.copy(
                    notes = event.notes
                )
            }

            is DetailEvent.categoryChanged -> {
                state = state.copy(
                    category = event.category
                )
            }

            DetailEvent.PaymentSave -> {
                viewModelScope.launch {

                    val payment = PaymentReminderDetail(
                        id = state.id.takeIf { it.isNotEmpty() } ?: UUID.randomUUID().toString(),
                        userId = state.userId,
                        amount = state.amount.numberFormatToString(),
                        currency = state.currency,
                        dueDate = state.dueDate,
                        reminderDate = state.reminderDate,
                        status = state.status,
                        category = state.category,
                        notes = state.notes,
                        createdAt = state.createdAt.takeIf { it.isNotEmpty() } ?: LocalDate.now()
                            .toString(),
                        updatedAt = state.updatedAt,
                        arrears = 0
                    )
                    insertPaymentReminderUseCase(payment)
                }
                state = state.copy(
                    isSave = true
                )
            }

            is DetailEvent.idChanged -> {
                state = state.copy(
                    id = event.id
                )
                viewModelScope.launch {

                    isLoading()

                    val detail = getPaymentReminderByIdUseCase(state.id)

                    state = state.copy(
                        id = detail.id,
                        userId = detail.userId,
                        amount = detail.amount.toNumberFormat(),
                        currency = detail.currency,
                        dueDate = detail.dueDate,
                        reminderDate = detail.reminderDate,
                        status = detail.status,
                        category = detail.category,
                        notes = detail.notes,
                        createdAt = detail.createdAt,
                        updatedAt = detail.updatedAt,
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun isLoading() {
        state = state.copy(
            isLoading = true
        )
    }

}