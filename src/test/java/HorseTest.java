import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HorseTest {

    @InjectMocks
    private Horse horse;

    @Mock
    private PositionConverter converterMock;

    @Before
    public void setup() {
        //horse = new Horse(converterMock, 'A', (byte) 1);
        //converterMock = Mockito.mock(PositionConverter.class);

        horse.setPosition('A', (byte) 1);
        when(converterMock.convertPositionIndex((byte) 1)).thenReturn((byte) 7);
        when(converterMock.convertPositionLetter('A')).thenReturn((byte) 65);
    }

    @Test
    public void isPossibleToMove_nominal_possible() {
        when(converterMock.convertPositionIndex((byte) 2)).thenReturn((byte) 6);
        when(converterMock.convertPositionLetter('C')).thenReturn((byte) 67);

        boolean actual = horse.isPossibleToMove('C', (byte) 2);

        Assert.assertTrue(actual);
    }

    @Test
    public void isPossibleToMove_nominal_impossible() {
        boolean actual = horse.isPossibleToMove('D', (byte) 8);

        lenient().when(converterMock.convertPositionIndex((byte) 8)).thenReturn((byte) 0);
        lenient().when(converterMock.convertPositionLetter('D')).thenReturn((byte) 68);

        Assert.assertFalse(actual);
    }

}
