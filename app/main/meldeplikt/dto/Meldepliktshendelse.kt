package meldeplikt.dto

import java.time.LocalDate
import java.util.Random

internal data class Meldepliktshendelse(
    val brukersAktivitet: List<BrukeraktivitetPerDag>
)

internal data class BrukeraktivitetPerDag(
    val dato: LocalDate,
    val arbeidstimer: Double,
    val fraværsdag: Boolean
)

internal fun createRandomHendelse() = Meldepliktshendelse (
    brukersAktivitet = (13L downTo 0).map {
        BrukeraktivitetPerDag(
            dato = LocalDate.now().minusDays(it),
            arbeidstimer = listOf(0.0, 3.0, 7.5).random(),
            fraværsdag = Random().nextInt() > 75
        )
    }
)