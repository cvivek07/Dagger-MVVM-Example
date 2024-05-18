package com.vivekchoudhary.daggerapp.di

import com.vivekchoudhary.daggerapp.LocalDataSource
import com.vivekchoudhary.daggerapp.LoginActivity
import com.vivekchoudhary.daggerapp.LoginRepository
import com.vivekchoudhary.daggerapp.LoginRepositoryImpl
import com.vivekchoudhary.daggerapp.MyApplication
import com.vivekchoudhary.daggerapp.RemoteDataSource
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [DataSourceModule::class, SubcomponentsModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    fun loginComponent() : LoginComponent.Factory

}

@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
}

@Module(subcomponents = [LoginComponent::class])
class SubcomponentsModule {}


@Module
abstract class LoginModule {

    @Binds // binds is used because LoginRepository is an interface and we cannot create objects of interface
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

}

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource() = LocalDataSource()

    @Singleton
    @Provides
    fun provideRemoteDataSource() = RemoteDataSource()
}