package contacts.menu

import contacts.command.ShowCommand
import contacts.invoker.Invoker
import contacts.phonebook.PhoneBook
import contacts.utils.Action
import contacts.utils.MenuType

/**
 * Implementation of the List Menu state.
 */
class ListMenuState : MenuState {
    private val invoker = Invoker()
    private val phoneBook = PhoneBook

    override fun displayMenu() {
        super.printMenu(MenuType.LIST, listOf(Action.RECORD, Action.BACK))
    }

    override fun handleInput(input: String): MenuState {
        return when {
            input.toIntOrNull() != null -> {
                val record = phoneBook.searchByIndex(input.toInt())
                invoker.execute(ShowCommand(phoneBook, record))

                do {
                    var currentState: MenuState = RecordMenuState(record)
                    currentState.displayMenu()
                    val userInput = readln()
                    currentState = currentState.handleInput(userInput.uppercase())
                } while (currentState !is MainMenuState)
                // After returning from RecordMenuState, go to the main menu state
                MainMenuState()
            }
            Action.valueOf(input) == Action.BACK -> MainMenuState()
            else -> {
                println("Invalid input. Please try again.")
                this
            }
        }
    }
}
