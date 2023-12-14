package menu.util

import menu.constant.Constants.INPUT_NAME_MAX_LEN
import menu.constant.Constants.INPUT_NAME_MIN_LEN
import menu.constant.Constants.INPUT_SEPARATOR
import menu.constant.Constants.MAX_COACH_NUM
import menu.constant.Constants.MAX_UNAVAILABLE_NUM
import menu.constant.Constants.MENUS
import menu.constant.Constants.MIN_COACH_NUM
import menu.constant.ExceptionMessages.EXCEPTION_LEN_COACH_NAME
import menu.constant.ExceptionMessages.EXCEPTION_MAX_NUM_COACHES
import menu.constant.ExceptionMessages.EXCEPTION_UNAVAILABLE_MAX_SIZE
import menu.constant.ExceptionMessages.EXCEPTION_MIN_NUM_COACHES
import menu.constant.ExceptionMessages.EXCEPTION_UNAVAILABLE_NOT_EXISTS

fun String.toNameListOrThrowIllegalArgumentException(): List<String> {
    val coachNames = this.split(INPUT_SEPARATOR)
    coachNames.let {
        if (it.size < MIN_COACH_NUM) throw IllegalArgumentException(EXCEPTION_MIN_NUM_COACHES)
        if (it.size > MAX_COACH_NUM) throw IllegalArgumentException(EXCEPTION_MAX_NUM_COACHES)
    }
    coachNames.onEach { name ->
        if (name.length !in INPUT_NAME_MIN_LEN..INPUT_NAME_MAX_LEN) throw IllegalArgumentException(EXCEPTION_LEN_COACH_NAME)
    }

    return coachNames
}

fun String.toMenuListOrThrowIllegalArgumentException(): List<String> {
    val menus = this.split(INPUT_SEPARATOR)
    if (menus.size > MAX_UNAVAILABLE_NUM) throw IllegalArgumentException(EXCEPTION_UNAVAILABLE_MAX_SIZE)
    menus.onEach {
        if (it !in MENUS) throw IllegalArgumentException(EXCEPTION_UNAVAILABLE_NOT_EXISTS)
    }

    return menus
}