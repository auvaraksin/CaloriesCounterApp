package ru._systems.CaloriesCounterApp.interfaces;

import ru._systems.CaloriesCounterApp.models.ConsumptionRecords;

import java.util.Collection;


public interface ConsumptionDataService {
    ConsumptionRecords createConsumptionRecord(ConsumptionRecords consumptionRecords);
    Collection<ConsumptionRecords> getConsumptionRecords();
    ConsumptionRecords updateConsumptionRecord(ConsumptionRecords consumptionRecords);
    void deleteConsumptionRecord(Long consumptionDataListId);
}