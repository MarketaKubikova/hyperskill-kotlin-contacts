package contacts.record

import contacts.utils.Constants
import contacts.utils.Message.ENTER_ADDRESS
import contacts.utils.Message.ENTER_BIRTH
import contacts.utils.Message.ENTER_GENDER
import contacts.utils.Message.ENTER_NAME
import contacts.utils.Message.ENTER_NUMBER
import contacts.utils.Message.ENTER_ORG_NAME
import contacts.utils.Message.ENTER_SURNAME
import contacts.utils.Message.SELECT_ORGANIZATION_FIELD
import contacts.utils.Message.SELECT_PERSON_FIELD
import contacts.utils.Util
import java.time.ZonedDateTime

object RecordFactory {
    fun createRecord(type: String): Record {
        return when (type) {
            "person" -> createPerson()
            "organization" -> createOrganization()
            else -> throw IllegalArgumentException("Unknown record type")
        }
    }

    fun updateRecord(record: Record): Record {
        return when (record) {
            is Record.Person -> updatePerson(record)
            is Record.Organization -> updateOrganization(record)
        }
    }

    private fun createPerson(): Record.Person {
        println(ENTER_NAME)
        val firstName = readln()
        println(ENTER_SURNAME)
        val surname = readln()
        println(ENTER_BIRTH)
        val birthDate = Util.checkBirthDate(readln())
        println(ENTER_GENDER)
        val gender = Util.checkGender(readln())
        println(ENTER_NUMBER)
        val number = Util.checkNumberFormat(readln())

        return Record.Person(
            firstName, surname, birthDate, gender, number, ZonedDateTime.now(Constants.zoneId), ZonedDateTime.now(
                Constants.zoneId
            )
        )
    }

    private fun createOrganization(): Record.Organization {
        println(ENTER_ORG_NAME)
        val name = readln()
        println(ENTER_ADDRESS)
        val address = readln()
        println(ENTER_NUMBER)
        val number = Util.checkNumberFormat(readln())
        return Record.Organization(
            name, address, number, ZonedDateTime.now(Constants.zoneId), ZonedDateTime.now(
                Constants.zoneId
            )
        )
    }

    private fun updatePerson(person: Record.Person): Record.Person {
        println(SELECT_PERSON_FIELD)
        val field = readln()
        println("Enter $field:")
        val input = readln()

        when (field) {
            "name" -> person.firstName = input
            "surname" -> person.surname = input
            "birth" -> person.birth = Util.checkBirthDate(input)
            "gender" -> person.gender = Util.checkGender(input)
            "number" -> person.number = Util.checkNumberFormat(input)
        }

        person.timeUpdated = ZonedDateTime.now(Constants.zoneId)

        return person
    }

    private fun updateOrganization(organization: Record.Organization): Record.Organization {
        println(SELECT_ORGANIZATION_FIELD)
        val field = readln()
        println("Enter $field:")
        val input = readln()

        when (field) {
            "name" -> organization.organizationName = input
            "address" -> organization.address = input
            "number" -> organization.number = Util.checkNumberFormat(input)
        }

        organization.timeUpdated = ZonedDateTime.now(Constants.zoneId)

        return organization
    }
}
