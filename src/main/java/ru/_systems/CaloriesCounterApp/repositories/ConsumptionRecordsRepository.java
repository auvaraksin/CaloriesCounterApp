package ru._systems.CaloriesCounterApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru._systems.CaloriesCounterApp.models.ConsumptionRecords;

import java.time.LocalDate;
import java.util.List;

public interface ConsumptionRecordsRepository extends JpaRepository<ConsumptionRecords, Long> {
    @Query(value = "SELECT SUM (calories) FROM consumption_records JOIN meal ON consumption_records.meal_id = meal.meal_id AND user_id = ?1 AND date = ?2", nativeQuery = true)
    Integer getCaloriesTotalByDate(Long userId, LocalDate date);

    @Query(value = "SELECT COUNT (consumption_records_id) FROM consumption_records JOIN meal ON consumption_records.meal_id = meal.meal_id AND user_id = ?1 AND date = ?2", nativeQuery = true)
    Integer getConsumptionCountTotalByDate(Long userId, LocalDate date);

    @Query(value = "SELECT meal.meal_name FROM consumption_records JOIN meal ON consumption_records.meal_id = meal.meal_id AND  user_id = ?1 AND date = ?2", nativeQuery = true)
    List<String> getMealNameByDateAndUserId(Long userId, LocalDate date);
}