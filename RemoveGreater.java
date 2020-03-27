package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Iterator;

public class RemoveGreater {
    public void removeG(JsonReader jr) throws ParseException, FieldException, IOException, FileIsEmptyException {
        Add add = new Add(jr);
        add.add_id();
        jr.idAll.remove(jr.idAll.indexOf(add.worker.getId()));
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

        Iterator<Worker> i = jr.workers.iterator();
        while (i.hasNext()) {
            Worker worker = i.next();
            if (add.worker.compareTo(worker) < 0) {
                i.remove();
                int idid = worker.getId();
                jr.idAll.remove(jr.idAll.indexOf(idid));
            }

        }

    }
}
