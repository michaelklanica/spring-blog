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
        int randomDiceThrow = (int) (Math.random() * (7 - 1)) + 1;
        model.addAttribute("guess", guess);
        model.addAttribute("roll", randomDiceThrow);
        if (randomDiceThrow == guess) {
            model.addAttribute("result", true);
            return "roll-dice";
        } else {
            model.addAttribute("result", false);
            return "roll-dice";
        }

    }


}
