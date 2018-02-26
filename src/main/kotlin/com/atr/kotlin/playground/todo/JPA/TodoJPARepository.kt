package com.atr.kotlin.playground.todo.JPA

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoJPARepository : JpaRepository<TodoJPA, Long> {

    fun findByName(name: String): TodoJPA

    fun deleteByName(name: String)

}