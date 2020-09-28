package br.com.eliza.smsproject.resource;

import br.com.eliza.smsproject.model.User;
import br.com.eliza.smsproject.repository.UserRepository;
import br.com.eliza.smsproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1//user")
public class UserResource {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    @Autowired
    public UserResource(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<User> createUser (@RequestBody @Valid  User user){
        User u = userRepository.save(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<User> deleteUser (@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update (@PathVariable @RequestBody @Valid Long id){
      User u = userService.update(id);
      return ResponseEntity.ok(new User());
    }

    @GetMapping
    @Transactional
    public List<User> findAll(){
         return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<User> findById(@PathVariable Long id){
        User u = userRepository.findById(id).get();
        return new ResponseEntity<>(u, HttpStatus.OK);

    }

}
