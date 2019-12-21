package com.jamieadkins.nfl.predictor.domain

data class TeamEntity(
    val id: Long,
    val name : String,
    val abbreviation: String,
    val logoUrl: String
)