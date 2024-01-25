package contacts.menu

/**
 * Exit state to handle the exit action.
 */
class ExitState : MenuState {
    override fun displayMenu() {
        // No display for exit state
    }

    override fun handleInput(input: String): MenuState {
        // No further handling, as the app is exiting
        return this
    }
}
