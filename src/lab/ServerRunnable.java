package lab;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServerRunnable implements Runnable {
    private Socket client;

    public ServerRunnable(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(client.getInputStream())) {

            ArrayList<Child> list;
            File file = (File) in.readObject();
            System.out.println("recieved "+file.getName());
            String filePath = file.getPath();
            String ext;
            ext = filePath.substring(filePath.lastIndexOf(".") + 1);
            if(ext.equals("txt")) {
                list = readTxt(filePath);
            }
            else {
                list = readXml(filePath);
            }
            out.writeObject(list);
            client.close();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Child> readTxt(String filePath) {
        ArrayList<Child> list = new ArrayList<Child>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            int n=0;
            System.out.println(scanner.hasNext());
            while(scanner.hasNext()) {
                scanner.nextLine();
                n++;
            }
            scanner.close();
            scanner = new Scanner(new File(filePath));
            for(int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split("; ");
                list.add(new Child(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Child> readXml(String filePath) {
        ArrayList<Child> children = new ArrayList<Child>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
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
                children.add(new Child(smas2[4 * i], smas2[4 * i + 1], Integer.parseInt(smas2[4 * i + 2]), Integer.parseInt(smas2[4 * i + 3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return children;
    }
}
