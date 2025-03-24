package ru._systems.CaloriesCounterApp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "meal")
@DynamicInsert
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long id;

    @Column(name = "meal_name")
    @NonNull
    private String mealName;

    @Column(name = "calories")
    @NonNull
    private Integer calories;

    @Column(name = "protein")
    @NonNull
    private Integer protein;

    @Column(name = "fat")
    @NonNull
    private Integer fat;

    @Column(name = "carbohydrate")
    @NonNull
    private Integer carbohydrate;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "meal")
//    private List<ConsumptionRecords> consumptionRecordsList;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id) && Objects.equals(mealName, meal.mealName) && Objects.equals(calories, meal.calories) && Objects.equals(protein, meal.protein) && Objects.equals(fat, meal.fat) && Objects.equals(carbohydrate, meal.carbohydrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mealName, calories, protein, fat, carbohydrate);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", mealName='" + mealName + '\'' +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}