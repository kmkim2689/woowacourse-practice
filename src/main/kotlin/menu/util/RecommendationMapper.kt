package menu.util

import menu.constant.Constants.INPUT_NAME_MAX_LEN
import menu.constant.Constants.INPUT_NAME_MIN_LEN
import menu.constant.Constants.INPUT_SEPARATOR
import menu.constant.ExceptionMessages.EXCEPTION_LEN_COACH_NAME
import menu.constant.ExceptionMessages.EXCEPTION_MAX_NUM_COACHES
import menu.constant.ExceptionMessages.EXCEPTION_MIN_NUM_COACHES

fun String.toListOrThrowIllegalArgumentException(): List<String> {
    val coachNames = this.split(INPUT_SEPARATOR)
    coachNames.let {
        if (it.size < 2) throw IllegalArgumentException(EXCEPTION_MIN_NUM_COACHES)
        if (it.size > 5) throw IllegalArgumentException(EXCEPTION_MAX_NUM_COACHES)
    }
    coachNames.onEach { name ->
        if (name.length !in INPUT_NAME_MIN_LEN..INPUT_NAME_MAX_LEN) throw IllegalArgumentException(EXCEPTION_LEN_COACH_NAME)
    }

    return coachNames
}