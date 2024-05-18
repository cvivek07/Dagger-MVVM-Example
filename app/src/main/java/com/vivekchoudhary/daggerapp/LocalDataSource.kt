package com.vivekchoudhary.daggerapp

import javax.inject.Inject

class LocalDataSource @Inject constructor() {


    fun getApiData() = "Dagger"
}