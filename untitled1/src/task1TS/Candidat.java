package task1TS;

import java.io.Serializable;

public class Candidat implements Serializable {
    private final String parties;

    private final int rating;

    private final Voter voter;
    @Override
    public String toString() {
        return "Candidat{" +
                "parties='" + parties + '\'' +
                ", rating=" + rating +
                ", voter=" + voter +
                '}';
    }

    public int getRating() {
        return rating;
    }

    public Candidat(Voter voter, String parties, int rating) {
        this.voter = voter;
        this.parties = parties;
        this.rating = rating;
    }

}
