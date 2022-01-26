package com.github.pedroluiznogueira.kardbankapi.host.service;

import com.github.pedroluiznogueira.kardbankapi.domain.dto.UserDto;
import com.github.pedroluiznogueira.kardbankapi.domain.entity.User;
import com.github.pedroluiznogueira.kardbankapi.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getEmail(), userDto.getCpf());
        
        return userRepository.save(user);
    }

    public User update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId).get();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCpf(userDto.getCpf());
        
        return userRepository.save(user);
    }

    public void delete(Long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
    }
}
