package com.example.myapplication.Components

fun formatPhoneNumber(input: String): String {
    val digits = input.filter { it.isDigit() }

    return when {
        digits.length <= 10 -> {
            digits.chunked(1).joinToString("").let {
                when (digits.length) {
                    in 1..2 -> "(${it}"
                    in 3..6 -> "(${it.substring(0, 2)}) ${it.substring(2)}"
                    in 7..10 -> "(${it.substring(0, 2)}) ${it.substring(2, 6)}-${it.substring(6)}"
                    else -> it
                }
            }
        }
        else -> {
            digits.chunked(1).joinToString("").let {
                when (digits.length) {
                    in 1..2 -> "(${it}"
                    in 3..7 -> "(${it.substring(0, 2)}) ${it.substring(2)}"
                    in 8..11 -> "(${it.substring(0, 2)}) ${it.substring(2, 7)}-${it.substring(7)}"
                    else -> it
                }
            }
        }
    }
}

