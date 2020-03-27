package CollectionMannage;


import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;
import java.io.*;

public class Test {
    public static void main(String[] args) throws ParseException, FieldException, IOException, FileIsEmptyException {
        UserInterface us = new UserInterface();
        us.run();
    }
}
