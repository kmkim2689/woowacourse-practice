package menu.controller

import menu.constant.StepMessages.STEP_COMPLETION
import menu.constant.StepMessages.STEP_START_RECOMMENDATION
import menu.domain.CategoryPicker
import menu.domain.CoachInfo
import menu.domain.RecommendationManager
import menu.view.InputView
import menu.view.OutputView

object RecommendationController {
    fun startRecommendation() {
        println("$STEP_START_RECOMMENDATION\n")

        val coachNames = InputView.getCoachNames()
        val unavailableMenus = InputView.getUnavailableMenu(coachNames)
        val coachInfo = coachNames.zip(unavailableMenus) { coachName, unavailableMenu ->
            CoachInfo(coachName, unavailableMenu)
        }
        val weekdayCategories = CategoryPicker.getWeekdayCategories()
        val recommendationManager = RecommendationManager(coachInfo, weekdayCategories)
        val recommendationResult = recommendationManager.getRecommendMenuResult()

        OutputView.printResult(weekdayCategories, recommendationResult)

        println(STEP_COMPLETION)
    }
}