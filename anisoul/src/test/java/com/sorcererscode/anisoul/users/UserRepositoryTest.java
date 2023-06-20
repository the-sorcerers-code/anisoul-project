package com.sorcererscode.anisoul.users;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldGetUserByUsername_success() {

        setUpUserTestData();

        String username = "testuser";

        Optional<User> foundUser = userRepository.findByUsername(username);

        assertNotNull(foundUser);
    }

    @Test
    public void ShouldGetUserByUsername_fail() {
        setUpUserTestData();

        String username = "someotherusername";

        Optional<User> nonExistentUser = userRepository.findByUsername(username);

        assertEquals(nonExistentUser, Optional.empty());
    }

    private void setUpUserTestData(){
        User testUser = new User();

        testUser.setEmail("test@gmail.com");
        testUser.setUsername("testuser");
        testUser.setPassword("somepass");
        testUser.setActive(true);
        testUser.setFirstName("Test");
        testUser.setLastName("User");

        userRepository.save(testUser);

    }
}