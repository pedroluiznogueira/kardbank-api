package com.github.pedroluiznogueira.kardbankapi.host.service;

import com.github.pedroluiznogueira.kardbankapi.domain.dto.UserDto;
import com.github.pedroluiznogueira.kardbankapi.domain.entity.User;
import com.github.pedroluiznogueira.kardbankapi.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }

    public Optional<User> save(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getEmail(), userDto.getCpf());

        return Optional.of(userRepository.save(user));
    }

    public Optional<User> update(Long userId, UserDto userDto) {
        Optional<User> user = userRepository.findById(userId);
        user.get().setName(userDto.getName());
        user.get().setEmail(userDto.getEmail());
        user.get().setCpf(userDto.getCpf());
        return Optional.of(userRepository.save(user.get()));
    }

    public Optional<String> delete(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) return Optional.of("user not found");
        userRepository.delete(user.get());

        return Optional.of("user deleted");
    }
}
