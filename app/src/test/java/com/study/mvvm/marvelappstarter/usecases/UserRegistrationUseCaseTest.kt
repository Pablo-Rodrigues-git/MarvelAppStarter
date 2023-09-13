package com.study.mvvm.marvelappstarter.usecases

import com.study.mvvm.marvelappstarter.ui.usecases.EmailValidatorTest
import com.study.mvvm.marvelappstarter.ui.usecases.RegistrationResult
import com.study.mvvm.marvelappstarter.ui.usecases.User
import com.study.mvvm.marvelappstarter.ui.usecases.UserRegistrationUseCase
import com.study.mvvm.marvelappstarter.ui.usecases.UserRepositoryTest
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test


class UserRegistrationUseCaseTest {
    //Mock userRepository and emailValidator
    private val userRepositoryTest: UserRepositoryTest = mockk(relaxed = true)
    private val emailValidatorTest: EmailValidatorTest = mockk(relaxed = true)
    private val userRegistrationUseCase = UserRegistrationUseCase(userRepositoryTest, emailValidatorTest)

    @Test
    fun `test valid email`() {
        // GIVEN
        // Mocking my repository and my emailValidator
        every { userRepositoryTest.doesUserExist(any()) } returns false
        every { emailValidatorTest.isValid(any()) } returns true

        // WHEN
        // Create the instance of the useCase
        // Call function registerUser() and save it into a variable, to use later
        val result = userRegistrationUseCase.registerUser("pablo.rodrigues@myunittest.com", "unittest")

        // THEN
        val expectedUser = User("pablo.rodrigues@myunittest.com", "unittest")
        // call the function and verify if the return is what is expected
        assertEquals(RegistrationResult.Success(expectedUser), result)
    }

    @Test
    fun `test invalid email`() {
        // GIVEN
        // Mocking my repository and my emailValidator
        every { userRepositoryTest.doesUserExist(any()) } returns false
        every { emailValidatorTest.isValid(any()) } returns false

        // WHEN
        // Create the instance of the useCase
        // Call function registerUser() and save it into a variable, to use later
        val result = userRegistrationUseCase.registerUser("pablo.rodrigues@myunittest..com", "unittest")

        // THEN
        // call the function and verify if the return is what is expected
        assertEquals(RegistrationResult.InvalidEmail, result)
    }

    @Test
    fun `test email already exist`() {
        // GIVEN
        // Mocking my repository and my emailValidator
        every { userRepositoryTest.doesUserExist(any()) } returns true
        every { emailValidatorTest.isValid(any()) } returns true

        // WHEN
        // Create the instance of the useCase
        // Call function registerUser() and save it into a variable, to use later
        val result = userRegistrationUseCase.registerUser("pablo.rodrigues@myunittest.com", "unittest")

        // THEN
        // call the function and verify if the return is what is expected
        result shouldBe RegistrationResult.UserAlreadyExists
    }

    @Test
    fun `test email already exist, and is not Valid`() {
        // GIVEN
        // Mocking my repository and my emailValidator
        every { userRepositoryTest.doesUserExist(any()) } returns true
        every { emailValidatorTest.isValid(any()) } returns true

        // WHEN
        // Create the instance of the useCase
        // Call function registerUser() and save it into a variable, to use later
        val result = userRegistrationUseCase.registerUser("pablo.rodrigues@myunittest.com", "unittest")

        // THEN
        // call the function and verify if the return is what is expected
        result shouldBe RegistrationResult.UserAlreadyExists
    }
}