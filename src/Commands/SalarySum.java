package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;

/***
 * Класс, реализующий команду sum_of_salary
 */

public class SalarySum {
    long sum;
    public void salarySum(JsonReader jr){
        for (Worker worker : jr.workers){
            sum +=  worker.getSalary();
        }
        System.out.println("Сумма salary всех worker'ов: "+sum);
    }
}
