package task1TS;

import java.io.Serializable;
import java.util.*;

public class Parties implements Serializable {
    private final String nameParties;
    private final Calendar dateCreate = new GregorianCalendar();
    private final List<Candidat> candidatList;
    private final String fraction;

    public void addCandidat(Voter voter, String parties, int rating){
        candidatList.add(new Candidat(voter, parties, rating));
    }

    public String getNameParties() {
        return nameParties;
    }

    public Parties(String nameParties, int day, int month, int year, String fraction, List<Candidat> candidatList) {
        this.nameParties = nameParties;
        this.dateCreate.set(Calendar.YEAR, year);
        this.dateCreate.set(Calendar.MONTH, month);
        this.dateCreate.set(Calendar.DAY_OF_MONTH, day);
        this.candidatList = candidatList;
        this.fraction = fraction;
    }

    @Override
    public String toString() {
        return "Parties{" +
                "nameParties='" + nameParties + '\'' +
                ", dateCreate=" + dateCreate.get(Calendar.YEAR) + "." + dateCreate.get(Calendar.MONTH) +"." + dateCreate.get(Calendar.DAY_OF_MONTH) +
                ", candidatList=" + candidatList +
                ", fraction='" + fraction + '\'' +
                '}';
    }

    public void sorted(){
        candidatList.sort(new Comparator<Candidat>() {
            @Override
            public int compare(Candidat o1, Candidat o2) {
                return Integer.compare(o2.getRating(), o1.getRating());
            }
        });
}
}
