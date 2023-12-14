package menu.view

import menu.constant.Constants.BRACKET_CLOSE
import menu.constant.Constants.BRACKET_OPEN
import menu.constant.Constants.OUTPUT_SEPARATOR
import menu.constant.Constants.TITLE_CATEGORY
import menu.constant.StepMessages.STEP_RESULT_TITLE
import menu.constant.StepMessages.STEP_WEEKDAY
import menu.domain.RecommendationResult

object OutputView {
    fun printResult(weekdayCategories: List<String>, result: List<RecommendationResult>) {
        println(STEP_RESULT_TITLE)
        println(STEP_WEEKDAY)
        printWeekdayCategories(weekdayCategories)
        printRecommendationResult(result)
        println()
    }

    private fun printWeekdayCategories(weekdayCategories: List<String>) {
        print("$BRACKET_OPEN $TITLE_CATEGORY ")
        weekdayCategories.onEach {
            print("$OUTPUT_SEPARATOR $it ")
        }
        println(BRACKET_CLOSE)
    }

    private fun printRecommendationResult(result: List<RecommendationResult>) {
        result.onEach { item ->
            print("$BRACKET_OPEN ${item.name} ")
            item.recommendation.onEach {
                print("$OUTPUT_SEPARATOR $it ")
            }
            println(BRACKET_CLOSE)
        }
    }
}