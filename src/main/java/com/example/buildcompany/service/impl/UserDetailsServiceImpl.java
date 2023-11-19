package com.example.buildcompany.service.impl;

import com.example.buildcompany.model.entity.users.User;
import com.example.buildcompany.repository.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<User> userOptional = userRepository.findByMail(username);
    if(userOptional.isPresent()){
      return new org.springframework.security.core.userdetails.User(
          userOptional.get().getMail(),
          userOptional.get().getPassword(),
          new ArrayList<>()
      );
    }
    throw new UsernameNotFoundException("User not found with username: " + username);
  }
}
