package Commands;

import Collection.Worker;
import CollectionMannage.JsonReader;

public class MaxStatus {
    public void maxStatus(JsonReader jr){
        int max = 0;
        Worker maxWorker = new Worker();
        for(Worker worker : jr.workers){
            if (worker.getStatus().toString().length() > max) {
                max = worker.getStatus().toString().length();
                maxWorker = worker;
            }
        }
        System.out.println(maxWorker.toString());
    }
}
