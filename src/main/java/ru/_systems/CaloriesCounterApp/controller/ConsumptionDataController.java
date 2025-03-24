package ru._systems.CaloriesCounterApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru._systems.CaloriesCounterApp.interfaces.ConsumptionDataService;
import ru._systems.CaloriesCounterApp.models.ConsumptionRecords;

@RestController
@RequestMapping("records")
public class ConsumptionDataController {
    private final ConsumptionDataService consumptionDataService;

    public ConsumptionDataController(ConsumptionDataService consumptionDataService) {
        this.consumptionDataService = consumptionDataService;
    }

    @PostMapping
    public ResponseEntity<ConsumptionRecords> createConsumptionDataRecord(@RequestBody ConsumptionRecords consumptionRecords) {
        ConsumptionRecords createConsumptionRecords = consumptionDataService.createConsumptionRecord(consumptionRecords);
        return ResponseEntity.ok(createConsumptionRecords);
    }

    @GetMapping
    public ResponseEntity getConsumptionDataRecords() {
        return ResponseEntity.ok(consumptionDataService.getConsumptionRecords());
    }

    @PutMapping
    public ResponseEntity<ConsumptionRecords> updateConsumptionDataRecord(@RequestBody ConsumptionRecords consumptionRecords) {
        ConsumptionRecords updateConsumptionRecords = consumptionDataService.updateConsumptionRecord(consumptionRecords);
        if (updateConsumptionRecords == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updateConsumptionRecords);
    }

    @DeleteMapping("{dataRecordId}")
    public ResponseEntity deleteUser(@PathVariable Long dataRecordId) {
        consumptionDataService.deleteConsumptionRecord(dataRecordId);
        return ResponseEntity.ok().build();
    }

}