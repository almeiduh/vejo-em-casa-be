package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.User;
import com.vejo.em.casa.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@Email @RequestParam String email) {
        return this.userService.save(email);
    }

//    @GetMapping
//    public Page<User> getAllUsers(@RequestParam int page, @RequestParam int size) {
//        return this.userService.findAll(page, size);
//    }
}
