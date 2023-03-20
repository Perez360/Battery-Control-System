package battery_monitor;

import java.util.Scanner;

public class Battery_Monitor {

    static int DayPower = 1;
    static Scanner input;
    static final int MAX_BATTERY_CAPACITY = 60;
    static double[] batArr;

    public static void main(String[] args) {
        System.out.println("Please enter the initial battery level of the 1st Battery");
        double initCap1 = userInput().nextDouble();
        System.out.println("Please enter the initial battery level of the 2nd Battery");
        double initCap2 = userInput().nextDouble();
        System.out.println("Please enter the initial battery level of the 3rd Battery");
        double initCap3 = userInput().nextDouble();
        System.out.println("Please enter the number of day(s) to wait >1");
        int wait = userInput().nextInt();
        initCap1 -= (wait * DayPower);
        initCap2 -= (wait * DayPower);
        initCap3 -= (wait * DayPower);
        if (initCap1 < 0.0) {
            initCap1 = 0;
        }
        if (initCap2 < 0.0) {
            initCap2 = 0;
        }
        if (initCap3 < 0.0) {
            initCap3 = 0;
        }
        batArr = new double[3];
        batArr[0] = initCap1;
        batArr[1] = initCap2;
        batArr[2] = initCap3;
        int j = 1;
        for (int i = 0; i < batArr.length; i++) {
            System.out.println("Battery level of battery " + j + " after the wait period " + wait + "day(s) is: " + batArr[i] + " kW/h");
            j++;
        }

        double bat1P = (initCap1 / MAX_BATTERY_CAPACITY) * 100;
        double bat2P = (initCap2 / MAX_BATTERY_CAPACITY) * 100;
        double bat3P = (initCap3 / MAX_BATTERY_CAPACITY) * 100;
        if (bat1P < 0) {
            bat1P = 0;
        } else if (bat2P < 0) {
            bat2P = 0;
        } else if (bat3P < 0) {
            bat3P = 0;
        }
        System.out.println("\nBattery Percentage for 1st Battery: " + bat1P + " %");
        System.out.println("Battery Percentage for 2nd Battery: " + bat2P + " %");
        System.out.println("Battery Percentage for 3rd Battery: " + bat3P + " %");

        Sensor_Array arr = new Sensor_Array();
        Status Enum;
        Status[] startArr = Status.values();
        System.out.println("");

        System.out.println("\nPlease enter a unit number to update 1st set of status unit. Hint:  0,1 and 2");
        int up1 = userInput().nextByte();
        for (byte i = 0; i < arr.sensorArr[0].length; i++) {
            arr.sensorArr[0][i] = (byte) up1;
        }
        System.out.println("1st status set Updated");

        System.out.println("\nPlease enter a unit number to update 2nd set of status unit. Hint:  0,1 and 2");
        int up2 = userInput().nextByte();
        for (byte i = 0; i < arr.sensorArr[1].length; i++) {
            arr.sensorArr[1][i] = (byte) up2;
        }
        System.out.println("2nd status set Updated");

        System.out.println("\nPlease enter a unit number to update 3rd set of status unit. Hint:  0,1 and 2");
        int up3 = userInput().nextByte();
        for (byte i = 0; i < arr.sensorArr[2].length; i++) {
            arr.sensorArr[2][i] = (byte) up3;
        }
        System.out.println("3rd status set Updated");

        System.out.println("\n\n*****************************REPORT**********************************:");

        for (Status f : startArr) {
            if (f.ordinal() == arr.sensorArr[0][0]) {
                System.out.println("\n***************STATUS FOR 1ST SET OF STATUS UNIT*************");
                System.out.println("Sensor                    |    Status\n");
                System.out.println("Ligth Sensor:             |    " + f);
                System.out.println("Temperature Sensor:       |    " + f);
                System.out.println("Radio Sensor:             |    " + f);
                System.out.println("X-ray Sensor:             |    " + f);
                System.out.println("Gamma radiation Sensor:   |    " + f);
                break;
            } else if (arr.sensorArr[0][0] > 2 || arr.sensorArr[0][0] < 0) {
                System.out.println("\n***************STATUS FOR 1ST SET OF STATUS UNIT*************");
                System.out.println("Sensor                    |    Status\n");
                System.out.println("Ligth Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("Temperature Sensor:       |    " + startArr[startArr.length - 1]);
                System.out.println("Radio Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("X-ray Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("Gamma radiation Sensor:   |    " + startArr[startArr.length - 1]);
                break;
            }
        }
        for (Status s : startArr) {
            if (s.ordinal() == arr.sensorArr[1][0]) {
                System.out.println("\n***************STATUS FOR 2ND SET OF STATUS UNIT*************");
                System.out.println("Sensor                    |    Status\n");
                System.out.println("Ligth Sensor:             |    " + s);
                System.out.println("Temperature Sensor:       |    " + s);
                System.out.println("Radio Sensor:             |    " + s);
                System.out.println("X-ray Sensor:             |    " + s);
                System.out.println("Gamma radiation Sensor:   |    " + s);
                break;

            } else if (arr.sensorArr[1][0] > 2 || arr.sensorArr[1][0] < 0) {
                System.out.println("\n***************STATUS FOR 2ND SET OF STATUS UNIT*************");
                System.out.println("Sensor                    |    Status\n");
                System.out.println("Ligth Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("Temperature Sensor:       |    " + startArr[startArr.length - 1]);
                System.out.println("Radio Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("X-ray Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("Gamma radiation Sensor:   |    " + startArr[startArr.length - 1]);
                break;
            }
        }
        for (Status t : startArr) {
            if (t.ordinal() == arr.sensorArr[2][0]) {
                System.out.println("\n***************STATUS FOR 3RD SET OF STATUS UNIT*************");
                System.out.println("Sensor                    |    Status\n");
                System.out.println("Ligth Sensor:             |    " + t);
                System.out.println("Temperature Sensor:       |    " + t);
                System.out.println("Radio Sensor:             |    " + t);
                System.out.println("X-ray Sensor:             |    " + t);
                System.out.println("Gamma radiation Sensor:   |    " + t);
                break;

            } else if (arr.sensorArr[2][0] > 2 || arr.sensorArr[2][0] < 0) {
                System.out.println("Sensor                    |    Status\n");
                System.out.println("Ligth Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("Temperature Sensor:       |    " + startArr[startArr.length - 1]);
                System.out.println("Radio Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("X-ray Sensor:             |    " + startArr[startArr.length - 1]);
                System.out.println("Gamma radiation Sensor:   |    " + startArr[startArr.length - 1]);
                break;
            }
        }

    }

    private static Scanner userInput() {
        Scanner input;
        input = new Scanner(System.in);
        return input;
    }
}
