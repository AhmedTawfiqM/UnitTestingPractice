package com.atdev.unittestingpractice

object RegistrationUtil {

    private val existedUserNames = listOf("Ahmed", "Mona", "Said", "Faten")

    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmedPassword: String,
    ): Boolean {
        if (userName.isNullOrEmpty()) return false
        if (password.isNullOrEmpty()) return false
        if (confirmedPassword.isNullOrEmpty()) return false
        if (existedUserNames.contains(userName)) return false
        if (userName in existedUserNames) return false
        if (password != confirmedPassword) return false
        if (password.length <= 2) return false
        //if ()

        return true
    }
}