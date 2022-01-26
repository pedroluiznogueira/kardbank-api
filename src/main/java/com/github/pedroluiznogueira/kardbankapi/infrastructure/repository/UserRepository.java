package com.github.pedroluiznogueira.kardbankapi.infrastructure.repository;

import com.github.pedroluiznogueira.kardbankapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
