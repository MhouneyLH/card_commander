package com.example.api.card

import org.springframework.stereotype.Repository
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Repository
class CardRepository {
    private val cards = ConcurrentHashMap<UUID, Card>()

    fun findAll(): List<Card> = cards.values.toList()

    fun findById(id: UUID): Optional<Card> = Optional.ofNullable(cards[id])

    fun save(card: Card): Card {
        cards[card.id] = card
        return card
    }

    fun deleteById(id: UUID) {
        cards.remove(id)
    }

    fun existsById(id: UUID): Boolean = cards.containsKey(id)
}
