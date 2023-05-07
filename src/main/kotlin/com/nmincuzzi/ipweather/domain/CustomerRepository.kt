package com.nmincuzzi.ipweather.domain

interface CustomerRepository {
    fun save(user: User): String
    fun getById(id: String): User
}
