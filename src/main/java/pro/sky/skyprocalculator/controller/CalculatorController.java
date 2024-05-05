package pro.sky.skyprocalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprocalculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer num1,
                       @RequestParam(value = "num2", required = false) Integer num2) {
        String check = checkIsNull(num1, num2);
        if (check != null) {
            return check;
        } else {
            return num1 + " + " + num2 + " = " + calculatorService.adding(num1, num2);
        }
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1,
                        @RequestParam(value = "num2", required = false) Integer num2) {
        String check = checkIsNull(num1, num2);
        if (check != null) {
            return check;
        } else {
            return num1 + " - " + num2 + " = " + calculatorService.subtracting(num1, num2);
        }
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer num1,
                           @RequestParam(value = "num2", required = false) Integer num2) {
        String check = checkIsNull(num1, num2);
        if (check != null) {
            return check;
        } else {
            return num1 + " * " + num2 + " = " + calculatorService.multiplying(num1, num2);
        }
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer num1,
                         @RequestParam(value = "num2", required = false) Integer num2) {
        String check = checkIsNull(num1, num2);
        if (check != null) {
            return check;
        } else if (num2 != 0) {
            return num1 + " / " + num2 + " = " + calculatorService.dividing(num1, num2);
        } else {
            return "Деление на 0!";
        }
    }

    private String checkIsNull(Integer num1, Integer num2) {
        if (num1 == null) {
            return "Параметр <b>num1</b> не задан";
        } else if (num2 == null) {
            return "Параметр <b>num2</b> не задан";
        } else {
            return null;
        }
    }
}
