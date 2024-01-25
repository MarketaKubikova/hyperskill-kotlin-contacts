package contacts.command

import contacts.phonebook.PhoneBook

/**
 * Implementation of command to count saved records
 */
class CountCommand(override val receiver: PhoneBook) : Command {
    override fun execute() {
        println("The Phone Book has ${receiver.getCount()} records.")
    }
}
