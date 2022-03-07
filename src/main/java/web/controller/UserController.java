package web.controller;


import hibernate.model.User;
import hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ComponentScan(basePackages = "hibernate")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "startPage";
    }

    @GetMapping(value = "/new")
    public String newUser (ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String edidUser (@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "/{id}")
    public String edit(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }
}
