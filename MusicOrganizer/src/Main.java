import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\nMusic Organizer Menu:");
            System.out.println("1 - List all tracks");
            System.out.println("2 - Add a new track");
            System.out.println("3 - Play a track");
            System.out.println("4 - Play the next track");
            System.out.println("5 - Stop playing");
            System.out.println("6 - See currently playing track");
            System.out.println("7 - Remove a track");
            System.out.println("8 - Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    organizer.listAllTracks();
                    break;
                case 2:
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter file name: ");
                    String filename = scanner.nextLine();
                    organizer.addTrack(new Track(artist, title, filename));
                    break;
                case 3:
                    System.out.print("Enter track index to play: ");
                    int trackIndex = scanner.nextInt();
                    organizer.startPlayingTrack(trackIndex);
                    break;
                case 4:
                    organizer.nextTrack();
                    break;
                case 5:
                    organizer.stopPlaying();
                    break;
                case 6:
                    organizer.showCurrentlyPlaying();
                    break;
                case 7:
                    System.out.print("Enter track index to remove: ");
                    int removeIndex = scanner.nextInt();
                    organizer.removeTrack(removeIndex);
                    break;
                case 8:
                    quit = true;
                    System.out.println("Exiting Music Organizer.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
