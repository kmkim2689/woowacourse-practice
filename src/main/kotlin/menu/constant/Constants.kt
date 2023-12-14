package menu.constant

object Constants {
    const val INPUT_SEPARATOR = ","
    const val OUTPUT_SEPARATOR = "|"

    const val INPUT_NAME_MIN_LEN = 2
    const val INPUT_NAME_MAX_LEN = 4

    const val MIN_COACH_NUM = 2
    const val MAX_COACH_NUM = 5

    const val MAX_UNAVAILABLE_NUM = 2

    const val CATEGORY_DUMMY = ""
    const val CATEGORY_JAPANESE = "일식"
    const val CATEGORY_KOREAN = "한식"
    const val CATEGORY_CHINESE = "중식"
    const val CATEGORY_ASIAN = "아시안"
    const val CATEGORY_WESTERN = "양식"

    const val NUM_OF_WEEKDAYS = 5

    const val MAX_CATEGORY_FREQUENCY = 2

    const val BRACKET_OPEN = "["
    const val BRACKET_CLOSE = "]"

    const val TITLE_CATEGORY = "카테고리"

    val japaneseMenus = listOf(
        "규동",
        "우동",
        "미소시루",
        "스시",
        "가츠동",
        "오니기리",
        "하이라이스",
        "라멘",
        "오코노미야끼"
    )

    val koreanMenus = listOf(
        "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"
    )

    val chineseMenus = listOf(
        "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"
    )

    val asianMenus = listOf(
        "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"
    )

    val westernMenus = listOf(
        "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
    )

    val menus = japaneseMenus + koreanMenus + chineseMenus + asianMenus + westernMenus
}