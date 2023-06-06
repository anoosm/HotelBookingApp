package com.example.hotelbookingapp.model

data class Option(
    val choices: List<Choice>,
    val enhancedChoices: List<EnhancedChoice>,
    val itemMeta: String,
    val label: String,
    val selectedChoiceLabel: String
)