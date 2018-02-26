package com.atr.kotlin.playground.todo.JPA

import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(API)
@Api(value = "todoJPAController", description = "CRUD Operations for the todoJPA ")
class TodoJPAController(private val todoJPAService: TodoJPAService) {

    @GetMapping(API_TODOJPA)
    fun findAllTodoJPAs(): ResponseEntity<Iterable<TodoJPA>> = ResponseEntity(todoJPAService.findAllTodoJPAs(), HttpStatus.OK)

    @GetMapping(API_TODOJPA_NAME)
    fun findTodoJPAByModel(@PathVariable name: String): ResponseEntity<TodoJPA> {
        val todoJPA: TodoJPA? = todoJPAService.findTodoJPAbyName(name)
        return if (todoJPA != null) ResponseEntity(todoJPA, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping(API_TODOJPA_ID)
    fun findTodoJPAById(@PathVariable id: Long): ResponseEntity<TodoJPA> {
        val todoJPA: TodoJPA? = todoJPAService.findTodoJPAbyId(id)
        return if (todoJPA != null) ResponseEntity(todoJPA, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping(API_TODOJPA)
    fun createTodoJPA(@RequestBody todoJPA: TodoJPA): ResponseEntity<TodoJPA> {
        todoJPA.validate()
        return ResponseEntity(todoJPAService.createTodoJPA(todoJPA), HttpStatus.CREATED)
    }

    @PutMapping(API_TODOJPA_NAME)
    fun updateTodoJPAByName(@PathVariable name: String, @RequestBody todoJPA: TodoJPA): ResponseEntity<TodoJPA> {
        todoJPA.validate()
        val existingTodoJPA: TodoJPA? = todoJPAService.findTodoJPAbyName(name)
        return if (existingTodoJPA != null) ResponseEntity(todoJPAService.updateTodoJPA(todoJPA.copy(name = name)), HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PutMapping(API_TODOJPA_ID)
    fun updateTodoJPAById(@PathVariable id: Long, @RequestBody todoJPA: TodoJPA): ResponseEntity<TodoJPA> {
        todoJPA.validate()
        val existingTodoJPA: TodoJPA? = todoJPAService.findTodoJPAbyId(id)
        return if (existingTodoJPA != null) ResponseEntity(todoJPAService.updateTodoJPA(todoJPA.copy(id = id)), HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping(API_TODOJPA_NAME)
    fun deleteTodoJPAByName(@PathVariable name: String): ResponseEntity<Unit> = ResponseEntity(todoJPAService.deleteTodoJPAByName(name), HttpStatus.NO_CONTENT)

    @DeleteMapping(API_TODOJPA_ID)
    fun deleteTodoJPAById(@PathVariable id: Long): ResponseEntity<Unit> = ResponseEntity(todoJPAService.deleteTodoJPAById(id), HttpStatus.NO_CONTENT)

    @DeleteMapping(API_TODOJPA)
    fun deleteAll(): ResponseEntity<Unit> = ResponseEntity(todoJPAService.deleteAllTodoJPAs(), HttpStatus.NO_CONTENT)
}
