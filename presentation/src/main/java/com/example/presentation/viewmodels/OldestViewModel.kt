package com.example.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.core.Resource
import com.example.domain.usecase.OldestUseCase
import com.example.presentation.appstates.ForbesListStates
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class OldestViewModel @Inject constructor(
    private val oldestUseCase: OldestUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ForbesListStates())
    val state: State<ForbesListStates> = _state

    init {
        getOldest()
    }

    private  fun getOldest() {
        oldestUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ForbesListStates(oldest = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ForbesListStates(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ForbesListStates(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}