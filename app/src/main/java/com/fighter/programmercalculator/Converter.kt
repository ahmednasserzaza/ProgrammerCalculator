package com.fighter.programmercalculator

class Converter {

    // Function to convert binary to decimal
    fun binaryToDecimal(binary: String): Long {
        return binary.toLong(2)
    }

    // Function to convert decimal to binary
    fun decimalToBinary(decimal: Long): String {
        return decimal.toString(2)
    }

    // Function to convert octal to decimal
    fun octalToDecimal(octal: String): Long {
        return octal.toLong(8)
    }

    // Function to convert decimal to octal
    fun decimalToOctal(decimal: Long): String {
        return decimal.toString(8)
    }

    // Function to convert hexadecimal to decimal
    fun hexadecimalToDecimal(hexadecimal: String): Long {
        return hexadecimal.toLong(16)
    }

    // Function to convert decimal to hexadecimal
    fun decimalToHexadecimal(decimal: Long): String {
        return decimal.toString(16)
    }

    // Function to convert binary to octal
    fun binaryToOctal(binary: String): String {
        val decimal = binaryToDecimal(binary)
        return decimalToOctal(decimal)
    }

    // Function to convert binary to hexadecimal
    fun binaryToHexadecimal(binary: String): String {
        val decimal = binaryToDecimal(binary)
        return decimalToHexadecimal(decimal)
    }

    // Function to convert octal to binary
    fun octalToBinary(octal: String): String {
        val decimal = octalToDecimal(octal)
        return decimalToBinary(decimal)
    }

    // Function to convert octal to hexadecimal
    fun octalToHexadecimal(octal: String): String {
        val decimal = octalToDecimal(octal)
        return decimalToHexadecimal(decimal)
    }

    // Function to convert hexadecimal to binary
    fun hexadecimalToBinary(hexadecimal: String): String {
        val decimal = hexadecimalToDecimal(hexadecimal)
        return decimalToBinary(decimal)
    }

    // Function to convert hexadecimal to octal
    fun hexadecimalToOctal(hexadecimal: String): String {
        val decimal = hexadecimalToDecimal(hexadecimal)
        return decimalToOctal(decimal)
    }

}