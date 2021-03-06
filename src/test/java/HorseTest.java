import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HorseTest {

    @InjectMocks
    private Horse horse;

    @Mock
    private PositionConverter converterMock;

    @Before
    public void setup() {
        //converterMock = Mockito.mock(PositionConverter.class);
        //horse = new Horse(converterMock, 'A', (byte) 1);

        horse.setPosition('A', (byte) 1);
        when(converterMock.convertPositionIndex((byte) 1)).thenReturn((byte) 7);
        when(converterMock.convertPositionLetter('A')).thenReturn((byte) 65);
    }

    @Test
    public void isPossibleToMove_nominal_possible() {
        when(converterMock.convertPositionIndex((byte) 2)).thenReturn((byte) 6);
        when(converterMock.convertPositionLetter('C')).thenReturn((byte) 67);

        boolean actual = horse.isPossibleToMove('C', (byte) 2);

        verifyMock();
        Assert.assertTrue(actual);
    }

    @Test
    public void isPossibleToMove_nominal_impossible() {
        when(converterMock.convertPositionIndex((byte) 8)).thenReturn((byte) 0);
        when(converterMock.convertPositionLetter('D')).thenReturn((byte) 68);

        boolean actual = horse.isPossibleToMove('D', (byte) 8);

        verifyMock();
        Assert.assertFalse(actual);
    }

    private void verifyMock() {
        verify(converterMock, times(2)).convertPositionLetter(anyChar());
        verify(converterMock, times(2)).convertPositionIndex(anyByte());
        verifyNoMoreInteractions(converterMock);
    }

}
