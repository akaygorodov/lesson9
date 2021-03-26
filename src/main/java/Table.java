import java.util.Arrays;

public class Table {

    private String columns = "  A  B  C  D  E  F  G  H";
    private byte[] rows = new byte[]{8, 7, 6, 5, 4, 3, 2, 1};
    private byte[][] table = new byte[8][8];
    private Horse horse;

    public void printTable() {
        System.out.println(columns);
        for (int i = 0; i < table.length; i++) {
            System.out.print(String.valueOf(rows[i]));
            System.out.println(Arrays.toString(table[i]));
        }
    }

    public void setHorse(char letterPosition, byte indexPosition) {
        if (!isOnTable(letterPosition, indexPosition)) {
            System.out.println("You missing table!!!");
            System.exit(0);
        }
        horse = new Horse(new PositionConverter(), letterPosition, indexPosition);
        table[horse.getIndexPosition()][horse.getLetterPosition()] = 1;
    }

    private boolean isOnTable(char letter, byte index) {
        return ((letter >= 65 && letter <= 72) || (letter >= 97 && letter <= 104))
                && (index >= 1 && index <= 8);
    }

    public boolean moveHorse(char newLetterPosition, byte newIndexPosition) {
        if (isOnTable(newLetterPosition, newIndexPosition)
                && horse.isPossibleToMove(newLetterPosition, newIndexPosition)) {
            table[horse.getIndexPosition()][horse.getLetterPosition()] = 0;
            horse.setPosition(newLetterPosition, newIndexPosition);
            table[horse.getIndexPosition()][horse.getLetterPosition()] = 1;
            return true;
        } else {
            return false;
        }
    }
}

