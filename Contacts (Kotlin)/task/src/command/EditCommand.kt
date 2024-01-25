package contacts.command

import contacts.phonebook.PhoneBook
import contacts.record.Record

/**
 * Implementation of command to edit and save the record
 */
class EditCommand(override val receiver: PhoneBook, val record: Record) : Command {
    override fun execute() {
        receiver.edit(record)
        println("Saved")
        record.printInfo()
    }
}
