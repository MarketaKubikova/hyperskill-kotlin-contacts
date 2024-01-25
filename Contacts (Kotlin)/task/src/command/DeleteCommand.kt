package contacts.command

import contacts.phonebook.PhoneBook
import contacts.record.Record

/**
 * Implementation of command to delete the record
 */
class DeleteCommand(override val receiver: PhoneBook, private val record: Record) : Command {
    override fun execute() {
        receiver.delete(record)
        println("The record removed!")
    }
}
