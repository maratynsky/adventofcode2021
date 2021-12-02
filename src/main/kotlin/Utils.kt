@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

import java.io.File
import java.nio.file.Path

fun read(resource:String): File = Path.of({}.javaClass.getResource(resource).toURI()).toFile()