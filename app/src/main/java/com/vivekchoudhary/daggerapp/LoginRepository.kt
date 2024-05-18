package com.vivekchoudhary.daggerapp

import javax.inject.Inject

interface LoginRepository {
    fun getApiData() : String
}

class LoginRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : LoginRepository{

    override fun getApiData() : String {
        return localDataSource.getApiData()
    }
}