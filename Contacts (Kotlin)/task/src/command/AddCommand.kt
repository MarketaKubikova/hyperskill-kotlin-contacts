package contacts.command

import contacts.utils.Message
import contacts.phonebook.PhoneBook
import contacts.record.RecordFactory

/**
 * Implementation of command to add and save the record
 */
class AddCommand(override val receiver: PhoneBook) : Command {
    override fun execute() {
        println(Message.ENTER_TYPE)
        val type = readln()
        val record = RecordFactory.createRecord(type)
        receiver.add(record)
        println("The record added.")
    }
}
