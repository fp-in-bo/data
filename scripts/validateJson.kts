#!/bin/bash

//usr/bin/env echo '
/**** BOOTSTRAP kscript ****\'>/dev/null
command -v kscript >/dev/null 2>&1 || curl -L "https://git.io/fpF1K" | bash 1>&2
exec kscript $0 "$@"
\*** IMPORTANT: Any code including imports and annotations must come after this line ***/
//DEPS com.fasterxml.jackson.module:jackson-module-kotlin:2.10.1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.FileInputStream

val inputStream = FileInputStream(args[0])
val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
val validEvents: List<EventModel> = mapper.readValue(inputStream)

println(validEvents)

data class EventModel(
    @JsonProperty(required = true) val id: Int,
    @JsonProperty(required = true) val title: String,
    @JsonProperty(required = true) val speaker: String,
    @JsonProperty(required = true) val imageUrl: String,
    @JsonProperty(required = true) val description: String,
    val videoUrl: String?
)