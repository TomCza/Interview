package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.kafka.Sender;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcController {

    private Inserter jsonParser = new Inserter();

    @Autowired
    Sender sender = new Sender();

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String showForm(Model model) {
        Bet bet = new Bet();
        model.addAttribute("bet", bet);
        return "search_form";
    }

    @PostMapping("/search")
    public String submitForm(@ModelAttribute("bet") Bet bet) {
        return "search_success";
    }

    @GetMapping("/populate")
    public String populate_db() throws ClassNotFoundException, IOException, SQLException {
        jsonParser.populate(this);
        return "populate";
    }

    public void sendMessage(String message) {
        sender.send("bet_detail", message);
    }
}