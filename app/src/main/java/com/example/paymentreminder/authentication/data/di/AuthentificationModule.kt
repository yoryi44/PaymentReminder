package com.example.paymentreminder.authentication.data.di

import com.example.paymentreminder.authentication.data.matcher.EmailMatcherImpl
import com.example.paymentreminder.authentication.data.repository.AuthentificationRepositoryImpl
import com.example.paymentreminder.authentication.domain.EmailMatcher.EmailMatcher
import com.example.paymentreminder.authentication.domain.repository.Authentificationrepository
import com.example.paymentreminder.authentication.domain.usecase.GetUserIdUseCase
import com.example.paymentreminder.authentication.domain.usecase.LoginWhitEmailUseCase
import com.example.paymentreminder.authentication.domain.usecase.ValidateEmailUseCase
import com.example.paymentreminder.authentication.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthentificationModule {

    @Provides
    @Singleton
    fun provideValidateEmailUseCase(emailMatcher: EmailMatcher) : ValidateEmailUseCase {
        return ValidateEmailUseCase(emailMatcher)
    }

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase() : ValidatePasswordUseCase {
        return ValidatePasswordUseCase()
    }

    @Provides
    @Singleton
    fun provideEmailMatcher() : EmailMatcher {
        return EmailMatcherImpl()
    }

    @Provides
    @Singleton
    fun provideLoginWhitEmailUseCase(authentificationrepository: Authentificationrepository) : LoginWhitEmailUseCase {
        return LoginWhitEmailUseCase(authentificationrepository)
    }

    @Provides
    @Singleton
    fun provideGetUserIdUseCase(authentificationrepository: Authentificationrepository) : GetUserIdUseCase {
        return GetUserIdUseCase(authentificationrepository)
    }

    @Provides
    @Singleton
    fun provideAuthentificationRepository() : Authentificationrepository {
        return AuthentificationRepositoryImpl()
    }

}