package io.github.kevinah95.kmpkoin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform