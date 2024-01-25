package contacts.utils

enum class Action(val code: String) {
    ADD("add"),
    LIST("list"),
    SEARCH("search"),
    COUNT("count"),
    EXIT("exit"),
    RECORD("[number]"),
    BACK("back"),
    AGAIN("again"),
    EDIT("edit"),
    DELETE("delete"),
    MENU("menu")
}
