package e.erga.forecastmvvm.ui

class TestClass {

    fun main(args: Array<String>) {
        val temp = args
        for (name in args) {
            println("$name")
        }

        for (number in args) {
            println("Hasil " + checkNumber(number.toInt()))
        }

    }

    fun checkNumber(i: Any):Boolean{
        when (i) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> {
                return false
            }
        }
        return true
    }
}
