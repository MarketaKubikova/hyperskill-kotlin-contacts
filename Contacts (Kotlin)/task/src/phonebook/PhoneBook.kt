package contacts.phonebook

import contacts.record.Record
import contacts.record.RecordFactory

object PhoneBook {
    private val list = mutableListOf<Record>()

    fun add(record: Record) {
        list.add(record)
    }

    fun delete(record: Record) {
        val index = list.indexOf(record)
        list.removeAt(index)
    }

    fun edit(record: Record) {
        val updatedRecord = RecordFactory.updateRecord(record)
        val index = list.indexOf(record)
        list[index] = updatedRecord
    }

    fun getCount(): Int {
        return list.size
    }

    fun getList(): List<Record> {
        return list
    }

    fun getSearchResult(query: String): List<Record> {
        return list.filter { it.metadata.contains(Regex(query, RegexOption.IGNORE_CASE)) }
    }

    fun searchByIndex(index: Int): Record {
        return getList()[index - 1]
    }
}
