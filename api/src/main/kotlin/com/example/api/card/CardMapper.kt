package com.example.api.card

// Defining extension method for mapping between normal
// objects and dtos

fun Card.toDTO() = CardDTO(
    id = id,
    title = title,
    description = description,
    assignment = assignment.map { it.id },
    content = content,
    createdAt = createdAt,
    authorId = author?.id ?: throw IllegalStateException("Card must have an author")
)
