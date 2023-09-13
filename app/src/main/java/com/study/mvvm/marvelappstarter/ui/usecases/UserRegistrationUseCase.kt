package com.study.mvvm.marvelappstarter.ui.usecases

class UserRegistrationUseCase( // Use case to Register and validate user's
    private val userRepositoryTest: UserRepositoryTest,
    private val emailValidatorTest: EmailValidatorTest
) {
    // fun to register with e-mail and password received by parameter, that return a RegistrationResult
    fun registerUser(email: String, password: String): RegistrationResult {
        //Condition if email is not valid, returns a registration result with InvalidEmail
        if (!emailValidatorTest.isValid(email)) {
            return RegistrationResult.InvalidEmail
        }
        //Condition if userExists == true Return UserAlreadyExists
        val userExists = userRepositoryTest.doesUserExist(email)
        if (userExists) {
            return RegistrationResult.UserAlreadyExists
        }

        //Return saveUser when e-mail is valid and doesnt exist
        val user = User(email, password)
        userRepositoryTest.saveUser(user)
        return RegistrationResult.Success(user)
    }
}

interface UserRepositoryTest {
    fun doesUserExist(email: String): Boolean
    fun saveUser(user: User)
}

interface EmailValidatorTest {
    fun isValid(email: String): Boolean
}

sealed class RegistrationResult {
    object InvalidEmail : RegistrationResult()
    object UserAlreadyExists : RegistrationResult()
    data class Success(val user: User) : RegistrationResult()
}

data class User(val email: String, val password: String)