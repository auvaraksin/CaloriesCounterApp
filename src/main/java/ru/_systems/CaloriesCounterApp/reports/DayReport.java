package ru._systems.CaloriesCounterApp.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class DayReport {
    private LocalDate date;
    private String userName;
    private Integer dailyNormConsume;
    private Integer caloriesTotal;
    private Integer consumptionCountTotal;
    private Boolean checkHealthConsumption;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DayReport dayReport = (DayReport) o;
        return Objects.equals(date, dayReport.date) && Objects.equals(userName, dayReport.userName) && Objects.equals(dailyNormConsume, dayReport.dailyNormConsume) && Objects.equals(caloriesTotal, dayReport.caloriesTotal) && Objects.equals(consumptionCountTotal, dayReport.consumptionCountTotal) && Objects.equals(checkHealthConsumption, dayReport.checkHealthConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, userName, dailyNormConsume, caloriesTotal, consumptionCountTotal, checkHealthConsumption);
    }

    @Override
    public String toString() {
        return "DayReport{" +
                "date=" + date +
                ", userName='" + userName + '\'' +
                ", dailyNormConsume=" + dailyNormConsume +
                ", caloriesTotal=" + caloriesTotal +
                ", consumptionCountTotal=" + consumptionCountTotal +
                ", checkHealthConsumption=" + checkHealthConsumption +
                '}';
    }
}