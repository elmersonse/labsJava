package lab;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int i = 0;
        while (i < 10) {
            i++;
            if(i % 2 == 0) {
                executor.execute(new ClientRunnable("src/lab/temp.txt"));
            }
            else {
                executor.execute(new ClientRunnable("src/lab/temp.xml"));
            }
        }
        executor.shutdown();
    }
}
