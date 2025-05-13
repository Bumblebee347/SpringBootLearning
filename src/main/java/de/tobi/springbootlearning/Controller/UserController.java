package de.tobi.springbootlearning.Controller;

import de.tobi.springbootlearning.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    //---- Database simulation ----
    private List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1L, "Tobi", "<EMAIL>", 25));
        users.add(new User(2L, "John", "<EMAIL>", 30));
        users.add(new User(3L, "Mary", "<EMAIL>", 20));
    }

    //---- real controller

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found")); //Besser eine eigene Exception schreiben als eine allgemeine Runtime
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        user.setId(users.size() + 1L);
        users.add(user);
        return user;
    }



}
