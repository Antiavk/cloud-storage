package com.cloudstorage.storage.services;

import com.cloudstorage.storage.models.Account;
import com.cloudstorage.storage.models.Login;
import com.cloudstorage.storage.models.UserTable;
import com.cloudstorage.storage.exceptions.BadCredentialException;
import com.cloudstorage.storage.exceptions.InputDataException;
import com.cloudstorage.storage.repository.ClientRepository;
import com.cloudstorage.storage.repository.UserJpaRepository;
import com.cloudstorage.storage.util.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private ClientRepository repository;
    private UserJpaRepository userRepository;

    public AuthorizationServiceImpl(ClientRepository repository, UserJpaRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Login login(Account account) {

        // Account verification
        final UserTable verified = userRepository.findByLoginAndPassword(account.getLogin(), account.getPassword());

        // Check of verified account
        if (verified == null) {
            // Send code: 400
            throw new BadCredentialException("Incorrect login or password");
        }
        // Create token
        final Login login = repository.login(verified.getDirectory());

        return login;
    }

    @Override
    public void logout(String authToken) {

        //  Validation
        final boolean isValid = ValidationUtils.tokenValidation(authToken);
        if (!isValid) {
            // Send code: 400
            throw new InputDataException("Error input data");
        }
        repository.logout(authToken);
    }
}
