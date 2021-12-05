package lab5.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class TxtThread implements Runnable{
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File("src/lab5/temp.txt"));
            int n=0;
            while(scanner.hasNext()) {
                scanner.nextLine();
                n++;
            }
            scanner.close();
            scanner = new Scanner(new File("src/lab5/temp.txt"));
            for(int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split("; ");
                System.out.format("%9s|%8d| %30s| %10s| %8d| %8d|\n",
                        "txt",
                        i,
                        line[0],
                        line[1],
                        Integer.parseInt(line[2]),
                        Integer.parseInt(line[3]));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
