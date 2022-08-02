package no.nav.aap.config

import no.nav.aap.kafka.streams.KStreamsConfig

data class Config(
    val kafka: KStreamsConfig
)