package contacts.command

import contacts.phonebook.PhoneBook
import contacts.record.Record

/**
 * Implementation of command to print record info or list of saved records
 */
class ShowCommand(override val receiver: PhoneBook, private val record: Record? = null) : Command {
    override fun execute() {
        if (record != null) record.printInfo() else {
            val list = receiver.getList()
            list.forEach { record -> println("${list.indexOf(record) + 1}. $record") }
        }
    }
}
