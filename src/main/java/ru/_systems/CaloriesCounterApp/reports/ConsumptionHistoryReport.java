package ru._systems.CaloriesCounterApp.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class ConsumptionHistoryReport {
    private LocalDate consumptionDate;
    private String userName;
    private List<String> mealList;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ConsumptionHistoryReport that = (ConsumptionHistoryReport) o;
        return Objects.equals(consumptionDate, that.consumptionDate) && Objects.equals(userName, that.userName) && Objects.equals(mealList, that.mealList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumptionDate, userName, mealList);
    }

    @Override
    public String toString() {
        return "ConsumptionHistoryReport{" +
                "consumptionDate=" + consumptionDate +
                ", userName='" + userName + '\'' +
                ", mealList=" + mealList +
                '}';
    }
}