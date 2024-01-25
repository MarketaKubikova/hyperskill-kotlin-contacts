package contacts.record

import contacts.utils.Formatter
import java.time.ZonedDateTime

sealed class Record {
    abstract var name: String
    abstract var metadata: String

    abstract fun printInfo()

    data class Person(
        var firstName: String,
        var surname: String,
        var birth: String,
        var gender: String,
        var number: String,
        val timeCreated: ZonedDateTime,
        var timeUpdated: ZonedDateTime,
        override var name: String = firstName + surname,
        override var metadata: String = (firstName + surname + number).trimIndent().lowercase()
    ) : Record() {
        override fun toString(): String {
            return "$firstName $surname"
        }

        override fun printInfo() {
            println(
                """
                Name: $firstName
                Surname: $surname
                Birth date: $birth
                Gender: $gender
                Number: $number
                Time created: ${Formatter.formatDate(timeCreated)}
                Time last edit: ${Formatter.formatDate(timeUpdated)}
            """.trimIndent()
            )
        }
    }

    data class Organization(
        var organizationName: String,
        var address: String,
        var number: String,
        val timeCreated: ZonedDateTime,
        var timeUpdated: ZonedDateTime,
        override var name: String = organizationName,
        override var metadata: String = (organizationName + address + number).trimIndent().lowercase()
    ) : Record() {
        override fun toString(): String {
            return organizationName
        }

        override fun printInfo() {
            println(
                """
                Organization name: $organizationName
                Address: $address
                Number: $number
                Time created: ${Formatter.formatDate(timeCreated)}
                Time last edit: ${Formatter.formatDate(timeUpdated)}
            """.trimIndent()
            )
        }
    }
}
