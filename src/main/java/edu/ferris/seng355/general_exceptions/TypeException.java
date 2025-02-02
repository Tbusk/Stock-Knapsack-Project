package edu.ferris.seng355.general_exceptions;

public class TypeException extends Exception {
    public TypeException(String expectedType, String currentType) {
        super(String.format("%s is expected, but was given %s.", expectedType, currentType));
    }
}
