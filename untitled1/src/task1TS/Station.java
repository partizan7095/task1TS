package task1TS;

import java.io.Serializable;
import java.util.List;

public class Station implements Serializable {
    String address;
    int id;
    List<Voter> voterList;

    public List<Voter> getVoterList() {
        return voterList;
    }

    public Station(int id, String address, List<Voter> codeIdVoter) {
        this.id = id;
        this.address = address;
        this.voterList = codeIdVoter;
    }

    public void setVoterList(Voter voter) {
        this.voterList.add(voter);
    }
    public void get(){
        System.out.println(id + " ," + address + " ," + "voterList:");
        voterList.forEach(System.out::println);
    }
    public void getAddressId(){
        System.out.println(id + " ," + address);
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", voterList=" + voterList + "\n"+
                '}';
    }
}
