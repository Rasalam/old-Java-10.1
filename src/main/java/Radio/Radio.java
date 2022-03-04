package Radio;

// Номера радиостанций 0 - 9, циклический переход вверх, вниз, возможность установки станции по ее нореру
// Уровни звука 0 - 10, последовательные переходы 0 - 10, 10- 0.

public class Radio {
    private int volume;
    private int channel;


    public int getVolume() {                    //Получить текущий уровень громкости
        return volume;
    }

    public int getChannel() {                   //Получить текущий номер канала
        return channel;
    }

    public void volumeUp() {                    //Повысить громкость на единицу
        if (volume < 10) {
            volume++;
        }
    }

    public void volumeDown() {                  //Понизить громкость на единицу
        if (volume > 0) {
            volume--;
        }
    }

    public void channelNext() {                 //Переключить на следующий канал
        if (channel >= 9) {
            channel = 0;
        } else channel++;
    }

    public void channelPrev() {                 //Переключить на предыдущий канал
        if (channel <= 0) {
            channel = 9;
        } else channel--;
    }

    public void channelSelect(int channelSet) {  //Установить канал напрямую
        if (channelSet > 9) {
            return;
        }
        if (channelSet < 0) {
            return;
        }
        channel = channelSet;
    }

    public void volumeSelect(int volumeSet) {    //Установить уровень громкости напрямую
        if (volumeSet > 10) {
            return;
        }
        if (volumeSet < 0) {
            return;
        }
        volume = volumeSet;
    }
}





