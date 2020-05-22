package com.chili.pockotlin.controller

import com.chili.pockotlin.model.BookModel
import com.chili.pockotlin.representation.BookRepresentation
import kotlin.reflect.full.memberProperties

/*Extension Functions
* https://kotlinlang.org/docs/reference/extensions.html
*/
fun BookModel.toBookRepresentation() = BookRepresentation(
        id = id,
        name = title,
        year = publishedDate
)

/*Kotlin Reflection
* https://kotlinlang.org/docs/reference/reflection.html
*/
fun BookModel.toUserViewReflection() = with(::BookRepresentation) {
    val propertiesByName = BookModel::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            BookRepresentation::id.name -> id
            BookRepresentation::name.name -> name
            BookRepresentation::year.name -> publishedDate
            else -> propertiesByName[parameter.name]?.get(this@toUserViewReflection)
        }
    })
}