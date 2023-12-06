import java.util.Random;
import java.util.Scanner;

public class Taracan implements Runnable {
    String tarakanName;
    int runCycles;
    int sleepTime;

    public Taracan(String tarakanNumber, int runCycles, int sleepTime) {
        this.tarakanName = tarakanNumber;
        this.runCycles = runCycles;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.println("Tarakan #" + tarakanName + " is running");
        int min = 2;
        int max = 5;
        Random random = new Random();
        int sleepTime = min + random.nextInt((max + 1) - min);

        for (int i = 0; i < runCycles; i++) {
            System.out.println("Tarakan #" + tarakanName + " is running round number " + (i + 1)+" SleepTime= "+sleepTime);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Tarakan #" + tarakanName + " finished");

        TaracanAppl.setWinner(tarakanName);
    }

}

