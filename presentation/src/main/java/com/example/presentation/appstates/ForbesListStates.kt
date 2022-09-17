package com.example.presentation.appstates

import com.example.domain.models.*

data class ForbesListStates(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String = "",
    val allForbes: List<AllForbes> = emptyList(),
    val female: List<Female> = emptyList(),
    val industry: List<Industry> = emptyList(),
    val males: List<Males> = emptyList(),
    val oldest: List<Oldest> = emptyList(),
    val youngest: List<Youngest> = emptyList(),
)
