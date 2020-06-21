package com.jamieadkins.nfl.predictor.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScoreboardResponse(
    val leagues: List<LeagueResponse>,
    val events: List<EventResponse>
)

@JsonClass(generateAdapter = true)
data class LeagueResponse(
    val id: String,
    val name: String,
    val abbreviation: String
)

@JsonClass(generateAdapter = true)
data class EventResponse(
    val id: String,
    val name: String,
    val shortName: String,
    val competitions: List<CompetitionResponse>
)

@JsonClass(generateAdapter = true)
data class CompetitionResponse(
    val id: String,
    val competitors: List<CompetitorsResponse>
)

@JsonClass(generateAdapter = true)
data class CompetitorsResponse(
    val id: String,
    val homeAway: String,
    val winner: Boolean,
    val team: TeamResponse
)

@JsonClass(generateAdapter = true)
data class TeamResponse(
    val id: String,
    val name: String,
    val abbreviation: String,
    val logo: String
)