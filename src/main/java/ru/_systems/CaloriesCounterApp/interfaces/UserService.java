package ru._systems.CaloriesCounterApp.interfaces;

import ru._systems.CaloriesCounterApp.models.User;

import java.util.Collection;

public interface UserService {
    User createUser(User user);

    Collection<User> getUsersAll();

    User getUserById(Long userId);

    User updateUser(User user);

    void deleteUser(Long userId);
}