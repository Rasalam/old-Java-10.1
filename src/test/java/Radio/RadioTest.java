package Radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {


    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 2", "9, 10 ", "10, 10"})
    public void volumeUpTest(int volumeSet, int expected) {
        Radio radio = new Radio();
        radio.volumeSelect(volumeSet);
        radio.volumeUp();
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 0", "10, 9 ", "9, 8"})
    public void volumeDownTest(int volumeSet, int expected) {
        Radio radio = new Radio();
        radio.volumeSelect(volumeSet);
        radio.volumeDown();
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"9, 0", "1, 2", "8, 9", "9, 0"})
    public void channelNextTest(int channelSet, int expected) {
        Radio radio = new Radio();
        radio.channelSelect(channelSet);
        radio.channelNext();
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 9", "1, 0", "8, 7", "9, 8"})
    public void channelPrevTest(int channelSet, int expected) {
        Radio radio = new Radio();
        radio.channelSelect(channelSet);
        radio.channelPrev();
        int actual = radio.getChannel();
        assertEquals(actual, expected);

    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 0", "0, 0", "1, 1", "8, 8", "9,9", "10, 0"})
    public void channelSetupTest(int channelSet, int expected) {
        Radio radio = new Radio();
        radio.channelSelect(channelSet);
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 0", "0, 0", "1, 1", "9, 9", "10,10", "11, 0"})
    public void volumeSetupTest(int volumeSet, int expected) {
        Radio radio = new Radio();
        radio.volumeSelect(volumeSet);
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }
}
