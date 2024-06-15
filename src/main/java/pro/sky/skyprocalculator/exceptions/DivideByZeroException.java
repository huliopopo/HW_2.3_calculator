package pro.sky.skyprocalculator.exceptions;

public class DivideByZeroException extends IllegalArgumentException{
    public DivideByZeroException(String message) {
        super(message);
    }
}
