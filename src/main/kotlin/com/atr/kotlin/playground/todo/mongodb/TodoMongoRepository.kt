package com.atr.kotlin.playground.todo.mongodb

import org.springframework.data.mongodb.repository.MongoRepository

interface TodoMongoRepository : MongoRepository<TodoMongo, Long>