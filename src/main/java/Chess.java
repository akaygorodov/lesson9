import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {

        Table table = new Table();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Set start column position (A-H) ");
        char charPos = scanner.next().charAt(0);
        System.out.println("Set start row position (1-8) ");
        byte bytePos = scanner.nextByte();

        table.setHorse(charPos, bytePos);
        table.printTable();

        System.out.println("Set column position to move (A-H) ");
        char newCharPos = scanner.next().charAt(0);
        System.out.println("Set row position to move (1-8) ");
        byte newBytePos = scanner.nextByte();
        scanner.close();

        if (table.moveHorse(newCharPos, newBytePos)) {
            System.out.println("Horse moved");
            table.printTable();
        } else {
            System.out.println("You can not move there!");
        }
    }
}
