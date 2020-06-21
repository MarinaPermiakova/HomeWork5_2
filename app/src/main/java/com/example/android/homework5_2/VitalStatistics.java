package com.example.android.homework5_2;

class VitalStatistics implements Comparable{
    float weight;
    int paces;


    public VitalStatistics(float weight, int paces) {
        this.weight = weight;
        this.paces = paces;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
