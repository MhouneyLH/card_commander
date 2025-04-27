package com.example.api.auth

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
data class User(@Id val id: UUID, val name: String)