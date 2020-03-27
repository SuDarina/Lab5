package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;
import Exceptions.FileIsEmptyException;

/***
 * Класс, реализующий команду show
 */

public class Show {

    public void show(JsonReader js) {
        try {
            for (Worker worker : js.workers) {
                System.out.println(worker.toString());
            }
            if (js.workers.isEmpty()) throw new FileIsEmptyException();
        }catch (FileIsEmptyException e){
            System.out.println("[коллекция пустая]");
        }
    }
}
