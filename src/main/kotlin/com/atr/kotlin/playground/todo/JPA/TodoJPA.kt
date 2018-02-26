package com.atr.kotlin.playground.todo.JPA

import com.atr.kotlin.playground.todo.TodoValidationException
import javax.persistence.*


@Entity
@Table(name = "todos")
data class TodoJPA(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
                   var name: String = "",
                   var completed: Boolean = false) {

    fun validate() {
        val errors = mutableListOf<String>()
        if (name.isEmpty()) errors.add("TodoJPA.model is empty")
        if (errors.isNotEmpty()) throw TodoValidationException("Invalid Device", errors)
    }
}

