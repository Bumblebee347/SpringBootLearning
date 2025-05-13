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
    //http://localhost:8080/api/users
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public User getUserByID(@PathVariable Long id){
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found")); //Besser eine eigene Exception schreiben als eine allgemeine Runtime
    }


    //To test POST use a REST client, then add a user to the "database" (list) and then use the GET request to show the new user
    //Or use the HTML site to do it. (Not yet implemented)
    @PostMapping
    public User createUser(@RequestBody User user){
        user.setId(users.size() + 1L);
        users.add(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setAge(updatedUser.getAge());
                return user;
            }
        }
        throw new RuntimeException("User with ID " + id + " not found"); //Later own exception!
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return "User with ID " + id + " deleted";
            }
        }
        throw new RuntimeException("User with ID " + id + " not found"); //Own exception is better
    }

}
