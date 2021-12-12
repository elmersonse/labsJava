package lab;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ClientRunnable implements Runnable{
    private Socket client;
    private String filePath;
    private static Semaphore SEM = new Semaphore(1);

    public ClientRunnable(String filePath) {
        this.filePath = filePath;
        try {
            client = new Socket("localhost", 1707);
            System.out.println("Client connected to socket");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(client.getInputStream())) {

            File file = new File(filePath);
            oos.writeObject(file);
            ArrayList<Child> children = (ArrayList<Child>) ois.readObject();
            SEM.acquire();
            System.out.format("|%8s| %30s| %10s| %8s| %8s|\n", "Код", "Имя", "Дата рожд.", "Отряд", "Комната");
            children.forEach(Child::print);
            System.out.println();
            SEM.release();
        }
        catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
