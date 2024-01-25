package contacts.menu

import contacts.command.DeleteCommand
import contacts.command.EditCommand
import contacts.invoker.Invoker
import contacts.phonebook.PhoneBook
import contacts.utils.Action
import contacts.record.Record
import contacts.utils.MenuType

/**
 * Implementation of the Record Menu state.
 */
class RecordMenuState(private val record: Record) : MenuState {
    private val invoker = Invoker()
    private val phoneBook = PhoneBook

    override fun displayMenu() {
        super.printMenu(MenuType.RECORD, listOf(Action.EDIT, Action.DELETE, Action.MENU))
    }

    override fun handleInput(input: String): MenuState {
        return when (Action.valueOf(input.uppercase())) {
            Action.EDIT -> {
                invoker.execute(EditCommand(phoneBook, record))
                this
            }
            Action.DELETE -> {
                invoker.execute(DeleteCommand(phoneBook, record))
                this
            }
            Action.MENU -> MainMenuState()
            else -> {
                println("Invalid input. Please try again.")
                this
            }
        }
    }
}
