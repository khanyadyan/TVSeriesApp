package tvseries;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Series seriesApp = new Series();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TV SERIES MANAGEMENT MENU ===");
            System.out.println("1. Capture New Series");
            System.out.println("2. Search Series");
            System.out.println("3. Update Series");
            System.out.println("4. Delete Series");
            System.out.println("5. View Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    seriesApp.CaptureSeries();
                    break;
                case "2":
                    System.out.print("Enter Series ID to search: ");
                    String id = scanner.nextLine();
                    SeriesModel res = seriesApp.SearchSeries(id);
                    if (res.SeriesId == null) System.out.println("No series found.");
                    else System.out.println("Found: ID:" + res.SeriesId + " Name:" + res.SeriesName + " Age:" + res.SeriesAge + " Episodes:" + res.SeriesNumberOfEpisodes);
                    break;
                case "3":
                    seriesApp.UpdateSeries();
                    break;
                case "4":
                    seriesApp.DeleteSeries();
                    break;
                case "5":
                    seriesApp.SeriesReport();
                    break;
                case "6":
                    System.out.println("Exiting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}