package menu.domain

import menu.constant.Constants.CATEGORY_ASIAN
import menu.constant.Constants.CATEGORY_CHINESE
import menu.constant.Constants.CATEGORY_JAPANESE
import menu.constant.Constants.CATEGORY_KOREAN
import menu.constant.Constants.CATEGORY_WESTERN
import menu.constant.Constants.asianMenus
import menu.constant.Constants.chineseMenus
import menu.constant.Constants.japaneseMenus
import menu.constant.Constants.koreanMenus
import menu.constant.Constants.westernMenus

enum class Category(val categoryName: String, val menus: List<String>) {
    JAPANESE(CATEGORY_JAPANESE, japaneseMenus),
    KOREAN(CATEGORY_KOREAN, koreanMenus),
    CHINESE(CATEGORY_CHINESE, chineseMenus),
    ASIAN(CATEGORY_ASIAN, asianMenus),
    WESTERN(CATEGORY_WESTERN, westernMenus);

    companion object {
        fun getMenuByCategoryName(categoryName: String): List<String>? {
            val category = entries.find { it.categoryName == categoryName }
            return category?.menus
        }
    }
}