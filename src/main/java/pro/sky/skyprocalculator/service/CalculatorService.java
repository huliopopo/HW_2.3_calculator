package pro.sky.skyprocalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void adding(Integer num1, Integer num2) {
        result = num1 + num2;
    }

    public void subtracting(Integer num1, Integer num2) {
        result = num1 - num2;
    }

    public void multiplying(Integer num1, Integer num2) {
        result = num1 * num2;
    }

    public void dividing(Integer num1, Integer num2) {
        result = num1 / num2;
    }

    public String checkIsNull(Integer num1, Integer num2) {
        if (num1 == null) {
            return "Параметр <b>num1</b> не задан";
        } else if (num2 == null) {
            return "Параметр <b>num2</b> не задан";
        } else {
            return null;
        }
    }


}
