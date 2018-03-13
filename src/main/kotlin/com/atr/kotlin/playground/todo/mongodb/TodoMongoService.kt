package com.atr.kotlin.playground.todo.mongodb

import com.atr.kotlin.playground.todo.JPA.TodoJPA
import org.springframework.stereotype.Service

@Service("todoMongoService")
class TodoMongoService(private val todoMongoRepository: TodoMongoRepository) {

    fun findAllTodos(): List<TodoMongo> = todoMongoRepository.findAll()

    fun findTodobyId(id: Long): TodoMongo = todoMongoRepository.findOne(id)

    fun createTodoMongo(todoJPA: TodoMongo): TodoMongo = todoMongoRepository.save(todoJPA)

    fun updateTodoMongo(todoJPA: TodoMongo): TodoMongo = todoMongoRepository.save(todoJPA)

    fun deleteTodoMongoById(id: Long) = todoMongoRepository.delete(id)

    fun deleteAllTodos() = todoMongoRepository.deleteAll()

}
