package angular.api.controller;

import angular.api.model.User;
import angular.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/user")
    public List<User> listUser() {
        return userService.listUser();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        try {
            User user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        try {
            System.out.println(user);
            userService.saveUser(user);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            User userExists = userService.findUserById(id);
            userExists.setNombre(user.getNombre());
            userExists.setApellido1(user.getApellido1());
            userExists.setApellido2(user.getApellido2());
            userExists.setDni(user.getDni());
            userExists.setFNacimiento(user.getFNacimiento());
            userExists.setEmail(user.getEmail());
            userExists.setSexo(user.getSexo());
            userExists.setNombrePadre(user.getNombrePadre());
            userExists.setNombreMadre(user.getNombreMadre());
            userExists.setApellidoPadre(user.getApellidoPadre());
            userExists.setApellidoMadre(user.getApellidoMadre());
            userService.saveUser(userExists);
            return new ResponseEntity<User>(userExists, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
