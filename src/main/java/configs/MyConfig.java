package configs;

import example.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proj.countries.entities.Cat;
import proj.countries.entities.Dog;
import proj.countries.entities.Parrot;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
public class MyConfig {

    @Bean
    public Cat getCat() {
        return new Cat();
    }

    @Bean
    public Dog getDog() {
        return new Dog();
    }

    @Bean("parrot-Kesha")
    public Parrot weNeedMoreParrots() {
        return new Parrot();
    }

    @Bean
    public Cat getCat(Parrot parrot) {
        Cat cat = new Cat();
        cat.setName(parrot.getName() + "-killer");
        return cat;
    }

    @Bean
    public WeekDay getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case FRIDAY: return new Friday();
            case MONDAY: return new Monday();
            case SUNDAY: return new Sunday();
            case TUESDAY: return new Tuesday();
            case SATURDAY: return new Saturday();
            case THURSDAY: return new Thursday();
            default: return new Wednesday();
        }
    }
}
