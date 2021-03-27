public class Horse {
    private PositionConverter converter;
    private char letterPosition;
    private byte indexPosition;

    private Horse(){
        //default constructor for @InjectMocks annotation
    }

    public Horse(PositionConverter converter, char letterPosition, byte indexPosition) {
        this.converter = converter;
        this.letterPosition = letterPosition;
        this.indexPosition = indexPosition;
    }

    public void setPosition(char positionLetter, byte positionIndex) {
        this.letterPosition = positionLetter;
        this.indexPosition = positionIndex;
    }

    public byte getLetterPosition() {
        return converter.convertPositionLetter(letterPosition);
    }

    public byte getIndexPosition() {
        return converter.convertPositionIndex(indexPosition);
    }

    public boolean isPossibleToMove(char newLetterPosition, byte newIndexPosition) {
        int iDif = Math.abs(converter.convertPositionLetter(newLetterPosition)
                                    - converter.convertPositionLetter(letterPosition));
        int jDif = Math.abs(converter.convertPositionIndex(newIndexPosition)
                                    - converter.convertPositionIndex(indexPosition));
        return (iDif == 1 && jDif == 2)
                || (iDif == 2 && jDif == 1);
    }
}
