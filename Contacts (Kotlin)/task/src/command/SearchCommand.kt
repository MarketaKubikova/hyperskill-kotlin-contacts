package contacts.command

import contacts.utils.Message
import contacts.phonebook.PhoneBook
import contacts.record.Record

/**
 * Implementation of command to search in saved records given query
 */
class SearchCommand(override val receiver: PhoneBook) : Command {
    override fun execute() {
        // Not needed to implement since executeAndReturn() is implemented
    }

    override fun executeAndReturn(): List<Record> {
        println(Message.ENTER_QUERY)
        val query = readln()
        val list = receiver.getSearchResult(query)
        println("Found ${list.size} results:")
        list.forEach { record -> println("${list.indexOf(record) + 1}. $record") }

        return list
    }
}
