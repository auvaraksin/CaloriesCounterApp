package ru._systems.CaloriesCounterApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru._systems.CaloriesCounterApp.interfaces.MealService;
import ru._systems.CaloriesCounterApp.models.Meal;

@RestController
@RequestMapping("meal")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) {
        Meal createMeal = mealService.createMeal(meal);
        return ResponseEntity.ok(createMeal);

    }

    @GetMapping
    public ResponseEntity getMeal(@RequestParam(required = false) Long mealId) {
        if (mealId != null) {
            Meal meal = mealService.getMealById(mealId);
            if (meal == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(meal);
        }
        return ResponseEntity.ok(mealService.getMealAll());
    }

    @PutMapping
    public ResponseEntity<Meal> updateUser(@RequestBody Meal meal) {
        Meal updateMeal = mealService.updateMeal(meal);
        if (updateMeal == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updateMeal);
    }

    @DeleteMapping("{mealId}")
    public ResponseEntity deleteMeal(@PathVariable Long mealId) {
        mealService.deleteMeal(mealId);
        return ResponseEntity.ok().build();
    }
}