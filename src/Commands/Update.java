package Commands;

import Collection.*;
import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Iterator;

/***
 * Класс, реализующий команду update_by_id id
 */


public class Update {

    public void update(JsonReader jr, int id) throws ParseException, FieldException, IOException, FileIsEmptyException {
        Remove remove = new Remove();
        int check = 0;
        if(jr.idAll.contains(id)) {
            remove.remove(jr, id);
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
            check++;
        }
        if(check == 0)
            System.out.println("[Нет worker'a с таким id]");
            }
        }
