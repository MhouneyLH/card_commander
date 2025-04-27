package com.example.api.card

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cards")
class CardController(private val cardService: CardService) {
    @GetMapping
    @Operation(summary = "Get all cards", description = "Returns a list of all cards available.")
    fun getAllCards(@ModelAttribute request: GetAllCardsRequest): GetAllCardsResponse =
        cardService.getAllCards(request)

    @GetMapping("/{id}")
    @Operation(summary = "Get card by ID", description = "Returns a single card by its ID.")
    fun getCardById(@PathVariable id: UUID): GetCardByIdResponse {
        return cardService.getCardById(GetCardByIdRequest(id))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new card", description = "Creates a new card and returns it.")
    fun createCard(@Valid @RequestBody request: CreateCardRequest): CreateCardResponse {
        return cardService.createCard(request)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing card", description = "Updates an existing card and returns it.")
    fun updateCard(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateCardRequest
    ): UpdateCardResponse {
        return cardService.updateCard(id, request)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete card", description = "Deletes a card by its ID.")
    fun deleteCardById(@PathVariable id: UUID): DeleteCardByIdReponse {
        return cardService.deleteCard(DeleteCardByIdRequest(id))
    }
}