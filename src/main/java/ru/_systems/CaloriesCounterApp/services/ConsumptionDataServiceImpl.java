package ru._systems.CaloriesCounterApp.services;

import org.springframework.stereotype.Service;
import ru._systems.CaloriesCounterApp.interfaces.ConsumptionDataService;
import ru._systems.CaloriesCounterApp.models.ConsumptionRecords;
import ru._systems.CaloriesCounterApp.repositories.ConsumptionRecordsRepository;

import java.util.List;

@Service
public class ConsumptionDataServiceImpl implements ConsumptionDataService {
    private final ConsumptionRecordsRepository consumptionRecordsRepository;

    public ConsumptionDataServiceImpl(ConsumptionRecordsRepository consumptionRecordsRepository) {
        this.consumptionRecordsRepository = consumptionRecordsRepository;
    }

    @Override
    public ConsumptionRecords createConsumptionRecord(ConsumptionRecords consumptionRecords) {
        consumptionRecords.setId(null);
        return consumptionRecordsRepository.save(consumptionRecords);
    }

    @Override
    public List<ConsumptionRecords> getConsumptionRecords() {
        return consumptionRecordsRepository.findAll();
    }

    @Override
    public ConsumptionRecords updateConsumptionRecord(ConsumptionRecords consumptionRecords) {
        return consumptionRecordsRepository.save(consumptionRecords);
    }

    @Override
    public void deleteConsumptionRecord(Long consumptionDataListId) {
        consumptionRecordsRepository.deleteById(consumptionDataListId);
    }
}