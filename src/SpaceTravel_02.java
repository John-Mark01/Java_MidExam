import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpaceTravel_02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\|\\|")).collect(Collectors.toList());

        int startingFuel = Integer.parseInt(scanner.nextLine());
        int startingAmmunition = Integer.parseInt(scanner.nextLine());


        for (int index = 0; index < elements.size(); index++) {
            String command = elements.get(index).split(" ")[0];

            switch (command) {
                case "Travel":
                    int lightYears = Integer.parseInt(elements.get(index).split(" ")[1]);
                    if (startingFuel - lightYears >= 0) {
                        startingFuel -= lightYears;
                        System.out.printf("The spaceship travelled %d light-years.\n", lightYears);
                    } else {
                        System.out.println("Mission failed.");
                        return;
                    }
                    break;

                case "Enemy":
                    int enemyArmor = Integer.parseInt(elements.get(index).split(" ")[1]);

                    if (startingAmmunition >= enemyArmor) {
                        startingAmmunition -= enemyArmor;
                        System.out.printf("An enemy with %d armour is defeated.\n", enemyArmor);
                    } else if (startingFuel >= (enemyArmor * 2)) {
                        startingFuel -= (enemyArmor * 2);
                        System.out.printf("An enemy with %d armour is outmaneuvered.\n", enemyArmor);
                    } else {
                        System.out.println("Mission failed.");
                        return;
                    }
                    break;

                case "Repair":
                    int numberAdded = Integer.parseInt(elements.get(index).split(" ")[1]);
                    startingFuel += numberAdded;
                    startingAmmunition += (numberAdded * 2);

                    System.out.printf("Ammunitions added: %d.\n", numberAdded * 2);
                    System.out.printf("Fuel added: %d.\n", numberAdded);
                    break;

                case "Titan":
                    System.out.println("You have reached Titan, all passengers are safe.");
                    break;
            }
        }

    }
}
