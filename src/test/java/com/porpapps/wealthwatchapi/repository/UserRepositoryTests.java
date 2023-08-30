package com.porpapps.wealthwatchapi.repository;


import com.porpapps.wealthwatchapi.AbstractRepositoryTest;
import com.porpapps.wealthwatchapi.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SqlMergeMode(value = SqlMergeMode.MergeMode.MERGE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserRepositoryTests extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void given_user_when_save_saveUser() {
        final var user = new User();
        user.setName("User 1");
        user.setEmail("test@test.com");
        user.setPassword("123456");

        userRepository.save(user);

        final var savedUser = userRepository.findById(user.getId()).orElseThrow();
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getPassword(), savedUser.getPassword());
    }

    @Test
    public void given_updatedUser_when_update_updateUser() {
        final var adminUser = userRepository.findById(1).orElseThrow();
        adminUser.setName("Admin updated name");
        userRepository.save(adminUser);
        final var updatedUser = userRepository.findById(adminUser.getId()).orElseThrow();

        assertEquals("Admin updated name", updatedUser.getName());
    }

    @Test
    public void given_user_when_delete_deleteUser() {
        final var adminUser = userRepository.findById(1).orElseThrow();

        userRepository.delete(adminUser);
        final var deletedUser = userRepository.findById(adminUser.getId());
        assertTrue(deletedUser.isEmpty());
    }

    @Test
    public void given_multipleUsers_when_findAll_fetchAllUsers() {
        final var user = new User();
        user.setName("User 1");
        user.setEmail("test@test.com");
        user.setPassword("123456");

        userRepository.save(user);

        final var savedUsers = userRepository.findAll();
        assertEquals(2, savedUsers.size());
    }
}
