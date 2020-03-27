package Commands;

import CollectionMannage.JsonReader;
import CollectionMannage.JsonWriter;
import Exceptions.FieldException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Save {
    public void save(JsonReader jr) throws ParseException, FieldException, IOException {
        JsonWriter jw = new JsonWriter(jr);
        jw.write();
    }
}
