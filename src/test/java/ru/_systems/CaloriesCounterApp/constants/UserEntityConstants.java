package ru._systems.CaloriesCounterApp.constants;

import ru._systems.CaloriesCounterApp.models.Ambition;
import ru._systems.CaloriesCounterApp.models.Sex;
import ru._systems.CaloriesCounterApp.models.User;

import java.util.Arrays;
import java.util.List;

public class UserEntityConstants {
    public static final User USER_ONE_MALE;
    public static final User USER_TWO_MALE;
    public static final User USER_TWO_MALE_UPDATED;
    public static final User USER_THREE_FEMALE;
    public static final List<User> USERS_LIST;
    public static final List<User> USERS_LIST_UPDATED;

    static {
        USER_ONE_MALE = new User(
                null,
                "User1M",
                "user1@gmail.com",
                Sex.MALE,
                18,
                80F,
                120,
                Ambition.REDUCE,
                1276);
        USER_TWO_MALE = new User(
                null,
                "User2M",
                "user2@gmail.com",
                Sex.MALE,
                18,
                80F,
                120,
                Ambition.SUPPORT,
                1595);
        USER_TWO_MALE_UPDATED = new User(
                2L,
                "User2M",
                "user2@gmail.com",
                Sex.MALE,
                20,
                80F,
                120,
                Ambition.SUPPORT,
                1595);
        USER_THREE_FEMALE = new User(
                null,
                "User3F",
                "user3@gmail.com",
                Sex.FEMALE,
                55,
                70F,
                189,
                Ambition.GETFAT,
                1731);
        USERS_LIST = Arrays.asList(USER_ONE_MALE, USER_TWO_MALE, USER_THREE_FEMALE);
        USERS_LIST_UPDATED = Arrays.asList(USER_TWO_MALE, USER_THREE_FEMALE);
    }
}
