package contacts

import contacts.menu.ExitState
import contacts.menu.MainMenuState
import contacts.menu.MenuState

class App {
    fun run() {
        do {
            var currentState: MenuState = MainMenuState()
            currentState.displayMenu()
            val userInput = readln()
            currentState = currentState.handleInput(userInput.uppercase())
        } while (currentState !is ExitState)
    }
}
