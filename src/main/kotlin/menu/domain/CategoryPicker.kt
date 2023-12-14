package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.constant.Constants.CATEGORY_ASIAN
import menu.constant.Constants.CATEGORY_CHINESE
import menu.constant.Constants.CATEGORY_DUMMY
import menu.constant.Constants.CATEGORY_JAPANESE
import menu.constant.Constants.CATEGORY_KOREAN
import menu.constant.Constants.CATEGORY_WESTERN
import menu.constant.Constants.NUM_OF_WEEKDAYS

object CategoryPicker {

    private val categories = listOf(
        CATEGORY_DUMMY,
        CATEGORY_JAPANESE,
        CATEGORY_KOREAN,
        CATEGORY_CHINESE,
        CATEGORY_ASIAN,
        CATEGORY_WESTERN
    )

    fun getWeekdayCategories(): List<String> {
        var count = 0
        val weekdayCategories = ArrayList<String>()
        while (count < NUM_OF_WEEKDAYS) {
            val category = categories[Randoms.pickNumberInRange(1, 5)]
            val categoryFrequency = weekdayCategories.count { it == category }
            if (categoryFrequency < 2) {
                weekdayCategories.add(category)
                count++
            }
        }
        return weekdayCategories
    }
}