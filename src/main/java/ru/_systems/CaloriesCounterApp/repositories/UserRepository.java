package ru._systems.CaloriesCounterApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru._systems.CaloriesCounterApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}