package lab5.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class XmlThread implements Runnable{
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File("src/lab5/temp.xml"));
            StringBuilder sb = new StringBuilder();
            String s = scanner.nextLine();
            while (s != null) {
                sb.append(s);
                if (scanner.hasNext()) {
                    s = scanner.nextLine();
                }
                else {
                    s = null;
                }
            }
            String s1 = sb.toString();
            String[] smas1 = s1.split("\s*<.+?>");
            List<String> list = new ArrayList<String>(Arrays.asList(smas1));
            list.removeIf(n -> (n == ""));
            String[] smas2 = list.toArray(new String[list.size()]);
            int n = smas2.length / 4;
            for (int i = 0; i < n; i++) {
                System.out.format("%9s|%8d| %30s| %10s| %8d| %8d|\n",
                        "xml",
                        i,
                        smas2[4 * i],
                        smas2[4 * i + 1],
                        Integer.parseInt(smas2[4 * i + 2]),
                        Integer.parseInt(smas2[4 * i + 3]));
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
