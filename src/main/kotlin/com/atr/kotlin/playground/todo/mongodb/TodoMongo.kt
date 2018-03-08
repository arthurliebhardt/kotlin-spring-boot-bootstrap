package com.atr.kotlin.playground.todo.mongodb

import com.atr.kotlin.playground.todo.TodoValidationException
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document
class TodoMongo(@Id val id: String? = null,
                var name: String = "", var completed: Boolean = false) {

    fun validate() {
        val errors = mutableListOf<String>()
        if (name.isEmpty()) errors.add("Todo.model is empty")
        if (errors.isNotEmpty()) throw TodoValidationException("Invalid Device", errors)
    }
}