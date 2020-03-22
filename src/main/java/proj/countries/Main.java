package proj.countries;

import configs.MyConfig;
import example.WeekDay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proj.countries.entities.Cat;
import proj.countries.entities.Dog;
import proj.countries.entities.Parrot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        System.out.println(a + b);

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Cat cat = context.getBean(Cat.class);
        //Dog dog = (Dog) context.getBean("dog");
        Parrot parrot = context.getBean("parrot-Kesha", Parrot.class);

        System.out.println(cat.getName());
        //System.out.println(dog.getName());
        System.out.println(parrot.getName());

        WeekDay weekDay = context.getBean(WeekDay.class);
        System.out.println("It's " + weekDay.getWeekDayName() + " today!");

    }

}
