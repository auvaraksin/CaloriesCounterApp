package ru._systems.CaloriesCounterApp.services;

import org.springframework.stereotype.Service;
import ru._systems.CaloriesCounterApp.interfaces.UserService;
import ru._systems.CaloriesCounterApp.models.Ambition;
import ru._systems.CaloriesCounterApp.models.Sex;
import ru._systems.CaloriesCounterApp.models.User;
import ru._systems.CaloriesCounterApp.repositories.UserRepository;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final static Integer DEFAULTAGE = 18;
    private final static Float DEFAULTWEIGHT = 80.0F;
    private final static Integer DEFAULTHEIGHT = 120;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        user.setId(null);
        if (user.getAge() < 18) user.setAge(DEFAULTAGE);
        if (user.getWeight() < 50) user.setWeight(DEFAULTWEIGHT);
        if (user.getHeight() < 120) user.setHeight(DEFAULTHEIGHT);
        user.setDailyNormConsume(calculateDailyNormCalories(user.getSex(),
                user.getAge(), user.getWeight(), user.getHeight(), user.getAmbition()));
        return userRepository.save(user);
    }

    @Override
    public Collection<User> getUsersAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        if (user.getAge() < 18) user.setAge(DEFAULTAGE);
        if (user.getWeight() < 50) user.setWeight(DEFAULTWEIGHT);
        if (user.getHeight() < 120) user.setHeight(DEFAULTHEIGHT);
        user.setDailyNormConsume(calculateDailyNormCalories(user.getSex(),
                user.getAge(), user.getWeight(), user.getHeight(), user.getAmbition()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private Integer calculateDailyNormCalories(Sex sex, Integer age, Float weight, Integer height, Ambition ambition) {
        Float coefficient = switch (ambition) {
            case REDUCE -> 0.8F;
            case SUPPORT -> 1.0F;
            case GETFAT -> 1.2F;
        };
        Integer dailyNormCalories = switch (sex) {
            case MALE -> (int) (Math.round(((88.362 + (13.397 * weight) + (4.479 * height) - (5.677 * age))  * coefficient)));
            case FEMALE -> (int) (Math.round(((447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age))  * coefficient)));
        };
        return dailyNormCalories;
    }
}