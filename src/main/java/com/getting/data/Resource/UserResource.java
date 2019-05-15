package com.getting.data.Resource;

import com.getting.data.Repository.UserRepository;
import com.getting.data.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{firstname}")
    public List<Users> getUser(@PathVariable String firstname) {

        return userRepository.findByFirstname(firstname);

    }

    @PutMapping("/users/{id}")
    public List<Users> updateUser(@Valid @RequestBody Users users) {
         userRepository.save(users);
        return userRepository.findAll();
    }


    @PostMapping("/users")
    public List<Users> persist(@RequestBody final Users users) {
        userRepository.save(users);
        return userRepository.findAll();
    }

    @DeleteMapping("users/{id}")
    public List<Users> deleteMethod(@PathVariable Long id) {

         userRepository.deleteById(id);
        return userRepository.findAll();



    }

}




