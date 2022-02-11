package com.example.test1.Controllers;

import com.example.test1.Services.NumberService;
//import com.example.test1.Services.NumberServiceImpl;
import com.example.test1.Services.NumberServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/number")
public class ControllerN {

    @Autowired
    private NumberService numberService = new NumberServiceImpl2();

    @GetMapping("/random")
    public String getRandomNumber(Model model) {
        String randomNumber = numberService.getRandom();
        model.addAttribute("random", randomNumber);
        return "random";
    }

    @GetMapping("/next")
    public String getNextNumber(Model model) {
        String nextNumber = numberService.getNext();
        model.addAttribute("next", nextNumber);
        return "next";
    }
}
