package com.glc.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    
@Autowired
private UserRepository userRepository;

@GetMapping("/all")
public List<User> allUsers(){
   return userRepository.findAll();
}

@GetMapping("/{id}")
public Optional<User> selectUser(@PathVariable int id){
     return userRepository.findById(id);
}

@PostMapping("")
public void addUser(@RequestBody User user){
    userRepository.save(user);
}

@DeleteMapping("/{id}")
public void deleteUser(@PathVariable int id){
    userRepository.deleteById(id);
}


}
