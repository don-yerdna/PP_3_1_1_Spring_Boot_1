package don_yerdna.spring_boot_mvc.controller;

import don_yerdna.spring_boot_mvc.model.User;
import don_yerdna.spring_boot_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }

    @RequestMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/user-info";
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam(value = "id", required = true) Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/user-info";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() != 0) {
            userService.updateUser(user);
        } else {
            userService.addUser(user);
        }
        return "redirect:/";
    }

    @RequestMapping("/remove")
    public String removeUser(@RequestParam(value = "id", required = true) Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
