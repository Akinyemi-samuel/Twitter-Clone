package com.samuel.service;

import com.samuel.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Transactional
    public Long getUserIdByEmail(String email) {
      return userRepository.findByEmail(email).get().getUserId();
    }
}
