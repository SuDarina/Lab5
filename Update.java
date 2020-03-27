package Commands;

import Collection.*;
import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Iterator;


public class Update {

    public void update(JsonReader jr, int id) throws ParseException, FieldException, IOException, FileIsEmptyException {
        Iterator<Worker> i = jr.workers.iterator();
        while (i.hasNext()) {
            Worker worker = i.next();
            if (worker.getId() == id) {
                i.remove();
                jr.idAll.remove(jr.idAll.indexOf(id));
            }
        }
        Add add = new Add(jr);
        add.worker.setId(id);
        add.add_name();
        add.add_x();
        add.add_y();
        add.add_coordinates();
        add.add_salary();
        add.add_position();
        add.add_status();
        add.add_height();
        add.add_passportID();
        add.add_person();
        add.add_date();
        add.add();
    }
}

















//        for (Worker worker : jr.workers) {
//
//            if (worker.getId() == id) {
//
//                System.out.println("Введите name: ");
//                worker.setName(scr.next());
//
//                Coordinates coordinates = new Coordinates();
//                try {
//                    System.out.println("Введите Coordinates: " + "\n" + "x (Integer): ");
//                    int x = scr.nextInt();
//                    coordinates.setX(x);
//
//                } catch (FieldException e) {
//                    System.out.println("Ошибка в введении x : введите значение заново");
//                    coordinates.setX(scr.nextInt());
//
//                }
//
//                try {
//                    System.out.println("y (double): ");
//                    float y = (float) Double.parseDouble(scr.next());
//                    coordinates.setY(y);
//
//                } catch (FieldException e) {
//                    System.out.println("Ошибка в введении y : введите значение заново");
//                    coordinates.setY((float) Double.parseDouble(scr.next()));
//
//                }
//                worker.setCoordinates(coordinates);
//
//
//
//
//                System.out.println("Введите Person: " + "\n" + "height (double): ");
//                double height = Double.parseDouble(scr.next());
//                System.out.println("passportID (String): ");
//                String passportId = scr.next();
//                Person person = new Person(height, passportId);
//                worker.setPerson(person);
//
//                System.out.println("Введите salary (long): ");
//                long salary = scr.nextLong();
//                worker.setSalary(salary);
//
//                System.out.println("Введите Positiomn: " + "\n" +
//                        "Выберите из перечисленных: " + "\n" +
//                        "DIRECTOR," + "\n" +
//                        "MANAGER, " + "\n" +
//                        "HUMAN_RESOURCES, " + "\n" +
//                        "HEAD_OF_DEPARTMENT, " + "\n" +
//                        "LEAD_DEVELOPER;");
//                String position = scr.next();
//                System.out.println(position);
//                Position pos = Position.valueOf(position);
//                worker.setPosition(pos);
//
//                System.out.println("Введите Status: " + "\n" +
//                        "Выберите из перечисленных: " + "\n" +
//                        "HIRED, " + "\n" +
//                        "RECOMMENDED_FOR_PROMOTION, " + "\n" +
//                        "REGULAR; ");
//
//                String status = scr.next();
//                Status stat = Status.valueOf(status);
//                worker.setStatus(stat);
//
//
//            }
//        }
//        System.out.println("[worker изменён]");
//
//    }
//}


