package com.example.finalboss

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class listen {
    @get:Rule
    val lemons = createComposeRule()
    @Test
    fun clash(){
        lemons.setContent{
            MyNavigation()
        }
    }
}