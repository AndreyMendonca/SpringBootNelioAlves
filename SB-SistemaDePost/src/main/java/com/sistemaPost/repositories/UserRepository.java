package com.sistemaPost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaPost.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
