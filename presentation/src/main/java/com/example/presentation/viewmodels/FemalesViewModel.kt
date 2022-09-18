package com.example.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.core.Resource
import com.example.domain.usecase.FemaleUseCase
import com.example.presentation.appstates.ForbesListStates
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class FemalesViewModel @Inject constructor(
    private val femaleUseCase: FemaleUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ForbesListStates())
    val state: State<ForbesListStates> = _state

    init {
        getFemales()
    }

    private  fun getFemales() {
        femaleUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ForbesListStates(female = result.data ?: emptyList())
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