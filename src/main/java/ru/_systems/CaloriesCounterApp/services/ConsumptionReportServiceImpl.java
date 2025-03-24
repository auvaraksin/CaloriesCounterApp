package ru._systems.CaloriesCounterApp.services;

import org.springframework.stereotype.Service;
import ru._systems.CaloriesCounterApp.interfaces.ConsumptionReportService;
import ru._systems.CaloriesCounterApp.interfaces.UserService;
import ru._systems.CaloriesCounterApp.models.ConsumptionRecords;
import ru._systems.CaloriesCounterApp.reports.ConsumptionHistoryReport;
import ru._systems.CaloriesCounterApp.reports.DayReport;
import ru._systems.CaloriesCounterApp.repositories.ConsumptionRecordsRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConsumptionReportServiceImpl implements ConsumptionReportService {
    private final ConsumptionRecordsRepository consumptionRecordsRepository;
    private final UserService userService;

    public ConsumptionReportServiceImpl(ConsumptionRecordsRepository consumptionRecordsRepository,
                                        UserService userService) {
        this.consumptionRecordsRepository = consumptionRecordsRepository;
        this.userService = userService;
    }

    @Override
    public DayReport createDayReport(Long userId, LocalDate date) {
        String userName = (userService.getUserById(userId).getUserName());
        Integer dailyNormConsume = (userService.getUserById(userId).getDailyNormConsume());
        Integer caloriesTotal = consumptionRecordsRepository.getCaloriesTotalByDate(userId, date);
        Integer consumptionCountTotal = consumptionRecordsRepository.getConsumptionCountTotalByDate(userId, date);
        Boolean checkHealthConsumption = (userService.getUserById(userId).
                getDailyNormConsume() > caloriesTotal) ? true : false;
        return new DayReport(date, userName, dailyNormConsume, caloriesTotal, consumptionCountTotal, checkHealthConsumption);
    }

    @Override
    public Collection<ConsumptionHistoryReport> createConsumptionHistoryReport(Long userId) {
        Set<LocalDate> localDateSet =
                consumptionRecordsRepository
                        .findAll()
                        .stream()
                        .parallel()
                        .filter(l -> l.getUser()
                                .getId()
                                .equals(userId))
                        .map(ConsumptionRecords::getDate)
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toCollection(LinkedHashSet::new));
        LocalDate[] localDateArray = localDateSet.toArray(new LocalDate[localDateSet.size()]);
        String userName = (userService.getUserById(userId).getUserName());
        List<ConsumptionHistoryReport> consumptionHistoryReportList = new ArrayList<>();
        for(LocalDate localDate : localDateArray)
            consumptionHistoryReportList.add(new ConsumptionHistoryReport(localDate, userName, consumptionRecordsRepository.getMealNameByDateAndUserId(userId, localDate)));
        return consumptionHistoryReportList;
    }
}