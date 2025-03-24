package ru._systems.CaloriesCounterApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru._systems.CaloriesCounterApp.interfaces.ConsumptionReportService;

import java.time.LocalDate;

@RestController
@RequestMapping("reports")
public class ReportController {
    private final ConsumptionReportService consumptionReportService;

    public ReportController(ConsumptionReportService consumptionReportService) {
        this.consumptionReportService = consumptionReportService;
    }

    @GetMapping("/dayreport")
    public ResponseEntity getUserDayReport(@RequestParam Long userId, @RequestParam LocalDate date) {
        return ResponseEntity.ok(consumptionReportService.createDayReport(userId, date));
    }

    @GetMapping("/historyreport") ResponseEntity getUserConsumptionHistoryReport(@RequestParam Long userId) {
        return ResponseEntity.ok(consumptionReportService.createConsumptionHistoryReport(userId));
    }
}