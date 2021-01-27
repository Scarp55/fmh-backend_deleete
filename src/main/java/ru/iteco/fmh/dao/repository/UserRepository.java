package ru.iteco.fmh.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iteco.fmh.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}