package wynikizawodow;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompetitionsData {
    public static void main(String[] args) {
        List<Competitor> competitors = loadData();
        sortCompetitors(competitors);
        saveToFile(competitors);
    }

    private static void sortCompetitors(List<Competitor> competitors) {
        Collections.sort(competitors);
        System.out.println("Posortowani:");
        printCompetitors(competitors);
    }

    private static List<Competitor> loadData() {
        Scanner input = new Scanner(System.in);
        List<Competitor> competitors = new ArrayList<>();
        System.out.println("Podaj wynik kolejnego gracza (lub stop):");
        for (String userInput = input.nextLine(); !userInput.equals("stop"); userInput = input.nextLine()) {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            String[] userInputArray = userInput.split(" ");
            competitors.add(new Competitor(userInputArray[0], userInputArray[1], Integer.parseInt(userInputArray[2])));
        }

        printCompetitors(competitors);
        input.close();
        return competitors;
    }

    private static void printCompetitors(List<Competitor> competitors) {
        for (Competitor competitor : competitors) {
            System.out.println(competitor);
        }
    }

    private static void saveToFile(List<Competitor> competitors) {
        PrintWriter save = null;
        try {
            save = new PrintWriter("stats.csv");
            for (Competitor competitor : competitors) {
                save.println(competitor);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            save.close();
        }
    }
}
