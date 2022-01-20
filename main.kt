enum class Gender(var genderValue: String) {
    MALE("male"),
    FEMALE("female");
    fun getGenderValue(inputGen: String): Gender {
        return if (MALE.genderValue == inputGen){
            MALE
        } else {
            FEMALE
        }
    }
}

open class Person(val name: String, val surname: String, val age: Int, val gender: Gender, open var salary: Int)

class RichPerson(name: String, surname: String, age: Int, gender: Gender, override var salary: Int = 1000): Person(name, surname, age, gender, salary)

class RegularPerson(name: String, surname: String, age: Int, gender: Gender, override var salary: Int = 500): Person(name, surname, age, gender,salary)

fun main() {
    println("Input RichPerson data: Name, Surname, Age, Gender")
    val someRichPerson: RichPerson = RichPerson(
        readLine()!!.toString(), readLine()!!.toString(), readLine()!!.toInt(),
        Gender.MALE.getGenderValue(readLine()!!.toString())
    )
    println("Input RegularPerson data: Name, Surname, Age, Gender(male, female)")
    val someRegularPerson: RegularPerson = RegularPerson(
        readLine()!!.toString(), readLine()!!.toString(), readLine()!!.toInt(),
        Gender.MALE.getGenderValue(readLine()!!.toString())
    )
    println("do you want to show some info?\n rich, regular or exit")
    var infoInput: String = readLine()!!.toString()
    while (infoInput != "exit") {
        when (infoInput) {
            "rich" -> {showInfo(someRichPerson); infoInput = readLine()!!.toString()}
            "regular" -> {showInfo(someRegularPerson); infoInput = readLine()!!.toString()}
            "exit" -> {println("end of application"); break}
            else -> {println("Invalid input"); infoInput = readLine()!!.toString()}
        }
    }
}

fun showInfo(somePerson: Person){
    println("Gender - ${somePerson.gender},Age - ${somePerson.age},Name - ${somePerson.name},Surname -  ${somePerson.surname},Salary - ${somePerson.salary}")
}
