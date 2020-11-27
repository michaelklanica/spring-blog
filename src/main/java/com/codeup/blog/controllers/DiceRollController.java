package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public void rollDice(){
        return;
    }

    @GetMapping("/roll-dice/{guess}")
    @ResponseBody
    public int diceGame(@PathVariable int guess, Model model) {
        int randomDiceThrow = (int) (Math.random() * (6 - 1)) + 1;
        model.addAttribute("roll", randomDiceThrow);
        return guess;


    }


}
