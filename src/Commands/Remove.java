package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;
import java.util.Iterator;

/***
 * Класс, реализующий команду remove_by_id id
 */

public class Remove {
    public void remove(JsonReader jr, int id) {
        if (!(jr.idAll.contains(id)))
            System.out.println("[нет worker'а с таким id]");
        Iterator<Worker> i = jr.workers.iterator();
        while (i.hasNext()) {
            Worker worker = i.next();
            if (worker.getId() == id) {
                i.remove();
                jr.idAll.remove(jr.idAll.indexOf(id));
                System.out.println("[worker удалён]");
                }
            }
    }
}