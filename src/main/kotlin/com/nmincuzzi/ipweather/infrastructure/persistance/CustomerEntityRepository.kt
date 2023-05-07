package com.nmincuzzi.ipweather.infrastructure.persistance

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerEntityRepository : JpaRepository<CustomerEntity, String>
