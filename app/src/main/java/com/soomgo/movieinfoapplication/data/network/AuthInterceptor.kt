package com.soomgo.movieinfoapplication.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request().newBuilder()

        val finalToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZWFkYzBmYjM5MGQzZTY0YjBiMmQxODAzZjVmMDU0OSIsInN1YiI6IjYxMTc1NDNiMTUxYzVjMDA3MzJhMjZkMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-6PEDWehkdmC2-9nc5yXEYqzCIY-C7NREw6c7cusxqA"

        request.addHeader("Authorization", "Bearer $finalToken")

        return chain.proceed(request.build())


    }
}