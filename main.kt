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
    val somePerson: Person = Person(
        readLine()!!.toString(), readLine()!!.toString(), readLine()!!.toInt(),
        Gender.MALE.getGenderValue(readLine()!!.toString()), readLine()!!.toInt()
    )

} 
