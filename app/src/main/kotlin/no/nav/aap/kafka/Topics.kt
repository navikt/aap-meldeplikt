package no.nav.aap.kafka

import no.nav.aap.kafka.serde.json.JsonSerde
import no.nav.aap.kafka.streams.Topic
import no.nav.aap.meldeplikt.DtoMeldepliktshendelse


object Topics {
    val meldeplikt = Topic("aap.meldeplikt.v1", JsonSerde.jackson<DtoMeldepliktshendelse>())
}