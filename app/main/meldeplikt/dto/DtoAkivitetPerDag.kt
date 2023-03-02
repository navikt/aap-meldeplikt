package meldeplikt.dto

import java.time.LocalDate

data class DtoAkivitetPerDag(
    val dato: LocalDate,
    val arbeidstimer: Double,
    val fraværsdag: Boolean
)
