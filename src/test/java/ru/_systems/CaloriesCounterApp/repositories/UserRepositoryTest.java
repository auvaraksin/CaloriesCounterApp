package ru._systems.CaloriesCounterApp.repositories;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru._systems.CaloriesCounterApp.models.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru._systems.CaloriesCounterApp.constants.UserEntityConstants.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Should save and return all users")
    @Order(1)
    @Rollback(value = false)
    void shouldSaveAndReturnAllUsers() {
        System.out.println("<===Test shouldSaveAndReturnAllUsers start===>");

        userRepository.save(USER_ONE_MALE);
        userRepository.save(USER_TWO_MALE);
        userRepository.save(USER_THREE_FEMALE);

        System.out.println("<===================================>");
        System.out.println("InitialUsersList = " + USERS_LIST);
        System.out.println("<===================================>");

        List<User> savedUsersList = userRepository.findAll();

        System.out.println("<===================================>");
        System.out.println("SavedUsersList = " + savedUsersList);
        System.out.println("<===================================>");

        assertNotNull(savedUsersList);
        assertEquals(USERS_LIST, savedUsersList);

        System.out.println("<===Test shouldSaveAndReturnAllUsers end===>");
    }

    @Test
    @DisplayName("Should return user by Id")
    @Order(2)
    @Rollback(value = false)
    void shouldReturnUserById() {
        System.out.println("<===Test shouldReturnUserById start===>");

        User checkedUser = userRepository.findById(USER_TWO_MALE.getId()).orElse(null);

        assertNotNull(checkedUser);
        assertEquals(USER_TWO_MALE, checkedUser);
        assertNotEquals(USER_ONE_MALE, checkedUser);
        assertNotEquals(USER_THREE_FEMALE, checkedUser);

        System.out.println("<===Test shouldReturnUserById end===>");
    }


    @Test
    @DisplayName("Should delete user by Id")
    @Order(3)
    @Rollback(value = false)
    void shouldDeleteUserById() {
        System.out.println("<===Test shouldDeleteUserById start===>");

        System.out.println("<===================================>");
        System.out.println("InitialUsersList = " + USERS_LIST);
        System.out.println("<===================================>");

        List<User> savedUsersList = userRepository.findAll();

        System.out.println("<===================================>");
        System.out.println("SavedUsersList = " + savedUsersList);
        System.out.println("<===================================>");

        assertNotNull(savedUsersList);
        assertEquals(USERS_LIST, savedUsersList);
        userRepository.deleteById(1L);

        List<User> updatedUsersList = userRepository.findAll();

        System.out.println("<===================================>");
        System.out.println("UpdatedUsersList = " + updatedUsersList);
        System.out.println("<===================================>");

        assertNotEquals(USERS_LIST, updatedUsersList);
        assertEquals(USERS_LIST_UPDATED, updatedUsersList);

        System.out.println("<===Test shouldDeleteUserById end===>");
    }

    @Test
    @DisplayName("Should update user by Id")
    @Order(4)
    @Rollback(value = false)
    void shouldUpdateUserById() {
        System.out.println("<===Test shouldUpdateUserById start===>");

        User updatedUser = userRepository.findById(2L).get();
        assertEquals(USER_TWO_MALE, updatedUser);
        assertNotEquals(USER_TWO_MALE_UPDATED, updatedUser);

        updatedUser.setAge(20);
        userRepository.save(updatedUser);

        updatedUser = userRepository.findById(2L).get();
        assertNotEquals(USER_TWO_MALE, updatedUser);
        assertEquals(USER_TWO_MALE_UPDATED, updatedUser);

        System.out.println("<===Test shouldUpdateUserById end===>");
    }
}
