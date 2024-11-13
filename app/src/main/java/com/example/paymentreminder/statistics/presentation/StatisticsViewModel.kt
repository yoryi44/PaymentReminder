package com.example.paymentreminder.statistics.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentreminder.statistics.domain.usecase.GetStatisticsUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val getStatisticsUserCase: GetStatisticsUserCase
): ViewModel() {

    var state by mutableStateOf(StatisticsState())

    init {
        viewModelScope.launch {
                state = state.copy(
                    statistics = getStatisticsUserCase()
                )
        }
    }

}