package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

/***
 * Класс, реализующий команду count_less_than_start_date {startDate}
 */

public class CountLessStartDate {
    int i;
    Scanner scr = new Scanner(System.in);
    JsonReader jr;
    LocalDate ld;
    LocalTime lt;


    public CountLessStartDate(JsonReader jr) {
        this.jr = jr;
    }
    public void countDate(){
        try {
            System.out.println("Введите год:");
            int year = Integer.parseInt(scr.nextLine());
            System.out.println("Введите номер месяца");
            int month = Integer.parseInt(scr.nextLine());
            System.out.println("Введите день:");
            int day = Integer.parseInt(scr.nextLine());
            ld = LocalDate.of(year, month, day);
        }catch (DateTimeException e){
            System.out.println("Неправильный формат ввода даты, повторите ввод");
            countDate();
        }catch (NumberFormatException e){
            System.out.println("Вы ввели не число, повторите ввод даты");
            countDate();
        }
    }

    public void countTime(){
        try {
            System.out.println("Введите время:" + "\nЧасы:");
            int hour = Integer.parseInt(scr.nextLine());
            System.out.println("Минуты:");
            int minute = Integer.parseInt(scr.nextLine());
            lt = LocalTime.of(hour, minute);
        }catch (DateTimeException e){
            System.out.println("Неправильный формат ввода времени, повторите ввод");
            countTime();
        }catch (NumberFormatException e){
            System.out.println("Вы ввели не число, повторите ввод времени");
            countTime();
        }
    }


    public void countDateTime() {
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        for (Worker worker : jr.workers) {
            if (worker.getStartDate().getYear() < ldt.getYear())
                i++;
            if (worker.getStartDate().getYear() == ldt.getYear()) {
                if (worker.getStartDate().getDayOfYear() < ldt.getDayOfYear())
                    i++;
                if (worker.getStartDate().getDayOfYear() == ldt.getDayOfYear()) {
                    if (worker.getStartDate().getHour() < ldt.getHour())
                        i++;
                    if (worker.getStartDate().getHour() == ldt.getHour()) {
                        if (worker.getStartDate().getMinute() < ldt.getMinute())
                            i++;
                    }
                }
            }
        }
            System.out.println(ldt);
            System.out.println("количество элементов: " + i);
        }
    }

