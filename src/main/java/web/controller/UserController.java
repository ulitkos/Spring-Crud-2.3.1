package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("elements", users);
        return "/users/index";
    }

    @GetMapping(value = "/add")
    public String addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        return "/users/add";
    }

    @PostMapping(value = "/new")
    public String addUserPost(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/del/{id}")
    public String delUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/edit";
    }

    @PostMapping(value = "/edit")
    public String editUserPost(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/users";
    }
}
