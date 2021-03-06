package CollectionMannage;

import Commands.*;

import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/***
 * Класс для запроса ввода у пользователя и вывода результата действия команд
 */

public class UserInterface {

    public String comand;
    public String comand1 = "";
    String firstScript = "";

    JsonReader reader = new JsonReader();



    boolean interactive = true;

    Help help = new Help();
    Show show = new Show();
    Remove remove = new Remove();
    Clear clear = new Clear();
    Save save = new Save();
    MaxStatus maxStatus = new MaxStatus();
    Update update = new Update();
    AddIfMin addIfMin = new AddIfMin();
    RemoveGreater removeG = new RemoveGreater();
    RemoveLower removeL = new RemoveLower();
    ExecuteScript executeScript = new ExecuteScript();
    Info info = new Info();

    Scanner scr = new Scanner(System.in);
    Scanner scaner;
    Scanner oldScaner;

    public UserInterface() throws FileNotFoundException {
    }


    public void execute() throws ParseException, FieldException, IOException, FileIsEmptyException {

                switch (comand) {
                    case ("help"):
                        help.help();
                        break;
                    case ("exit"):
                        interactive = false;
                        break;
                    case ("show"):
                        show.show(reader);
                        break;
                    case ("add"):
                        Add add = new Add(reader);
                        add.add_id();
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
                        break;
                    case ("remove_by_id"):
                        int id;
                        if (!(comand1.equals("execute_script")))
                            if(scr.hasNextInt()) {
                                id = scr.nextInt();
                                remove.remove(reader, id);
                            }else{
                                System.out.println("Вы ввели не число, введите команду заново");
                                scr.next();
                                break;
                            }
                        else {
                            if (scaner.hasNextInt() | oldScaner.hasNextInt()) {
                                if (scaner.hasNextInt()) {
                                    id = scaner.nextInt();
                                    remove.remove(reader, id);
                                }
                                if (oldScaner.hasNextInt()) {
                                    id = oldScaner.nextInt();
                                    remove.remove(reader, id);
                                }
                            }else{
                                System.out.println("Вы ввели не число, введите команду заново");
                                try{
                                    scaner.next();
                                }catch (NoSuchElementException e) {
                                    oldScaner.next();
                                }
                            }
                        }
                        break;


                    case ("clear"):
                        clear.clear(reader);
                        break;
                    case ("save"):
                        save.save(reader);
                        break;
                    case ("sum_of_salary"):
                        SalarySum sSum = new SalarySum();
                        sSum.salarySum(reader);
                        break;
                    case ("max_by_status"):
                        maxStatus.maxStatus(reader);
                    case ("update_by_id"):
                        int id2;
                        if (!(comand1.equals("execute_script")))
                            if(scr.hasNextInt()) {
                                id2 = scr.nextInt();
                                update.update(reader, id2);
                            }else{
                                System.out.println("Вы ввели не число, введите команду заново");
                                scr.next();
                                break;
                            }
                        else {
                            if (scaner.hasNextInt() | oldScaner.hasNextInt()) {
                                if (scaner.hasNextInt()) {
                                    id2 = scaner.nextInt();
                                    update.update(reader, id2);
                                }
                                if (oldScaner.hasNextInt()) {
                                    id2 = oldScaner.nextInt();
                                    update.update(reader, id2);
                                }
                            }else{
                                System.out.println("Вы ввели не число, введите команду заново");
                                try{
                                    scaner.next();
                                }catch (NoSuchElementException e) {
                                    oldScaner.next();
                                }
                            }
                        }
                        break;

                    case ("add_if_min"):
                        addIfMin.addIfMin(reader);
                        break;
                    case ("remove_greater"):
                        removeG.removeG(reader);
                        break;
                    case ("remove_lower"):
                        removeL.removeL(reader);
                        break;
                    case ("execute_script"):
                        String scriptFile;
                        if(!(comand1.equals("execute_script"))) {
                            scriptFile = scr.next();
                            firstScript = scriptFile;
                        }

                        else {
                            try {
                                scriptFile = scaner.next();
                            }catch(NoSuchElementException e){
                                scaner = oldScaner;
                                scriptFile = scaner.next();
                            }
                            try {
                            if (scriptFile.equals(firstScript)) throw new StackOverflowError();
                            } catch (StackOverflowError e) {
                                firstScript = "";
                                System.out.println("Невозможно вызвать команду execute_script при выполнении команды execute_script с одним файлом");
                                break;
                            }
                        }
                        File file = new File(scriptFile);
                        try {
                            scaner = new Scanner(file);
                            if (!(comand1.equals("execute_script"))) {
                                oldScaner = scaner;
                            }
                        }catch (FileNotFoundException e) {
                            if (file.exists()) {
                                Rights rights = new Rights();
                                rights.setRights(file);
                                scaner = new Scanner(file);
                                if (!(comand1.equals("execute_script"))) {
                                    oldScaner = scaner;
                                }
                            }else{
                                System.out.println("файла не существует ");
                                break;
                            }
                        }
                        executeScript.executeScript(scriptFile);
                        while(!(executeScript.comands.isEmpty())) {
                            comand1 = "execute_script";
                            try{
                                comand = scaner.next();
                            }catch (NoSuchElementException e){
                                comand = oldScaner.next();
                            }

                            executeScript.comands.remove(0);
                            execute();
                        }
                        comand1 = "";
                        break;
                    case ("info"):
                        info.info(reader);
                        break;
                    case ("count_less_than_start_date"):
                        CountLessStartDate countDate = new CountLessStartDate(reader);
                        countDate.countDate();
                        countDate.countTime();
                        countDate.countDateTime();
                        break;
                    default:
                        scr.nextLine();
                        System.out.println("такой команды нет, повторите ввод");
                        break;
                }
            }
        public void run() throws FileIsEmptyException, FieldException, ParseException, IOException {
            reader.read();
            System.out.println("[Коллекция загружена]");
            System.out.println("Введите команду help, чтобы получить справку");
            while(interactive) {
                comand = scr.next();
                execute();
            }
    }
}



