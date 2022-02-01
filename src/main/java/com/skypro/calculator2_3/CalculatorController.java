package com.skypro.calculator2_3;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer num1,
                       @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Пожалуйста, проверьте правильность вводимых параметров";
        }
        return num1 + "+" + num2 + "=" + calculatorService.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1,
                        @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Пожалуйста, проверьте правильность вводимых параметров";
        }
        return num1 + "-" + num2 + "=" + calculatorService.minus(num1, num2);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer num1,
                         @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Пожалуйста, проверьте правильность вводимых параметров";
        }
        if (num2 == 0) {
            return "Ошибка, деление на ноль";
        }
        return num1 + "/" + num2 + "=" + calculatorService.divide(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1,
                           @RequestParam(name = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Пожалуйста, проверьте правильность вводимых параметров";
        }
        return num1 + "*" + num2 + "=" + calculatorService.multiply(num1, num2);
    }


}