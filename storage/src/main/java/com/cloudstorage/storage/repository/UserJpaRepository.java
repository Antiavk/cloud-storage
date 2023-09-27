package com.cloudstorage.storage.repository;

import com.cloudstorage.storage.models.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserTable, Long> {
    public UserTable findByLoginAndPassword(String login, String password);
}
