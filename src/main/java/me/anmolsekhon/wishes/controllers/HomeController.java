package me.anmolsekhon.wishes.controllers;

import me.anmolsekhon.wishes.beans.Wish;
import me.anmolsekhon.wishes.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    protected DatabaseAccess da;

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("wishList", da.getWishes());
        return "index";
    }

    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("wish", new Wish());

        return "insert";
    }

    @PostMapping("/insert")
    public String processInsert(Model model, @ModelAttribute Wish wish) {
        da.insertWish(wish);
        model.addAttribute("wish", wish);

        return "insert";
    }
}
