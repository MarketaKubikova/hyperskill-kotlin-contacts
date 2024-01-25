package contacts.command

import contacts.phonebook.PhoneBook
import contacts.record.Record

/**
 * Interface for defining commands.
 */
interface Command {
    val receiver: PhoneBook

    /**
     * Execute the command.
     */
    fun execute()

    /**
     * Execute the command and return records
     *
     * @return list of records
     */
    fun executeAndReturn(): List<Record> {
        return emptyList()
    }
}
