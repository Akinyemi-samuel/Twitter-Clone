package com.samuel.service;

import com.samuel.model.ConfirmationToken;
import com.samuel.model.User;
import com.samuel.model.UserConfirmation;
import com.samuel.repository.ConfirmationTokenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final UserConfirmationService userConfirmationService;


    @Transactional
    public String createConfirmationToken(User user){
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = ConfirmationToken.builder()
                .token(token)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        confirmationTokenRepository.save(confirmationToken);
        return token;
    }


    @Transactional
    public String confirmToken(String token){
         ConfirmationToken confirmationToken =
                 confirmationTokenRepository.findByToken(token)
                         .orElseThrow(()-> new RuntimeException("Verification Token does not exists"));

         if (confirmationToken.getConfirmedAt() != null) throw new RuntimeException("Token is already confirmed");

         if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) throw new RuntimeException("Token is already expired");

         updateTokenConfirmedAt(confirmationToken.getToken());

         userConfirmationService.ConfirmUserEmail(confirmationToken.getUser());

         return "You have been successfully registered";
    }


    public void updateTokenConfirmedAt(String token){
        confirmationTokenRepository.updateConfirmedAt(token, String.valueOf(LocalDateTime.now()));
    }

    public User getUserByToken(String token){
        ConfirmationToken confirmationToken =
                confirmationTokenRepository.findByToken(token)
                        .orElseThrow(()-> new RuntimeException("Verification Token does not exists"));

        return  confirmationToken.getUser();
    }
}
