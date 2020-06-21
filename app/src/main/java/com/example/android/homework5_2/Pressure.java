package com.example.android.homework5_2;

import java.util.Date;

class Pressure implements Comparable {
    int highPressure;
    int lowPressure;
    int pulse;
    boolean tachycardia;

    public Pressure(int highPressure, int lowPressure, int pulse, boolean tachycardia) {
        this.highPressure = highPressure;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
