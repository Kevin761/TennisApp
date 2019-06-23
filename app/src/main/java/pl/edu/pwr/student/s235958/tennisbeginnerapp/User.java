package pl.edu.pwr.student.s235958.tennisbeginnerapp;

import java.io.Serializable;

public class User implements Serializable {

    private int trainingAmount, trainingPerWeek;

    public User(int trainingPerWeek) {
        this.trainingPerWeek = trainingPerWeek;
    }

    public int getTrainingAmount() { return trainingAmount; }

    public void setTrainingAmount(int trainingAmount) {
        this.trainingAmount = trainingAmount;
    }

    public int getTrainingPerWeek() {
        return trainingPerWeek;
    }

    public void setTrainingPerWeek(int trainingPerWeek) {
        this.trainingPerWeek = trainingPerWeek;
    }


}
