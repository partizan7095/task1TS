package task1TS;

import java.io.Serializable;
import java.util.*;

public class PartiesList implements Serializable {
    private final List<Parties> parties = new ArrayList<>();

    public void addParties(String nameParties, int day, int month, int year, String fraction, List<Candidat> candidatList){
        parties.add(new Parties(nameParties, day, month, year, fraction, candidatList));
    }
    public void addCan(Voter voter, String partie, int rating){
        for (Parties party : parties) {
            if (Objects.equals(party.getNameParties(), partie)){
                party.addCandidat(voter, partie, rating);
            }
        }
    }

    @Override
    public String toString() {
        return "PartiesList{" +
                "parties=" + parties +
                '}';
    }

    public List<Parties> getParties(){
        return parties;
    }
    public void soutParties(){
        parties.forEach(System.out::println);
    }
    public void sortedPart(){
        for (Parties party : parties) {
            party.sorted();
        }
    }

}
