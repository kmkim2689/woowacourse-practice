package menu.constant

object ExceptionMessages {
    const val ERROR = "[ERROR]"

    const val EXCEPTION_LEN_COACH_NAME = "코치 이름은 2글자에서 4글자 사이로 입력해야 합니다."
    const val EXCEPTION_MIN_NUM_COACHES = "코치는 최소 2명 이상 입력해야 합니다."
    const val EXCEPTION_MAX_NUM_COACHES = "코치는 최대 5명까지 입력할 수 있습니다."

    const val EXCEPTION_UNAVAILABLE_MAX_SIZE = "코치가 먹지 못하는 메뉴의 수는 최대 2개입니다."
    const val EXCEPTION_UNAVAILABLE_NOT_EXISTS = "코치가 먹지 못하는 메뉴는 정해진 메뉴 중에서 입력해야 합니다."

    const val EXCEPTION_UNEXPECTED = "알 수 없는 에러가 발생하였습니다."
}