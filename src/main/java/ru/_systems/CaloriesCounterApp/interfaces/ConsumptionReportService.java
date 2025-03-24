package ru._systems.CaloriesCounterApp.interfaces;

import ru._systems.CaloriesCounterApp.reports.ConsumptionHistoryReport;
import ru._systems.CaloriesCounterApp.reports.DayReport;

import java.time.LocalDate;
import java.util.Collection;

public interface ConsumptionReportService {

    DayReport createDayReport(Long userId, LocalDate date);
    Collection<ConsumptionHistoryReport> createConsumptionHistoryReport(Long userId);
}