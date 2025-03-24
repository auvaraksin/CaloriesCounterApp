package ru._systems.CaloriesCounterApp.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "consumption_records")
@DynamicInsert
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consumption_records_id")
    private Long id;

    @Column(name = "date")
    @NonNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ConsumptionRecords that = (ConsumptionRecords) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(user, that.user) && Objects.equals(meal, that.meal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, user, meal);
    }

    @Override
    public String toString() {
        return "ConsumptionRecords{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + user +
                ", meal=" + meal +
                '}';
    }
}