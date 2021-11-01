package task1TS;

import java.io.Serializable;
import java.util.*;

public class Election implements Serializable {
    private final Calendar calendar = new GregorianCalendar();
    private final List<Voter> voterList = new ArrayList<>();
    public void setCalendar(int year, int month) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
    }
    public Voter getVoter(long codeId){
        Voter voter1 = null;
        for (Voter voter : voterList) {
            if (voter.getCodeId() == codeId)
            voter1 = voter;
        }
        return voter1;
    }

    public void add(String firstName, String passport, long codeID, int year, int pollStation, boolean military, boolean quarantine){
        if (2021 - year >= 18) {
        voterList.add(new Voter(firstName, passport, year, pollStation, military, quarantine, codeID));}
        else System.out.println("Даному громадянену не має 18 років " + new Voter(firstName, passport, year, pollStation, military, quarantine, codeID));
    }
    public void getAll(){
        voterList.forEach(System.out::println);
    }
    public List<Voter> getVoterList(){
        return voterList;
    }


    public void removeVoter(long codeId) {
        voterList.removeIf(voter -> voter.getCodeId() == codeId);

    }
}
