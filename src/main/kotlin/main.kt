package ru.netology

val secondsPerMinute = 60
val minutesPerHour = 60
val hoursPerDay = 24

fun main() {
    val seconds = 43215
    println(agoToText(seconds))
}

fun agoToText(seconds: Int) = when {
    seconds <= secondsPerMinute -> "был(а) только что"
    seconds <= secondsPerMinute * minutesPerHour -> {
        val minutes = seconds / secondsPerMinute
        "был(а) $minutes ${minutes(seconds)} назад"
    }

    seconds <= secondsPerMinute * minutesPerHour * hoursPerDay -> {
        val hours = seconds / secondsPerMinute / minutesPerHour
        "был(а) в сети $hours ${hours(seconds)} назад"
    }

    seconds <= secondsPerMinute * minutesPerHour * hoursPerDay * 2 -> "был(а) вчера"
    seconds <= secondsPerMinute * minutesPerHour * hoursPerDay * 3 -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun minutes(seconds: Int) = when ((seconds / secondsPerMinute) % 100) {
    11, 12, 13, 14 -> "минут"
    else -> when ((seconds / secondsPerMinute) % 10) {
        1 -> "минуту"
        2, 3, 4 -> "минуты"
        else -> "минут"
    }
}

fun hours(seconds: Int) = when ((seconds / secondsPerMinute / minutesPerHour) % 100) {
    11, 12, 13, 14 -> "часов"
    else -> when ((seconds / secondsPerMinute / minutesPerHour) % 10) {
        1 -> "час"
        2, 3, 4 -> "часа"
        else -> "часов"
    }
}