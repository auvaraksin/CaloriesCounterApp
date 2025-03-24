package ru._systems.CaloriesCounterApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru._systems.CaloriesCounterApp.models.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
}