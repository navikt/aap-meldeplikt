package no.nav.aap.config

import com.sksamuel.hoplite.ConfigLoader
import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.MapPropertySource
import com.sksamuel.hoplite.yaml.YamlParser
import io.ktor.server.application.*
import io.ktor.server.config.*
import no.nav.aap.kafka.KafkaConfig

data class Config(
    val kafka: KafkaConfig
)

inline fun <reified T : Any> Application.loadConfig(vararg resources: String = arrayOf("/application.yml")): T =
    ConfigLoader.builder()
        .addFileExtensionMapping("yml", YamlParser())
        .addKtorConfig(environment.config)
        .build()
        .loadConfigOrThrow(*resources)

/**
 * Add Ktors MapApplicationConfig as PropertySource,
 * this allows the MapApplicationConfig to override config values in tests
 */
fun ConfigLoaderBuilder.addKtorConfig(config: ApplicationConfig) = apply {
    if (config is MapApplicationConfig) {
        // get access to the protected property 'map'
        @Suppress("UNCHECKED_CAST")
        val map: Map<String, Any?> = config.javaClass.getDeclaredField("map").let {
            it.isAccessible = true
            it.get(config)
        } as Map<String, Any?>

        addPropertySource(MapPropertySource(map))
    }
}