package Commands;


import java.util.Scanner;

public class Help {
    public Help() {
    }
    public void help(){
        System.out.println("Справка:");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "insert null {element} : добавить новый элемент с заданным ключом\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_key null : удалить элемент из коллекции по его ключу\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "history : вывести последние 7 команд (без их аргументов)\n" +
                "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого\n" +
                "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                "sum_of_salary : вывести сумму значений поля salary для всех элементов коллекции\n" +
                "print_field_ascending_person : вывести значения поля person всех элементов в порядке возрастания\n" +
                "print_field_descending_position : вывести значения поля position всех элементов в порядке убывания");
    }
}

