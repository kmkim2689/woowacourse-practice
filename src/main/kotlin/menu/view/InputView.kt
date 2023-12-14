package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.constant.ExceptionMessages.ERROR
import menu.constant.ExceptionMessages.EXCEPTION_UNEXPECTED
import menu.constant.StepMessages.STEP_INPUT_NAMES
import menu.constant.StepMessages.STEP_UNAVAILABLE_MENU
import menu.util.toMenuListOrThrowIllegalArgumentException
import menu.util.toNameListOrThrowIllegalArgumentException

object InputView {

    fun getCoachNames(): List<String> = getValidatedCoachNames()

    fun getUnavailableMenu(coachNames: List<String>): List<List<String>> = getValidatedUnavailableMenus(coachNames)

    private fun getValidatedCoachNames(): List<String> = try {
        // TODO controller에 넣기 : println(STEP_START_RECOMMENDATION)
        println(STEP_INPUT_NAMES)
        val coachNames = Console.readLine().trim()
        coachNames.toNameListOrThrowIllegalArgumentException()
    } catch (e: IllegalArgumentException) {
        println(getErrorMessage(e.message))
        getValidatedCoachNames()
    }

    private fun getValidatedUnavailableMenus(coachNames: List<String>): List<List<String>> {
        return coachNames.map {
            getValidatedUnavailableMenusForCoach(it)
        }
    }

    private fun getValidatedUnavailableMenusForCoach(coachName: String): List<String> = try {
        println("$coachName$STEP_UNAVAILABLE_MENU")
        val unavailableMenus = Console.readLine().trim()
        unavailableMenus.toMenuListOrThrowIllegalArgumentException()
    } catch (e: IllegalArgumentException) {
        println(getErrorMessage(e.message))
        getValidatedUnavailableMenusForCoach(coachName)
    }

    private fun getErrorMessage(message: String? = EXCEPTION_UNEXPECTED) = "$ERROR $message"

}