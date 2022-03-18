package Radio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {


    @ParameterizedTest                                          // Громкость +1
    @CsvSource(value = {"-1, 1", "0, 1", "1, 2", "98, 99 ", "99, 99", "100, 1"})
    public void test_VolumeUp(int volumeSet, int expected) {
        Radio radio = new Radio();
        radio.volumeSelect(volumeSet);
        radio.volumeUp();
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                          // Громкость -1
    @CsvSource(value = {"-1, 0", "0, 0", "1, 0", "98, 97 ", "99, 98", "100, 0"})
    public void test_VolumeDown(int volumeSet, int expected) {
        Radio radio = new Radio();
        radio.volumeSelect(volumeSet);
        radio.volumeDown();
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                          // Выбор громкости
    @CsvSource(value = {"-1, 0", "0, 0", "1, 1", "98, 98", "99,99", "100,0"})
    public void test_VolumeSelect(int volumeSet, int expected) {
        Radio radio = new Radio();
        radio.volumeSelect(volumeSet);
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                    // Канал +1, количество каналов по умолчанию
    @CsvSource(value = {"0, 1", "1, 2", "8, 9", "9, 0"})
    public void test_ChannelNext_NumberOfChannelDefault(int channelSet, int expected) {
        Radio radio = new Radio();
        radio.channelSelect(channelSet);
        radio.channelNext();
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                    // Канал -1, количество каналов по умолчанию
    @CsvSource(value = {"1, 0", "2, 1", "9, 8", "0, 9"})
    public void test_ChannelPrev_NumberOfChannelDefault(int channelSet, int expected) {
        Radio radio = new Radio();
        radio.channelSelect(channelSet);
        radio.channelPrev();
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                    // Выбор канала, количество каналов по умолчанию
    @CsvSource(value = {"-1, 0", "0, 0", "1, 1", "2, 2", "9, 9", "10, 0"})
    public void test_ChannelSelect_NumberOfChannelDefault(int channelSet, int expected) {
        Radio radio = new Radio();
        radio.channelSelect(channelSet);
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                    // Канал +1, количество каналов выбрано пользователем
    @CsvSource(value = {"50, 0, 1", "50, 1, 2", "50, 48, 49", "50, 49, 0"})
    public void test_ChannelNext_NumberOfChannelSelected(int numberOfChannel, int channelSet, int expected) {
        Radio radio = new Radio(numberOfChannel);
        radio.channelSelect(channelSet);
        radio.channelNext();
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                    // Канал -1, количество каналов выбрано пользователем
    @CsvSource(value = {"50, 0, 49", "50, 1, 0", "50, 48, 47", "50, 49, 48"})
    public void test_ChannelPrev_NumberOfChannelSelected(int numberOfChannel, int channelSet, int expected) {
        Radio radio = new Radio(numberOfChannel);
        radio.channelSelect(channelSet);
        radio.channelPrev();
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

    @ParameterizedTest                                    // Выбор канала, количество каналов по умолчанию
    @CsvSource(value = {"50, 0, 0", "50, 1, 1", "50, 2, 2", "50, 48, 48", "50, 49, 49", "50, 50, 0"})
    public void test_ChannelSelect_NumberOfChannelSelected(int numberOfChannel, int channelSet, int expected) {
        Radio radio = new Radio(numberOfChannel);
        radio.channelSelect(channelSet);
        int actual = radio.getChannel();
        assertEquals(actual, expected);
    }

}
