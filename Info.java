package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;

import java.time.LocalDateTime;

public class Info {
    LocalDateTime minDate;

    public void info(JsonReader jr) {
        LocalDateTime ldt = jr.workers.element().getStartDate();
        for (Worker worker : jr.workers) {
            if (worker.getStartDate().getYear() < ldt.getYear())
                minDate = worker.getStartDate();
            if (worker.getStartDate().getYear() == ldt.getYear()) {
                if (worker.getStartDate().getDayOfYear() < ldt.getDayOfYear())
                    minDate = worker.getStartDate();
                if (worker.getStartDate().getDayOfYear() == ldt.getDayOfYear()) {
                    if (worker.getStartDate().getHour() < ldt.getHour())
                        minDate = worker.getStartDate();
                    if (worker.getStartDate().getHour() == ldt.getHour()) {
                        if (worker.getStartDate().getMinute() <= ldt.getMinute()) {
                            minDate = worker.getStartDate();
                        }
                    }
                }
            }
        }
        System.out.println("Тип коллекции: " + jr.workers.getClass().toString() + "\nРазмер коллекции: " + jr.workers.size()
                + "\nДата инициализации: " + minDate);

    }
}
