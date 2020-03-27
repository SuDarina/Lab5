package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.PriorityQueue;

public class Show {
    JsonReader js = new JsonReader();
    public void show(JsonReader js) throws ParseException, FieldException, IOException, FileIsEmptyException {
//        JsonReader js = new JsonReader();
        try {
            //js.read();
            for (Worker worker : js.workers) {
                System.out.println(worker.toString());
            }
            if (js.workers.isEmpty()) throw new FileIsEmptyException();
        }catch (FileIsEmptyException e){
            System.out.println("[коллекция пустая]");
        }
    }
}
