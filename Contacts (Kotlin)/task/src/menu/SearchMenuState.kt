package contacts.menu

import contacts.command.SearchCommand
import contacts.invoker.Invoker
import contacts.phonebook.PhoneBook
import contacts.record.Record
import contacts.utils.Action
import contacts.utils.MenuType

/**
 * Implementation of the Search Menu state.
 */
class SearchMenuState(val list: List<Record>) : MenuState {
    private val invoker = Invoker()
    private val phoneBook = PhoneBook

    override fun displayMenu() {
        super.printMenu(MenuType.SEARCH, listOf(Action.RECORD,Action.AGAIN, Action.BACK))
    }

    override fun handleInput(input: String): MenuState {
        return when {
            input.toIntOrNull() != null -> {
                val record = list[input.toInt() - 1]

                do {
                    var currentState: MenuState = RecordMenuState(record)
                    currentState.displayMenu()
                    val userInput = readln()
                    currentState = currentState.handleInput(userInput.uppercase())
                } while (currentState !is MainMenuState)
                // After returning from RecordMenuState, go to the main menu state
                MainMenuState()
            }
            Action.valueOf(input) == Action.AGAIN -> {
                val searchList = invoker.executeAndReturn(SearchCommand(phoneBook))
                SearchMenuState(searchList)
            }
            Action.valueOf(input) == Action.BACK -> MainMenuState()
            else -> {
                println("Invalid input. Please try again.")
                this
            }
        }
    }
}
