package lab;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static ExecutorService exec = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1707)) {
            System.out.println("Server is running");
            while (!server.isClosed()) {
                Socket client = server.accept();
                exec.execute(new ServerRunnable(client));
            }
            exec.shutdown();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
