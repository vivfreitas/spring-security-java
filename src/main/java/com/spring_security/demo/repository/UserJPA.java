package com.spring_security.demo.repository;

import com.spring_security.demo.entities.JavaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPA extends JpaRepository<JavaUser, Long> {
}
