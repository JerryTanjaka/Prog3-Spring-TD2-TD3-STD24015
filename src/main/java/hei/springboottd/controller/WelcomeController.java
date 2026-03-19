package hei.springboottd.controller;

import hei.springboottd.service.WelcomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private final WelcomeService welcomeService;
    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }
    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "World") String name) {
        return welcomeService.getWelcomeMessage(name);
    }
}