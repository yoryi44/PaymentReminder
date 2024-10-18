package com.example.paymentreminder.detail.presentation

import android.annotation.SuppressLint
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.paymentreminder.R
import com.example.paymentreminder.core.model.PaymentCategories
import com.example.paymentreminder.core.presentation.PaymentRemainderButton
import com.example.paymentreminder.core.presentation.PaymentReminderSelect
import com.example.paymentreminder.core.presentation.PaymentReminderTextField
import com.example.paymentreminder.core.presentation.PaymentReminderTitle
import com.example.paymentreminder.core.presentation.PaymentreminderCircularProgressIndicator
import com.example.paymentreminder.ui.theme.Blue700
import java.util.Calendar

@SuppressLint("DefaultLocale")
@Composable
fun DetailScreen(
    paymentReminderId: String?,
    detailViewModel: DetailViewModel = hiltViewModel(),
    onSave : () -> Unit,
) {

    val state = detailViewModel.state
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val options = PaymentCategories.categories.keys.toList()

    LaunchedEffect(key1 = state.isSave) {
        if(state.isSave) {
            onSave()
        }
    }

    LaunchedEffect(key1 = paymentReminderId) {
        if(!paymentReminderId.isNullOrBlank())
        {
            detailViewModel.onEvent(DetailEvent.idChanged(paymentReminderId))
        }
    }

    //DIALOGO PARA SELECCIONAR LA FECHA
    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            val formattedDay = String.format("%02d", selectedDay)
            val formattedMonth = String.format("%02d", selectedMonth + 1)
            detailViewModel.onEvent(DetailEvent.dueDateChanged("$selectedYear-${formattedMonth}-$formattedDay"))
        }, year, month, day
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        //PAYMENT REMINDER DETAIL TITLE
        PaymentReminderTitle(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(R.string.detail_title),
            color = Color.Black,
            textAlign = TextAlign.Center,
        )

        if(state.isLoading)
        {
            PaymentreminderCircularProgressIndicator()
        }
        else
        {
            //PAYMENT REMINDER DETAIL FORM
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f).padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                //
                PaymentReminderTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.amount),
                    value = state.amount.format(),
                    leadingIcon = Icons.Outlined.Edit,
                    keyboardType = KeyboardType.Number
                )
                {
                    detailViewModel.onEvent(DetailEvent.amountChanged(it))
                }

                PaymentReminderTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.due_date),
                    value = state.dueDate,
                    leadingIcon = Icons.Outlined.Edit
                )
                {
                    datePickerDialog.show()
                }

                PaymentReminderTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(R.string.notes),
                    value = state.notes ?: "",
                    leadingIcon = Icons.Outlined.Edit
                )
                {
                    detailViewModel.onEvent(DetailEvent.notesChanged(it))
                }

                PaymentReminderSelect(options = options, label = "options", category = state.category) {
                    DetailEvent.categoryChanged(it)
                }

            }
        }
        PaymentRemainderButton(modifier = Modifier.fillMaxWidth(), text = "Save", containerColor = Blue700) {
            detailViewModel.onEvent(DetailEvent.PaymentSave)
        }
    }

}