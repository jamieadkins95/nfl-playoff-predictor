package com.jamieadkins.nfl.predictor.data

import com.jamieadkins.nfl.predictor.domain.GameWeekEntity
import com.jamieadkins.nfl.predictor.domain.MatchEntity
import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import com.jamieadkins.nfl.predictor.domain.MatchesRepository
import com.jamieadkins.nfl.predictor.domain.TeamEntity
import io.reactivex.Observable
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val footballService: FootballService
) : MatchesRepository {

    override fun getMatches(season: Int): Observable<List<GameWeekEntity>> {
       return footballService.scoreboard(1000, "20190801-20190901")
           .map { from ->
               val matches = from.events.map { event ->
                   val home = event.competitions.first().competitors.first { it.homeAway == "home" }
                   val away = event.competitions.first().competitors.first { it.homeAway == "away" }
                   val homeTeam = TeamEntity(1, home.team.name, home.team.abbreviation, home.team.logo)
                   val awayTeam = TeamEntity(1, away.team.name, away.team.abbreviation, away.team.logo)

                   val outcome = when(event.competitions.first().competitors.firstOrNull { it.winner }?.homeAway) {
                       "home" -> MatchOutcomeEntity.HomeTeamWin
                       "away" -> MatchOutcomeEntity.AwayTeamWin
                       else -> MatchOutcomeEntity.Undecided
                   }

                   MatchEntity(event.id, homeTeam, awayTeam, outcome)
               }
               listOf(GameWeekEntity(matches))
           }
           .toObservable()
    }
}