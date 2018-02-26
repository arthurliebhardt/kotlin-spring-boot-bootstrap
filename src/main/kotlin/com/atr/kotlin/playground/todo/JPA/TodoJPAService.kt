package com.atr.kotlin.playground.todo.JPA

import org.springframework.stereotype.Service

@Service("todoJPAService")
class TodoJPAService(private val todoJPARepository: TodoJPARepository) {

    fun findAllTodoJPAs(): List<TodoJPA> = todoJPARepository.findAll()

    fun findTodoJPAbyId(id: Long): TodoJPA = todoJPARepository.findOne(id)

    fun findTodoJPAbyName(name: String): TodoJPA = todoJPARepository.findByName(name)

    fun createTodoJPA(todoJPA: TodoJPA): TodoJPA = todoJPARepository.save(todoJPA)

    fun updateTodoJPA(todoJPA: TodoJPA): TodoJPA = todoJPARepository.save(todoJPA)

    fun deleteTodoJPAById(id: Long) = todoJPARepository.delete(id)

    fun deleteTodoJPAByName(name: String) = todoJPARepository.deleteByName(name)

    fun deleteAllTodoJPAs() = todoJPARepository.deleteAll()
}
