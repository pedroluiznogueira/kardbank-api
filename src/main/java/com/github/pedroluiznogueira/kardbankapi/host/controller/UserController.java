package com.github.pedroluiznogueira.kardbankapi.host.controller;

import com.github.pedroluiznogueira.kardbankapi.domain.dto.UserDto;
import com.github.pedroluiznogueira.kardbankapi.domain.entity.User;
import com.github.pedroluiznogueira.kardbankapi.host.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/find/{userId}")
    public ResponseEntity<User> findById(@PathVariable ("userId") Long userId) {
        Optional<User> response = userService.findById(userId);
        if (!response.isPresent()) return new ResponseEntity("user not found", HttpStatus.NOT_FOUND);

        return new ResponseEntity(response.get(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<User>> findAll() {
        Optional<List<User>> response = userService.findAll();
        if (response.get().isEmpty()) return new ResponseEntity("there's no user yet", HttpStatus.NOT_FOUND);

        return new ResponseEntity(response.get(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {
        Optional<User> response = userService.save(userDto);
        if (!response.isPresent()) return new ResponseEntity("error creating user", HttpStatus.NOT_FOUND);

        return new ResponseEntity(response.get(), HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> update(
            @PathVariable ("userId") Long userId,
            @RequestBody UserDto userDto
    ) {
        Optional<User> response = userService.update(userId, userDto);
        if (!response.isPresent()) return new ResponseEntity("user to be updated not found", HttpStatus.NOT_FOUND);

        return new ResponseEntity(response.get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> delete(@PathVariable ("userId") Long userId) {
        Optional<String> response = userService.delete(userId);
        if (response.get().equals("user not found")) return new ResponseEntity("user to be deleted not found", HttpStatus.NOT_FOUND);

        return new ResponseEntity(response.get(), HttpStatus.OK);
    }
}
