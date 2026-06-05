package com.workshipflow.app.core.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    // 1. Mude para a URL local do seu servidor ou servidor de testes
    private const val BASE_URL = "https://sua-api-aqui.com/api/"

    // O lazy garante que a infraestrutura de rede só seja criada na primeira chamada
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            // Configurações de segurança para conexões instáveis
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            // Interceptor de Logs (Agora vai funcionar!)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instância única do seu serviço pronta para uso
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}