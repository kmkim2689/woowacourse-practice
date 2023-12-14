package menu.domain

data class RecommendationResult(
    val name: String,
    val recommendation: MutableList<String>
)
