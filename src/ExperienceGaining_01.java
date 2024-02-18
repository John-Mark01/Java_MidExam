import java.util.Scanner;

public class ExperienceGaining_01 {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        double expNeeded = Double.parseDouble(scanner.nextLine());
        int battlesCount = Integer.parseInt(scanner.nextLine());
        double sumOfXp = 0;

        for (int battle = 1; battle <= battlesCount; battle++) {

            double xpEarned = Double.parseDouble(scanner.nextLine());

            if (battle % 3 == 0) {
                xpEarned = xpEarned * 1.15;
            } else if (battle % 5 == 0) {
                xpEarned *= 0.90;
            } else if (battle % 15 == 0) {
                xpEarned *= 1.05;
            }

            sumOfXp += xpEarned;

            if (sumOfXp >= expNeeded) {
                battlesCount = battle;
                break;
            }
        }

        if (sumOfXp >= expNeeded) {
            System.out.println("Player successfully collected his needed experience for " + battlesCount + " battles.");
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.\n", Math.abs(expNeeded - sumOfXp));
        }

    }
}
