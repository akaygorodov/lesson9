public class PositionConverter {

    public byte convertPositionLetter(char letterPosition) {
        if (letterPosition >= 65 && letterPosition <= 72) {
            return (byte) (letterPosition - 65);
        } else //if (asciiChar >= 97 && asciiChar <= 104) {
            return (byte) (letterPosition - 97);
    }

    public byte convertPositionIndex(byte indexPosition) {
        return (byte) Math.abs(indexPosition - 8);
    }
}
