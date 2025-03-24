package ru._systems.CaloriesCounterApp.services;

import org.springframework.stereotype.Service;
import ru._systems.CaloriesCounterApp.interfaces.MealService;
import ru._systems.CaloriesCounterApp.models.Meal;
import ru._systems.CaloriesCounterApp.repositories.MealRepository;

import java.util.Collection;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final static Integer DEFAULT = 0;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal createMeal(Meal meal) {
        meal.setId(null);
        if (meal.getProtein() < 0) meal.setProtein(DEFAULT);
        if (meal.getFat() < 0) meal.setFat(DEFAULT);
        if (meal.getCarbohydrate() < 0) meal.setCarbohydrate(DEFAULT);
        if (meal.getCalories() < 0) meal.setCalories(DEFAULT);
        return mealRepository.save(meal);
    }

    @Override
    public Collection<Meal> getMealAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal getMealById(Long mealId) {
        return mealRepository.findById(mealId).orElse(null);
    }

    @Override
    public Meal updateMeal(Meal meal) {
        if (meal.getProtein() < 0) meal.setProtein(DEFAULT);
        if (meal.getFat() < 0) meal.setFat(DEFAULT);
        if (meal.getCarbohydrate() < 0) meal.setCarbohydrate(DEFAULT);
        if (meal.getCalories() < 0) meal.setCalories(DEFAULT);
        return mealRepository.save(meal);
    }

    @Override
    public void deleteMeal(Long mealId) {
        mealRepository.deleteById(mealId);
    }
}