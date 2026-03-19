package hei.springboottd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "World") String name) {
        return String.format("Welcome, %s!", name);
    }
}
