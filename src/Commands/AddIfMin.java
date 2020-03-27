package Commands;

import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/***
 * Класс, реализующий команду add_if_min
 */

public class AddIfMin  {
    public void addIfMin(JsonReader jr) throws ParseException, FieldException, IOException, FileIsEmptyException {

        Add add1 = new Add(jr);
        add1.add_id();
        add1.add_name();
        add1.add_x();
        add1.add_y();
        add1.add_coordinates();
        add1.add_salary();
        add1.add_position();
        add1.add_status();
        add1.add_height();
        add1.add_passportID();
        add1.add_person();
        add1.add_date();

        if (add1.worker.compareTo(jr.workers.peek()) < 0) {
            add1.add();
        } else {
            jr.idAll.remove(add1.worker.getId());
            System.out.println("[worker не добавлен]");
        }
    }




//        Iterator<Worker> i = jr.workers.iterator();
//        while (i.hasNext()) {
//            Worker worker = i.next();
//            if ()


//        for(Worker worker : jr.workers){
//            worker.compareTo()
//        }

        }


