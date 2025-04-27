package com.example.api.card

import com.example.api.auth.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class CardService(
    private val cardRepository: CardRepository
) {
    fun getAllCards(request: GetAllCardsRequest): GetAllCardsResponse {
        val cards = cardRepository.findAll()
        return GetAllCardsResponse(
            cards = cards.map { it.toDTO() }
        )
    }

    fun getCardById(request: GetCardByIdRequest): GetCardByIdResponse {
        val card = cardRepository.findById(id = request.id)
            .orElseThrow { NoSuchElementException("Card not found with id: ${request.id}") }
        return GetCardByIdResponse(card = card.toDTO())
    }

    fun createCard(request: CreateCardRequest): CreateCardResponse {
        val card = Card(
            id = UUID.randomUUID(),
            title = request.title,
            description = request.description,
            assignment = listOf(
                User(UUID.randomUUID(), "IMPLEMENT LOGIC"),
            ),
            content = request.content,
            createdAt = LocalDateTime.now(),
            author = User(UUID.randomUUID(), "IMPLEMENT LOGIC"),
        )

        val savedCard = cardRepository.save(card)
        return CreateCardResponse(card = savedCard.toDTO())
    }

    fun updateCard(id: UUID, request: UpdateCardRequest): UpdateCardResponse {
        val existingCard = cardRepository.findById(id)
            .orElseThrow { NoSuchElementException("Card not found with id: $id") }

        val updatedCard = existingCard.copy(
            title = request.title,
            description = request.description,
            assignment = listOf(
                User(UUID.randomUUID(), "IMPLEMENT LOGIC"),
            ),
            content = request.content
        )

        val savedCard = cardRepository.save(updatedCard)
        return UpdateCardResponse(card = savedCard.toDTO())
    }

    fun deleteCard(request: DeleteCardByIdRequest): DeleteCardByIdReponse {
        if (!cardRepository.existsById(request.id)) {
            throw NoSuchElementException("Card not found with id: ${request.id}")
        }

        cardRepository.deleteById(request.id)
        return DeleteCardByIdReponse(id = request.id)
    }
}