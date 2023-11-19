package com.example.buildcompany.repository;

import com.example.buildcompany.model.entity.users.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  Optional<User> findByMail(String mail);
}
