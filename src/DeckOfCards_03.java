import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> cardDeck = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int index = 1; index <= numberOfCommands; index++) {

            List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

            String command = input.get(0);

            switch (command) {

                case "Add":
                    String newCard = input.get(1);
                    if (cardDeck.contains(newCard)) {
                        System.out.println("Card is already in the deck");
                    } else {
                        cardDeck.add(newCard);
                        System.out.println("Card successfully added");
                    }
                    break;

                case "Remove":
                    String cardToRemove = input.get(1);
                    if (cardDeck.contains(cardToRemove)) {
                        cardDeck.remove(cardToRemove);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;

                case "Remove At":
                    int cardIndex = Integer.parseInt(input.get(1));

                    if (cardIndex >= 0) {
                        if (cardDeck.size() > cardIndex) {
                            cardDeck.remove(cardIndex);
                            System.out.println("Card successfully removed");
                        } else {
                            System.out.println("Index out of range");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;

                case "Insert":
                    int indexToInsert = Integer.parseInt(input.get(1));
                    String card = input.get(2);

                    if (indexToInsert >= 0) {
                        if (cardDeck.size() > indexToInsert && cardDeck.get(indexToInsert).equals(card)) {
                            System.out.println("Card is already added");
                        } else if (cardDeck.size() < indexToInsert) {
                            System.out.println("Index out of range");
                        } else {
                            cardDeck.add(indexToInsert, card);
                            System.out.println("Card successfully added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }

        String lastElement = cardDeck.get(cardDeck.size()-1);
        for (int card = 0; card <= cardDeck.size() -2; card++) {
            System.out.print(cardDeck.get(card) + ", ");
        }
        System.out.print(lastElement);
    }
}
