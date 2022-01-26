package com.github.pedroluiznogueira.kardbankapi.host.controller;

import com.github.pedroluiznogueira.kardbankapi.domain.dto.UserDto;
import com.github.pedroluiznogueira.kardbankapi.domain.entity.User;
import com.github.pedroluiznogueira.kardbankapi.host.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/find/{userId}")
    public User findById(@PathVariable ("userId") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/find")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/update/{userId}")
    public User update(
            @PathVariable ("userId") Long userId,
            @RequestBody UserDto userDto
    ) {
        return userService.update(userId, userDto);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable ("userId") Long userId) {
        userService.delete(userId);
    }
}
