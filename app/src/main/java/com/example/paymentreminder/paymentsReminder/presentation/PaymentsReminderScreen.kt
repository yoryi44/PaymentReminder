package com.example.paymentreminder.paymentsReminder.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.paymentreminder.R
import com.example.paymentreminder.core.presentation.PaymentRemainderDropDwonMenu
import com.example.paymentreminder.core.presentation.PaymentReminderTextField
import com.example.paymentreminder.paymentsReminder.presentation.components.PaymentsReminderItem

@Composable
fun PaymentsReminderScreen(
    modifier: Modifier = Modifier,
    paymentsReminderViewModel: PaymentsReminderViewModel = hiltViewModel(),
    onPaymentReminderDetail: (Int) -> Unit
) {

    val focusManager = LocalFocusManager.current
    val state = paymentsReminderViewModel.state

    val options =
        listOf(stringResource(id = R.string.amount), stringResource(id = R.string.arrears))

    Column(
        modifier = modifier.background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.white)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PaymentReminderTextField(
                modifier = Modifier.fillMaxWidth(0.9f),
                label = stringResource(id = R.string.search),
                leadingIcon = Icons.Default.Search,
                value = state.search,
                keyboardActions = KeyboardActions(onAny = {
                    paymentsReminderViewModel.onEvent(PaymentsReminderEvent.OnSearch)
                    focusManager.clearFocus()
                }),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
            ) {
                paymentsReminderViewModel.onEvent(PaymentsReminderEvent.SearchChanged(it))
            }
            PaymentRemainderDropDwonMenu(modifier = modifier, "Filter", options) {
                paymentsReminderViewModel.onEvent(PaymentsReminderEvent.OnFilter(it))
            }
        }

        LazyColumn(
            modifier = Modifier
                .background(colorResource(id = R.color.ligth_gray))
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state.paymentsReminder.size) { item ->
                PaymentsReminderItem(paymentReminder = state.paymentsReminder[item]) {
                    paymentsReminderViewModel.onEvent(PaymentsReminderEvent.OnItemEdit(state.paymentsReminder[item].id))
                }
            }
        }

    }
}