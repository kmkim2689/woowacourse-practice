package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class RecommendationManager(
    private val coachesInfo: List<CoachInfo>,
    private val weekdayCategories: List<String>
) {

    val recommendationResult = ArrayList<WeekdayResult>()

    fun getRecommendMenuResult(): List<RecommendationResult> {
        val recommendedMenusForAllCoaches = ArrayList<RecommendationResult>()
        coachesInfo.onEach {
            recommendedMenusForAllCoaches.add(RecommendationResult(it.name, mutableListOf()))
        }
        weekdayCategories.onEach { weekdayCategory ->
            val menus = Category.getMenuByCategoryName(weekdayCategory)
            recommendedMenusForAllCoaches.zip(coachesInfo) { currentResult, coachInfo ->
                currentResult.recommendation.add(pickMenu(menus!!, coachInfo, currentResult.recommendation))
            }
        }
        return recommendedMenusForAllCoaches
    }

/*
    private fun getRecommendedMenusForCoach(coachInfo: CoachInfo): String {

        weekdayCategories.onEach {

            recommendedMenus.add(pickMenu(menus!!, coachInfo, recommendedMenus))
        }

        return recommendedMenus
    }
*/

    private fun pickMenu(
        menus: List<String>,
        coachInfo: CoachInfo,
        currentMenus: List<String>
    ): String {
        val selectedMenu = Randoms.shuffle(menus)[0]
        if (selectedMenu in currentMenus ||
            selectedMenu in coachInfo.unavailableMenus) {
            pickMenu(menus, coachInfo, currentMenus)
        }

        return selectedMenu
    }
}