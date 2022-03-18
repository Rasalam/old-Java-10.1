package Radio;

// Количество радиостанций 10 по умолчанию, цииклические переходы 0->9->0, возможность установки станции по ее номеру
// Пользователь может выбрать количество станцией, отличное от количества по умолчанию
// Уровни звука 0 - 99, последовательные переходы 0->99, 99->0.

public class Radio {
    private int volume;
    private int channel;
    private int numberOfChannel = 10;

    public Radio(int numberOfChannel) {                 // numberOfChannel Constructor
        this.numberOfChannel = numberOfChannel;
    }

    public Radio() {                                   // NoArg Constructor

    }

    public int getVolume() {                    //Получить текущий уровень громкости
        return volume;
    }

    public int getChannel() {                   //Получить текущий номер канала

        return channel;
    }

    public void volumeUp() {                    //Повысить громкость на единицу
        if (volume < 99) {
            volume++;
        }
    }

    public void volumeDown() {                  //Понизить громкость на единицу
        if (volume > 0) {
            volume--;
        }
    }

    public void channelNext() {                 //Переключить на следующий канал
        if (channel >= numberOfChannel - 1) {
            channel = 0;
        } else channel++;
    }

    public void channelPrev() {                 //Переключить на предыдущий канал
        if (channel <= 0) {
            channel = numberOfChannel - 1;
        } else channel--;
    }

    public void volumeSelect(int volumeSet) {    //Установить уровень громкости напрямую
        if (volumeSet > 99) {
            return;
        }
        if (volumeSet < 0) {
            return;
        }
        volume = volumeSet;
    }

    public void channelSelect(int channelSet) {  //Установить канал напрямую
        if (channelSet > numberOfChannel - 1) {
            return;
        }
        if (channelSet < 0) {
            return;
        }
        channel = channelSet;
    }

}





