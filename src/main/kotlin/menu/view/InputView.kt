package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.constant.ExceptionMessages.ERROR
import menu.constant.ExceptionMessages.EXCEPTION_UNEXPECTED
import menu.constant.StepMessages.STEP_INPUT_NAMES
import menu.util.toListOrThrowIllegalArgumentException

object InputView {

    fun getCoachNames(): List<String> = getValidatedCoachNames()

    private fun getValidatedCoachNames(): List<String> = try {
        // TODO controller에 넣기 : println(STEP_START_RECOMMENDATION)
        println(STEP_INPUT_NAMES)
        val coachNames = Console.readLine().trim()
        coachNames.toListOrThrowIllegalArgumentException()
    } catch (e: IllegalArgumentException) {
        println(getErrorMessage(e.message))
        getValidatedCoachNames()
    }

    private fun getErrorMessage(message: String? = EXCEPTION_UNEXPECTED) = "$ERROR $message"

}