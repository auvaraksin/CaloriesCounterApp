package ru._systems.CaloriesCounterApp.interfaces;

import ru._systems.CaloriesCounterApp.models.Meal;

import java.util.Collection;

public interface MealService {
    Meal createMeal(Meal meal);

    Collection<Meal> getMealAll();

    Meal getMealById(Long mealId);

    Meal updateMeal(Meal meal);

    void deleteMeal(Long mealId);
}