import java.io.File
import java.lang.RuntimeException
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("inputs", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun sum3ElementsFromIdx(list: List<Int>, index: Int): Int {
    if (index >= list.size || index + 2 >= list.size) {
        throw RuntimeException("Invalid Position");
    }
    var sum = 0
    for (i in index..index + 2) {
        sum += list[i]
    }

    return sum;
}