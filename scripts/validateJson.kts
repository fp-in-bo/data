#!/bin/bash

//usr/bin/env echo '
/**** BOOTSTRAP kscript ****\'>/dev/null
command -v kscript >/dev/null 2>&1 || curl -L "https://git.io/fpF1K" | bash 1>&2
exec kscript $0 "$@"
\*** IMPORTANT: Any code including imports and annotations must come after this line ***/
//DEPS com.fasterxml.jackson.module:jackson-module-kotlin:2.10.1

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.FileInputStream

val inputStream = FileInputStream(args[0])
val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())
val validEvents: List<EventModel> = mapper.readValue(inputStream)

println(validEvents)

data class EventModel(
    val title: String,
    val speaker: String,
    val imageUrl: String,
    val description: String
)