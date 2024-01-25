package contacts.menu

import contacts.command.AddCommand
import contacts.command.CountCommand
import contacts.command.SearchCommand
import contacts.command.ShowCommand
import contacts.invoker.Invoker
import contacts.phonebook.PhoneBook
import contacts.utils.Action
import contacts.utils.MenuType

/**
 * Implementation of the Main Menu state.
 */
class MainMenuState: MenuState {
    private val invoker = Invoker()
    private val phoneBook = PhoneBook

    override fun displayMenu() {
        super.printMenu(MenuType.MENU, listOf(Action.ADD, Action.LIST, Action.SEARCH, Action.COUNT, Action.EXIT))
    }

    override fun handleInput(input: String): MenuState {
        return when (Action.valueOf(input)) {
            Action.ADD -> {
                invoker.execute(AddCommand(phoneBook))
                this
            }
            Action.LIST -> {
                invoker.execute(ShowCommand(phoneBook))

                do {
                    var currentState: MenuState = ListMenuState()
                    currentState.displayMenu()
                    val userInput = readln()
                    currentState = currentState.handleInput(userInput.uppercase())
                } while (currentState !is MainMenuState)
                // After returning from ListMenuState, stay in the main menu state
                this
            }
            Action.SEARCH -> {
                val searchList = invoker.executeAndReturn(SearchCommand(phoneBook))

                do {
                    var currentState: MenuState = SearchMenuState(searchList)
                    currentState.displayMenu()
                    val userInput = readln()
                    currentState = currentState.handleInput(userInput.uppercase())
                } while (currentState !is MainMenuState)
                // After returning from SearchMenuState, stay in the main menu state
                this
            }
            Action.COUNT -> {
                invoker.execute(CountCommand(phoneBook))
                this
            }
            Action.EXIT -> {
                ExitState()
            }
            else -> {
                println("Invalid input. Please try again.")
                this
            }
        }
    }
}
