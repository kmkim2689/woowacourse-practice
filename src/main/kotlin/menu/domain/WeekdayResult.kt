package menu.domain

data class WeekdayResult(
    val weekdayCategory: String,
    val recommendations: List<RecommendationResult>
)
