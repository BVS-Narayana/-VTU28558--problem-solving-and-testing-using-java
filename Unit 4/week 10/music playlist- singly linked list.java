import java.util.Scanner;

public class MusicPlaylist {
    static class Node {
        String song;
        Node next;

        Node(String song) {
            this.song = song;
            this.next = null;
        }
    }

    static Node head = null;

    static void addSong(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Song added successfully.");
    }

    static void removeSong(String song) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.equalsIgnoreCase(song)) {
            head = head.next;
            System.out.println("Song removed successfully.");
            return;
        }

        Node current = head;

        while (current.next != null
                && !current.next.song.equalsIgnoreCase(song)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Song not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Song removed successfully.");
        }
    }

    static void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node current = head;
        System.out.println("\nMusic Playlist:");

        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    addSong(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter song to remove: ");
                    removeSong(sc.nextLine());
                    break;

                case 3:
                    displayPlaylist();
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
