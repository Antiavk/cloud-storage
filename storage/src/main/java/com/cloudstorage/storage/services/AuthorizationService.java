package com.cloudstorage.storage.services;


import com.cloudstorage.storage.models.Account;
import com.cloudstorage.storage.models.Login;

public interface AuthorizationService {

    public Login login(Account account);

    public void logout(String authToken);
}
