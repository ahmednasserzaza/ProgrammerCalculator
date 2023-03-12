package com.fighter.programmercalculator

class Converter {

    fun binaryToDecimal(binary: String): Long {
        return binary.toLong(2)
    }

    fun decimalToBinary(decimal: Long): String {
        return decimal.toString(2)
    }

    fun octalToDecimal(octal: String): Long {
        return octal.toLong(8)
    }

    fun decimalToOctal(decimal: Long): String {
        return decimal.toString(8)
    }

    fun hexadecimalToDecimal(hexadecimal: String): Long {
        return hexadecimal.toLong(16)
    }

    fun decimalToHexadecimal(decimal: Long): String {
        return decimal.toString(16)
    }

    fun binaryToOctal(binary: String): String {
        val decimal = binaryToDecimal(binary)
        return decimalToOctal(decimal)
    }

    fun binaryToHexadecimal(binary: String): String {
        val decimal = binaryToDecimal(binary)
        return decimalToHexadecimal(decimal)
    }

    fun octalToBinary(octal: String): String {
        val decimal = octalToDecimal(octal)
        return decimalToBinary(decimal)
    }

    fun octalToHexadecimal(octal: String): String {
        val decimal = octalToDecimal(octal)
        return decimalToHexadecimal(decimal)
    }

    fun hexadecimalToBinary(hexadecimal: String): String {
        val decimal = hexadecimalToDecimal(hexadecimal)
        return decimalToBinary(decimal)
    }

    fun hexadecimalToOctal(hexadecimal: String): String {
        val decimal = hexadecimalToDecimal(hexadecimal)
        return decimalToOctal(decimal)
    }

}