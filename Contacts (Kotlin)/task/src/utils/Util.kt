package contacts.utils

object Util {
    fun checkNumberFormat(number: String): String {
        return if (hasNumberRightFormat(number)) {
            number
        } else {
            println("Wrong number format!")
            "[no number]"
        }
    }

    fun checkBirthDate(birthDate: String): String {
        return if (isBirthDateValid(birthDate)) {
            birthDate
        } else {
            println("Bad birth date!")
            "[no data]"
        }
    }

    fun checkGender(gender: String): String {
        return if (isGenderValid(gender)) {
            gender
        } else {
            println("Bad gender!")
            "[no data]"
        }
    }

    private fun hasNumberRightFormat(number: String): Boolean {
        val firstBracket = "(\\(\\w+\\)([- ]\\w{2,})*)"
        val secondBracket = "(\\w+[- ]\\(\\w{2,}\\)([- ]\\w{2,})*)"
        val noBracket = "(\\w+[- ]\\w{2,}([- ]\\w{2,})*)"
        val numberRegex = Regex("\\+?(\\w+|$firstBracket|$secondBracket|$noBracket)")

        return number.matches(numberRegex)
    }

    private fun isBirthDateValid(date: String): Boolean {
        return date.isNotEmpty()
    }

    private fun isGenderValid(gender: String): Boolean {
        return gender.matches(Regex("[M|F]"))
    }
}
