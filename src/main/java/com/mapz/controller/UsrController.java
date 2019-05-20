package com.mapz.controller;

import com.mapz.model.Usr;
import com.mapz.repo.UsrRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UsrController {
    @Autowired
    private UsrRepo usrRepo;

    @GetMapping
    public Iterable<Usr> getAll() {
        return usrRepo.findAll();
    }

    @PostMapping()
    public Usr save(@RequestBody final Usr usr) {
        usrRepo.save(usr);
        return usr;
    }

    @GetMapping("/{id}")
    public Usr find(@PathVariable("id") Usr usr) {
        return usr;
    }

    @PutMapping("/{id}")
    public Usr edit(@PathVariable("id") Usr usr,
                    @RequestBody Usr newUsr) {
        BeanUtils.copyProperties(newUsr, usr, "id");
        return usrRepo.save(usr);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Usr usr) {
        usrRepo.delete(usr);
    }
}
