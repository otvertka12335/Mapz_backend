package com.mapz.controller;

import com.mapz.model.User;
import com.mapz.model.User;
import com.mapz.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
public class UsrController {
    @Autowired
    private UserRepo UserRepo;

    @GetMapping
    public Iterable<User> getAll() {
        return UserRepo.findAll();
    }

    @PostMapping()
    public User save(@RequestBody final User User) {
        UserRepo.save(User);
        return User;
    }

    @GetMapping("/{id}")
    public User find(@PathVariable("id") User User) {
        return User;
    }

    @PutMapping("/{id}")
    public User edit(@PathVariable("id") User User,
                    @RequestBody User newUser) {
        BeanUtils.copyProperties(newUser, User, "id");
        return UserRepo.save(User);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") User User) {
        UserRepo.delete(User);
    }

    @RequestMapping("/findByUsername")
    public Optional<User> findByUsername(@RequestParam("username")String username) {
        return UserRepo.findByUsername(username);
    }
}
