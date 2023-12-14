package menu.domain

import camp.nextstep.edu.missionutils.Randoms

class RecommendationManager(
    private val coachesInfo: List<CoachInfo>,
    private val weekdayCategories: List<String>
) {
    fun getRecommendMenuResult(): List<RecommendationResult> = coachesInfo.map {
        val recommendedMenus = getRecommendedMenusForCoach(it)
        RecommendationResult(it.name, recommendedMenus)
    }

    fun getRecommendedMenusForCoach(coachInfo: CoachInfo): List<String> {
        val recommendedMenus = ArrayList<String>()
        weekdayCategories.onEach {
            val menus = Category.getMenuByCategoryName(it)
            recommendedMenus.add(pickMenu(menus!!, coachInfo, recommendedMenus))
        }

        return recommendedMenus
    }

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