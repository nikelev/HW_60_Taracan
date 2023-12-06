import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaracanAppl {
    static String winner = null;

    public static void main(String[] args) throws InterruptedException {
        int min = 2;
        int max = 5;


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter quantity of taracans: ");
        int quantTar=scanner.nextInt();

        System.out.print("Enter quantity of runCycles: ");
        int runCycles = scanner.nextInt();

        scanner.close();



        System.out.println("Tarakans Race START!");

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < quantTar; i++) {
            Random random = new Random();
            int sleepTime = min + random.nextInt((max + 1) - min);
            threads.add(new Thread(new Taracan("Runner #"+i,runCycles,sleepTime)));
        }

        for (Thread thread : threads) {
            thread.start();


        }
        for (Thread thread : threads) {

            thread.join();

        }

        System.out.println("Tarakans Race FINISH!");
        System.out.println("Congratulations to tarakan #" + winner + "!  It's a winner!");
    }

    public static void setWinner(String tarakanNumber) {
        winner = winner == null ? tarakanNumber : winner;
    }

}
