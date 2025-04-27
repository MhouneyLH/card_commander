package com.example.api.card

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class User(@Id val id: UUID, val name: String)