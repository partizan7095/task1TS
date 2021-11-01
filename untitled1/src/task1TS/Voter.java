package task1TS;

import java.io.Serializable;

public class Voter implements Serializable {
    private final String firstName;
    private final String passport;
    private final int year;
    private final long codeId;
    private final int pollStation;

    private final boolean military;

    private final boolean quarantine;
    public Voter(String firstName, String passport, int year, int pollStation, boolean military, boolean quarantine, long codeId) {
        this.firstName = firstName;
        this.passport = passport;
        this.year = year;
        this.pollStation = pollStation;
        this.military = military;
        this.quarantine = quarantine;
        this.codeId = codeId;
    }

    public int getPollStation() {
        return pollStation;
    }

    public int getYear() {return year;}

    public boolean isMilitary() {
        return military;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public long getCodeId() {
        return codeId;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "firstName='" + firstName + '\'' +
                ",codeId'" + codeId + '\'' +
                ", passport='" + passport + '\'' +
                ", year=" + year +
                ", pollStation='" + pollStation + '\'' +
                ", military=" + military +
                ", quarantine=" + quarantine +
                '}';
    }
}
