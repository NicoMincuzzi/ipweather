package com.nmincuzzi.ipweather.domain

import com.nmincuzzi.ipweather.infrastructure.persistance.CustomerEntity

class User {
    fun toEntity(): CustomerEntity {
        TODO("Not yet implemented")
    }

    companion object {
        fun from(customerEntity: CustomerEntity): User {
            TODO("Not yet implemented")
        }
    }
}
