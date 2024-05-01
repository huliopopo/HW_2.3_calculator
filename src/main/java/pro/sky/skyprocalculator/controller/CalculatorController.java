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
        if (calculatorService.checkIsNull(num1, num2) != null) {
            return calculatorService.checkIsNull(num1, num2);
        } else {
            calculatorService.adding(num1, num2);
            return num1 + " + " + num2 + " = " + calculatorService.getResult();
        }
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1,
                        @RequestParam(value = "num2", required = false) Integer num2) {
        if (calculatorService.checkIsNull(num1, num2) != null) {
            return calculatorService.checkIsNull(num1, num2);
        } else {
            calculatorService.adding(num1, num2);
            return num1 + " + " + num2 + " = " + calculatorService.getResult();
        }
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer num1,
                           @RequestParam(value = "num2", required = false) Integer num2) {
        if (calculatorService.checkIsNull(num1, num2) != null) {
            return calculatorService.checkIsNull(num1, num2);
        } else {
            calculatorService.adding(num1, num2);
            return num1 + " + " + num2 + " = " + calculatorService.getResult();
        }
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer num1,
                         @RequestParam(value = "num2", required = false) Integer num2) {
        if (calculatorService.checkIsNull(num1, num2) != null) {
            return calculatorService.checkIsNull(num1, num2);
        } else if (num2 != 0) {
            calculatorService.dividing(num1, num2);
            return num1 + " / " + num2 + " = " + calculatorService.getResult();
        } else {
            return "Деление на 0!";
        }
    }


}
