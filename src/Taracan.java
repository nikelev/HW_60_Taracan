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

        for (int i = 0; i < runCycles; i++) {
            System.out.println("Tarakan #" + tarakanName + " is running round number " + (i + 1));

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

