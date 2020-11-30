package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String diceGame(@PathVariable int guess, Model model) {
        // FIND RANDOM NUMBER BETWEEN 1 and 6
        int randomDiceThrow = (int) (Math.random() * (7 - 1)) + 1;
        // COMPARE GUESS TO RANDOM NUMBER
        // STORE IF NUMBER WAS GUESSED CORRECTLY IN MODEL ATTRIBUTE
        model.addAttribute("guess", guess);
        model.addAttribute("roll", randomDiceThrow);
        model.addAttribute("result", guess == randomDiceThrow);
        return "roll-dice";
    }


}
