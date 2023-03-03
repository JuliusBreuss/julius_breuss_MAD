import kotlin.random.Random.Default.nextInt

fun main() {
    var n = 0
    var m = 0
    var number = arrayOf(0, 0, 0, 0)
    for (i in number.indices){
        var random = 0
        while (number.contains(random)){
            random = nextInt(1,9)
        }
        number[i] = random
    }
    var guesses = 0
    while (m != 4){
        var guess = arrayOf(0,0,0,0)
        var userInput = 0
        var guessInt = 0
        guesses++
        println("Please enter your guess:")
        while(guessInt<1000 || guessInt > 9999){
            guessInt = Integer.valueOf(readLine())
        }
        userInput = guessInt
        for (i in 3 downTo 0){

            guess[i] = guessInt.mod(10)
            guessInt /= 10

        }
        var tempArr = arrayOf(0,0,0)
        var arrIndex = 0
        for (i in number.indices){
            if (number[i] == guess[i]){
                n++
                m++
            }
            else {
                for (j in guess.indices){
                    if (number[i] == guess[j] && !tempArr.contains(guess[j])) {
                        n++
                        tempArr[arrIndex] = guess[j]
                        arrIndex++
                    }
                }
            }
        }
        println("User input: $userInput , Output: $n:$m")
        if (m!= 4){
            n = 0
            m = 0
        } else println("Congratulations! Used guesses: $guesses")
    }

}