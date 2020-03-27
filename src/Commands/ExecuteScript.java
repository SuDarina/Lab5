package Commands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/***
 * Класс, реализующий команду execute_script {scriptFile}
 */

public class ExecuteScript {
    int i;
    String comand = "empty";
    public List<String> comands = new ArrayList<>();

    public void executeScript(String scriptFile) throws IOException {
        FileInputStream fis = new FileInputStream(scriptFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuilder sb = new StringBuilder();
        System.out.println("Содержимое скрипта:");
        while ((i = bis.read()) != -1) {
            if (i != 10) {
                sb.append((char) i);
            } else {
                String s = String.valueOf(sb);
                if (!(s.equals(""))) {
                    comand = s;
                    comands.add(s);
                    System.out.println(comand);
                    sb.setLength(0);
                }
            }
        }
        String s = String.valueOf(sb);
        if (!(s.equals(""))) {
            comand = s;
            comands.add(s);
            System.out.println(comand);
        }if(comand.equals("empty"))
            System.out.println("[файл пустой]");
        System.out.println("\nВыполнение:");
        fis.close();


    }
}
// execute_script /Users/dariasupriadkina/IdeaProjects/LabaProga_5/src/Script