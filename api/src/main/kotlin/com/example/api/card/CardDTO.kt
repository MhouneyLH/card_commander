package com.example.api.card

import java.time.LocalDateTime
import java.util.*

data class CardDTO(
    val id: UUID,
    val title: String,
    val description: String,
    val assignment: List<UUID>,
    val content: String,
    val createdAt: LocalDateTime,
    val authorId: UUID
)
