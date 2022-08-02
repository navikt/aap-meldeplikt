package no.nav.aap.meldeplikt

import java.time.LocalDate

data class DtoAkivitetPerDag(
    val dato: LocalDate,
    val arbeidstimer: Double,
    val fraværsdag: Boolean
)
