package pro.sky.skyprocalculator.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprocalculator.exceptions.DivideByZeroException;

@Service
public class CalculatorService {

    public Integer adding(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public Integer subtracting(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public Integer multiplying(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public Integer dividing(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new DivideByZeroException("Деление на 0!");
        }
        return num1 / num2;
    }
}
