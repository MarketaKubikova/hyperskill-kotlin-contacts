package contacts.menu

import contacts.utils.Action
import contacts.utils.MenuType

/**
 * Interface for defining menu states.
 */
interface MenuState {
    /**
     * Display the menu options for the current state.
     */
    fun displayMenu()

    /**
     * Handle user input and return the next menu state.
     *
     * @param input User input
     * @return Next menu state
     */
    fun handleInput(input: String): MenuState

    fun printMenu(menu: MenuType, actions: List<Action>) {
        println()
        println("[${menu.name.lowercase()}] Enter action (${actions.joinToString(", ") { it.code }}):")
    }
}
