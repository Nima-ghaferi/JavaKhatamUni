import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PanCardGenerator {

    private static Set<String> generatedPanCards = new HashSet<>();
    private static Random random = new Random();

    public static String generateRandomPanCard() {
        while (true) {
            String panCard = generatePanNumber();
            if (!generatedPanCards.contains(panCard)) {
                generatedPanCards.add(panCard);
                return panCard;
            }
        }
    }

    private static String generatePanNumber() {
        StringBuilder panBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            panBuilder.append(randomChar);
        }

        for (int i = 0; i < 4; i++) {
            panBuilder.append(random.nextInt(10));
        }

        char randomChar = (char) ('A' + random.nextInt(26));
        panBuilder.append(randomChar);س

        return panBuilder.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String panCard = generateRandomPanCard();
            System.out.println(panCard);
        }
    }
}