package meldeplikt

import no.nav.aap.kafka.streams.v2.Topic
import no.nav.aap.kafka.streams.v2.serde.JsonSerde
import meldeplikt.dto.DtoMeldepliktshendelse


object Topics {
    val meldeplikt = Topic("aap.meldeplikt.v1", JsonSerde.jackson<DtoMeldepliktshendelse>())
}