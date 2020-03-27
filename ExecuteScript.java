package Commands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScript {
    int i;
    String comand;
    public List<String> comands = new ArrayList<>();

    public void executeScript(String scriptFile) throws IOException {
        FileInputStream fis = new FileInputStream(scriptFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuilder sb = new StringBuilder();
        System.out.println("Содержимое скрипта:");
        while ((i = bis.read()) != -1) {
            if (i != 10) {
            sb.append((char) i);
            } else{
                String s = String.valueOf(sb);
                comand = s;
                comands.add(s);
                System.out.println(comand);
                sb.setLength(0);
            }
        }
        String s = String.valueOf(sb);
        comand = s;
        if (!(comand.equals(""))) {
            comands.add(s);
            System.out.println(comand);
            System.out.println("\nВыполнение:");
        }else
            System.out.println("[файл пустой]");
        fis.close();

    }

}
// execute_script /Users/dariasupriadkina/IdeaProjects/LabaProga_5/src/Script