package com.atr.kotlin.playground.todo.JPA

import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
//@JsonIgnoreProperties(value = {"createdDate", "modifiedDate"},
//        allowGetters = true)
abstract class AbstractJPAEntity {

    @Column(nullable = false, updatable = false)
    @CreatedDate
    protected var createdDate: Date? = null

    @Column(nullable = false)
    @LastModifiedDate
    protected var modifiedDate: Date? = null
}
