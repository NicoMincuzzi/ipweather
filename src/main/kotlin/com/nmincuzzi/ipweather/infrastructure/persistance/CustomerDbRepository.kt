package com.nmincuzzi.ipweather.infrastructure.persistance

import com.nmincuzzi.ipweather.domain.CustomerRepository
import com.nmincuzzi.ipweather.domain.User

class CustomerDbRepository(private val customerEntityRepository: CustomerEntityRepository) : CustomerRepository {
    override fun save(user: User): String {
        return customerEntityRepository.save(user.toEntity()).id!!
    }

    override fun getById(id: String): User {
        val customer = customerEntityRepository.getReferenceById(id)
        return User.from(customer)
    }
}
