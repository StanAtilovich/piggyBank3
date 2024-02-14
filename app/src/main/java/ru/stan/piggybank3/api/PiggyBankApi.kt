package ru.stan.piggybank3.api

import retrofit2.http.GET
import ru.stan.piggybank3.data.Piggybank

interface PiggyBankApi {
    @GET("/v3/a3ffe944-a095-4ba1-9092-7feff03e5c09")
    suspend fun getPiggyBankById(): Piggybank
}
