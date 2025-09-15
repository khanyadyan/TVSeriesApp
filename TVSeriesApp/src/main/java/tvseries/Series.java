package tvseries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series {
    public List<SeriesModel> seriesModel = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // default constructor
    public Series() { }

    // constructor for testing with predefined list
    public Series(List<SeriesModel> list) {
        if (list != null) this.seriesModel = list;
    }

    // PopulateModel - returns a SeriesModel instance
    public SeriesModel PopulateModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        SeriesModel m = new SeriesModel();
        m.SeriesId = seriesId;
        m.SeriesName = seriesName;
        m.SeriesAge = seriesAge;
        m.SeriesNumberOfEpisodes = seriesNumberOfEpisodes;
        return m;
    }

    // CaptureSeries (interactive)
    public void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String seriesId = scanner.nextLine();
        System.out.print("Enter Series Name: ");
        String seriesName = scanner.nextLine();

        String seriesAge;
        while (true) {
            System.out.print("Enter Series Age (2-18): ");
            seriesAge = scanner.nextLine();
            if (isValidAge(seriesAge)) break;
            System.out.println("Invalid age. Please enter a number between 2 and 18.");
        }

        System.out.print("Enter the number of episodes for " + seriesName + ": ");
        String seriesNumberOfEpisodes = scanner.nextLine();
        seriesModel.add(PopulateModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes));
        System.out.print("Series processed successfully!!!");
        System.out.println();
    }

    // SearchSeries returns SeriesModel (if not found, return empty model with null fields)
    public SeriesModel SearchSeries(String id) {
        for (SeriesModel m : seriesModel) {
            if (m.SeriesId != null && m.SeriesId.equals(id)) {
                return m;
            }
        }
        return new SeriesModel(); // not found (fields null)
    }

    // UpdateSeries (interactive)
    public void UpdateSeries() {
        System.out.print("Enter Series ID to update: ");
        String id = scanner.nextLine();
        SeriesModel found = null;
        int index = -1;
        for (int i = 0; i < seriesModel.size(); i++) {
            if (seriesModel.get(i).SeriesId != null && seriesModel.get(i).SeriesId.equals(id)) {
                found = seriesModel.get(i);
                index = i;
                break;
            }
        }
        if (found == null) {
            System.out.println("Series not found.");
            return;
        }
        System.out.print("Enter new Series Name (leave blank to keep): ");
        String newName = scanner.nextLine();
        String newAge = null;
        while (true) {
            System.out.print("Enter new Series Age (2-18) (leave blank to keep): ");
            String tmp = scanner.nextLine();
            if (tmp.isBlank()) { newAge = found.SeriesAge; break; }
            if (isValidAge(tmp)) { newAge = tmp; break; }
            System.out.println("Invalid age. Please enter a number between 2 and 18.");
        }
        System.out.print("Enter new number of episodes (leave blank to keep): ");
        String newEpisodes = scanner.nextLine();
        if (newName.isBlank()) newName = found.SeriesName;
        if (newEpisodes.isBlank()) newEpisodes = found.SeriesNumberOfEpisodes;

        // replace with new object (no setters)
        seriesModel.set(index, PopulateModel(id, newName, newAge, newEpisodes));
        System.out.println("Series updated successfully!");
    }

    // DeleteSeries (interactive)
    public void DeleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String id = scanner.nextLine();
        for (int i = 0; i < seriesModel.size(); i++) {
            SeriesModel m = seriesModel.get(i);
            if (m.SeriesId != null && m.SeriesId.equals(id)) {
                System.out.print("Confirm delete (Y/N): ");
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase("Y")) {
                    seriesModel.remove(i);
                    System.out.println("Series deleted!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("Series not found.");
    }

    // SeriesReport
    public void SeriesReport() {
        System.out.println("=== Series Report ===");
        if (seriesModel.isEmpty()) {
            System.out.println("No series to display.");
            return;
        }
        for (SeriesModel m : seriesModel) {
            System.out.println("ID: " + m.SeriesId + " | Name: " + m.SeriesName + " | Age: " + m.SeriesAge + " | Episodes: " + m.SeriesNumberOfEpisodes);
        }
    }

    // helper validation
    public boolean isValidAge(String age) {
        try {
            int a = Integer.parseInt(age);
            return a >= 2 && a <= 18;
        } catch (Exception e) {
            return false;
        }
    }

    // Test helper methods (non-interactive) matching your style
    public void CaptureSeriesForTest(String id, String name, String age, String episodes) {
        seriesModel.add(PopulateModel(id, name, age, episodes));
    }

    public boolean UpdateSeriesForTest(String id, String newName, String newAge, String newEpisodes) {
        for (int i = 0; i < seriesModel.size(); i++) {
            SeriesModel m = seriesModel.get(i);
            if (m.SeriesId != null && m.SeriesId.equals(id)) {
                seriesModel.set(i, PopulateModel(id, newName, newAge, newEpisodes));
                return true;
            }
        }
        return false;
    }

    public boolean DeleteSeriesForTest(String id) {
        for (int i = 0; i < seriesModel.size(); i++) {
            SeriesModel m = seriesModel.get(i);
            if (m.SeriesId != null && m.SeriesId.equals(id)) {
                seriesModel.remove(i);
                return true;
            }
        }
        return false;
    }
}