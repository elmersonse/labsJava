package lab5.threads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class RandomThread implements Runnable {
    @Override
    public void run() {
        int n = (int) Math.round(Math.random()*10 + 5);
        String characters = "qwertyuiopasdfghjklzxcvbnm";
        Random rng = new Random(LocalDateTime.now().getSecond());
        for(int i=0; i<n; i++) {
            System.out.format("%9s|%8d| %30s| %10s| %8d| %8d|\n",
                    "random",
                    i,
                    generateString(rng, characters, (int) Math.round(Math.random() * 6 + 3)),
                    LocalDate.now().minusDays(Math.round(Math.random() * 1000 + 3000)).toString(),
                    (int) Math.round(Math.random() * 4),
                    (int) Math.round(Math.random() * 2));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
