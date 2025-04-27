package com.example.api.card

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.*

data class GetAllCardsRequest(val sortDirection: String = "ASC")

data class GetAllCardsResponse(val cards: List<CardDTO>)

data class GetCardByIdRequest(
    val id: UUID
)

data class GetCardByIdResponse(
    val card: CardDTO
)

data class CreateCardRequest(
    @field:NotBlank
    val title: String,

    @field:NotBlank
    val description: String,

    @field:NotEmpty
    val assignment: List<UUID>,

    @field:NotBlank
    val content: String,

    @field:NotNull
    val authorId: UUID
)

data class CreateCardResponse(
    val card: CardDTO
    // todo: add general status handling
)

data class UpdateCardRequest(
    @field:NotBlank
    val title: String,

    @field:NotBlank
    val description: String,

    @field:NotEmpty
    val assignment: List<UUID>,

    @field:NotBlank
    val content: String
)

data class UpdateCardResponse(
    val card: CardDTO,
)

data class DeleteCardByIdRequest(
    val id: UUID
)

data class DeleteCardByIdReponse(
    val id: UUID
)