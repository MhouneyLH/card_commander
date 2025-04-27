package com.example.api.card

import com.example.api.auth.User
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import java.util.*

@Entity
data class Card(
    @Id val id: UUID,
    val title: String,
    val description: String,
    val assignment: List<User>,
    val content: String,
    val createdAt: LocalDateTime,
    @ManyToOne val author: User,
)