package Commands;

import Collection.*;
import CollectionMannage.JsonReader;
import Exceptions.FieldException;
import Exceptions.FileIsEmptyException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Add {
    JsonReader js;

    public Add(JsonReader js) {
        this.js = js;
    }


        Scanner scr = new Scanner(System.in);

        Worker worker = new Worker();
        Coordinates coordinates = new Coordinates();
        Person person = new Person();

        public void add_id() throws ParseException, FieldException, IOException, FileIsEmptyException {
            System.out.println("id нового Worker'a:");
                worker.setId(js.generateId());
                js.idAll.add(worker.getId());
        }

        public void add_name() throws ParseException, FieldException, IOException {
            System.out.println("Введите name: ");
            try {
                String name = scr.nextLine();
                worker.setName(name);
            }catch (FieldException e){
                System.out.println("name не может быть null");
                add_name();
            }
        }

        public void add_x() throws FieldException {
            System.out.println("Введите Coordinates: " + "\n" + "x (Integer): ");
            try {
                String x = scr.nextLine();
                coordinates.setX(Integer.parseInt(x));

//                if (scr.hasNextInt()) {
//                    int x = scr.nextInt();
//                   // if (x == Integer.parseInt(null)) throw new FieldException("не может быть null");
//                    coordinates.setX(x);
//                    } else {
//                        scr.nextLine();
//                        System.out.println("Неправильный ввод данных");
//                        add_x();
//                    }
            }catch (NumberFormatException e){
                System.out.println("Неправильный ввод данных, введите заново");
                add_x();
            } catch(InputMismatchException e) {
               // scr.nextLine();
                System.out.println("Неправильный ввод данных");
                add_x();

            } catch (FieldException e){
                System.out.println("x не может быть null и меньше -329");
                add_x();
            }
//            try {
//                if (scr.nextLine() == "") throw new FieldException("coordinates не может быть null");
//            } catch (FieldException e) {
//                System.out.println("coordinates не может быть null");
//                add_x();
//            }
        }

        public void add_y() {
            System.out.println("y (float): ");
            try {
                float y = Float.parseFloat(scr.nextLine());
                coordinates.setY(y);
            } catch (NumberFormatException e) {
               // scr.nextLine();
                System.out.println("Неправильный ввод данных");
                add_y();

            } catch (FieldException e) {
                System.out.println("y не может быть больше -805");
                add_y();

            }
        }
//            try{
//                System.out.println("y (float): ");
//                float y = (float) Double.parseDouble(scr.next());
//                coordinates.setY(y);
//
//            } catch(FieldException e){
//                System.out.println("Ошибка в введении y : введите значение заново");
//                add_y();
//
//            }
//        }

            public void add_coordinates () throws ParseException, FieldException, IOException {


//            try{
//                System.out.println("Введите Coordinates: " + "\n" + "x (Integer): ");
//                int x = scr.nextInt();
//                coordinates.setX(x);
//
//            } catch(FieldException e){
//                System.out.println("Ошибка в введении x : введите значение заново");
//                coordinates.setX(scr.nextInt());
//
//            }
//
//            try{
//                System.out.println("y (float): ");
//                float y = (float) Double.parseDouble(scr.next());
//                coordinates.setY(y);
//
//            } catch(FieldException e){
//                System.out.println("Ошибка в введении y : введите значение заново");
//                coordinates.setY((float) Double.parseDouble(scr.next()));
//
//            }
                try {
                    worker.setCoordinates(coordinates);
                } catch (FieldException e) {
                    System.out.println("coordinates не может быть null");
                    add_coordinates();
                }
            }




//            System.out.println("Введите Coordinates: " + "\n" + "x (Integer): ");
//            int x = scr.nextInt();
//            System.out.println("y (double): ");
//            float y = (float) Double.parseDouble(scr.next());
//            System.out.println(y);
//            try {

//                Coordinates coordinates = new Coordinates(x, (float) y);
//                worker.setCoordinates(coordinates);
//            }catch (FieldException e ){
//                e.printStackTrace();
//                System.out.println("Введите координаты заново");
//                add_coordinates();
//            }
//        }


       public void add_height(){
           System.out.println("Введите Person: " + "\n" + "height (double): ");
           try{
               double height = Double.parseDouble(scr.nextLine());
               person.setHeight(height);
           } catch (NumberFormatException e) {
               System.out.println("Неправильный ввод данных");
               add_height();

           } catch (FieldException e) {
               System.out.println("Значение поля должно быть больше 0");
               add_height();

           }
       }

       public void add_passportID(){
           System.out.println("passportID (String): ");
           try{
               String passportId = scr.nextLine();
               person.setPassportID(passportId);
           } catch (FieldException e){
               System.out.println("Длина строки должна быть не меньше 9 и не больше 41");
               add_passportID();
           }
       }

        public void add_person() throws ParseException, FieldException, IOException {
//            System.out.println("Введите Person: " + "\n" + "height (double): ");
//            double height = Double.parseDouble(scr.nextLine());
//            System.out.println("passportID (String): ");
//            String passportId = scr.next();
//            Person person = new Person(height, passportId);
            try {
                worker.setPerson(person);
            } catch(FieldException e){
                System.out.println("поле не может быть null");
                add_person();
            }
        }

        public void add_salary() throws ParseException, FieldException, IOException {
            System.out.println("Введите salary (long): ");
            try {
                String salary = scr.nextLine();
                worker.setSalary(Long.parseLong(salary));
            }catch (FieldException e){
                System.out.println("Значение поля должно быть больше 0");
                add_salary();
            }catch(InputMismatchException e){
                scr.nextLine();
                System.out.println("Неправильный ввод данных");
                add_salary();
            } catch (NumberFormatException e){
                System.out.println("Неправильный ввод данных, вы ввели не число");
                add_salary();
            }
        }

        public void add_position() throws ParseException, FieldException, IOException {

            System.out.println("Введите Positiomn: " + "\n" +
                    "Выберите из перечисленных: " + "\n" +
                    "DIRECTOR," + "\n" +
                    "MANAGER, " + "\n" +
                    "HUMAN_RESOURCES, " + "\n" +
                    "HEAD_OF_DEPARTMENT, " + "\n" +
                    "LEAD_DEVELOPER;");
          //  String position = scr.nextLine();
            try{
                    String position = scr.nextLine();
                    // Position pos = Position.valueOf(position);
                    if (!(position.equals(""))) {
                        Position pos = Position.valueOf(position);
                        worker.setPosition(pos);
                    }else{
                        worker.setPosition(null);
                    }

            } catch (IllegalArgumentException e) {
                //scr.next();
                System.out.println("Нет такого значения enum");
                add_position();

            }
        }

        public void add_status() throws ParseException, FieldException, IOException {

            try{
            System.out.println("Введите Status: " + "\n" +
                    "Выберите из перечисленных: " + "\n" +
                    "HIRED, " + "\n" +
                    "RECOMMENDED_FOR_PROMOTION, " + "\n" +
                    "REGULAR; ");
                    String status = scr.nextLine();
                    Status stat = Status.valueOf(status);
                    worker.setStatus(stat);
            } catch (FieldException e) {
                System.out.println("Поле не может быть null");
                add_status();
            }catch(IllegalArgumentException e){
                System.out.println("Нет такого значения enum");
                add_status();
            }
        }
        public void add_date(){
            worker.setStartDate(LocalDateTime.now());
            worker.setCreationDate();
            System.out.println("[даты установлены]");
        }

        public void add() throws ParseException, FieldException, IOException, FileIsEmptyException {
            js.workers.add(worker);
            System.out.println("[worker добавлен]");

    }
}
