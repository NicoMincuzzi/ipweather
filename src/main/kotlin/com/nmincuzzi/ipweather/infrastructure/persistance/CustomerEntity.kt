package com.nmincuzzi.ipweather.infrastructure.persistance

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator


/*
As per the JPA specification, all JPA-related classes and properties must be `open`.
Some JPA providers don’t enforce this rule. For example, Hibernate does not throw an exception when it encounters a final entity class.
However, a final class cannot be subclassed, hence the proxying mechanism of Hibernate turns off. No proxies, no lazy loading.

Unlike Java, in Kotlin all classes, properties and methods are final by default. You have to explicitly mark them as `open`

Alternatively and preferably, you may use the `all-open` Kotlin compiler plugin to make all JPA-related classes and properties open by default.

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

*/

@Entity
@Table(name = "customer")
open class CustomerEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    open var id: String? = null

    @Column(name = "first_name", nullable = false)
    open var firstName: String? = null

    @Column(name = "last_name", nullable = false)
    open var lastName: String? = null
}

