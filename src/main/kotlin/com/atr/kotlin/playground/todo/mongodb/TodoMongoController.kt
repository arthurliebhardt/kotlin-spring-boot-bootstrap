package com.atr.kotlin.playground.todo.mongodb

import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(API)
@Api(value = "todoMongoController", description = "CRUD Operations for the todoMongo ")
class TodoMongoController(private val todoMongoService: TodoMongoService) {

    @GetMapping(API_TODO)
    fun findAllTodos(): ResponseEntity<Iterable<TodoMongo>> = ResponseEntity(todoMongoService.findAllTodos(), HttpStatus.OK)

    @GetMapping(API_TODO_ID)
    fun findTodoById(@PathVariable id: Long): ResponseEntity<TodoMongo> {
        val todo: TodoMongo? = todoMongoService.findTodobyId(id)
        return if (todo != null) ResponseEntity(todo, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping(API_TODO)
    fun createTodo(@RequestBody todo: TodoMongo): ResponseEntity<TodoMongo> {
        todo.validate()
        return ResponseEntity(todoMongoService.createTodoMongo(todo), HttpStatus.CREATED)
    }

    @PutMapping(API_TODO_ID)
    fun updateTodoById(@PathVariable id: Long, @RequestBody todo: TodoMongo): ResponseEntity<TodoMongo> {
        todo.validate()
        val existingTodo: TodoMongo? = todoMongoService.findTodobyId(id)
        return if (existingTodo != null) ResponseEntity(todoMongoService.updateTodoMongo(todo), HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping(API_TODO_ID)
    fun deleteTodoById(@PathVariable id: Long): ResponseEntity<Unit> = ResponseEntity(todoMongoService.deleteTodoMongoById(id), HttpStatus.NO_CONTENT)

    @DeleteMapping(API_TODO)
    fun deleteAll(): ResponseEntity<Unit> = ResponseEntity(todoMongoService.deleteAllTodos(), HttpStatus.NO_CONTENT)
}