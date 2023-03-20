package battery_monitor;

public class Sensor_Array {

    byte sensorArr[][];

    public Sensor_Array() {
        sensorArr = new byte[3][5];
        for (byte[] sensorArr1 : sensorArr) {
            for (int j = 0; j < sensorArr1.length; j++) {
                sensorArr1[j] = -1;
            }
        }
    }
}

