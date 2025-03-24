package ru._systems.CaloriesCounterApp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@DynamicInsert
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    @NonNull
    private String userName;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "age")
    @NonNull
    private Integer age;

    @Column(name = "weight")
    @NonNull
    private Float weight;

    @Column(name = "height")
    @NonNull
    private Integer height;

    @Column(name = "ambition")
    @Enumerated(EnumType.STRING)
    private Ambition ambition;

    @Column(name = "daily_norm_consume")
    @NonNull
    private Integer dailyNormConsume;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
//    private List<ConsumptionRecords> consumptionRecordsList;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && sex == user.sex && Objects.equals(age, user.age) && Objects.equals(weight, user.weight) && Objects.equals(height, user.height) && ambition == user.ambition && Objects.equals(dailyNormConsume, user.dailyNormConsume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, sex, age, weight, height, ambition, dailyNormConsume);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", ambition=" + ambition +
                ", dailyNormConsume=" + dailyNormConsume +
                '}';
    }
}