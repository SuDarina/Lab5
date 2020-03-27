package Commands;

import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;
import java.io.IOException;

/***
 * Класс, реализующий команду clear
 */

public class Clear {
    public void clear(JsonReader jr) throws ParseException, FieldException, IOException, FileIsEmptyException {
        while(!(jr.workers.isEmpty())) {
            jr.workers.remove();
        }
        System.out.println("[коллекция удалена]");
    }
}
