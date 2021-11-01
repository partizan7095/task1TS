package task1TS;

import java.io.Serializable;
import java.util.*;


public class StationList implements Serializable {
    Map<Integer, Station> stationStandMap = new HashMap<>();
    Map<Integer, Station> stationMiliMap = new HashMap<>();
    Map<Integer, Station> stationQuaMap = new HashMap<>();
    Map<String, Integer> electinMap = new HashMap<>();
    Deque<Voter> voterDeque = new ArrayDeque<>();
    Deque<Voter> voterDeque1 = new ArrayDeque<>();
    int count = 1;

    public void setVoterList(List<Voter> listVoter) {
        voterDeque.addAll(listVoter.stream().filter(voter -> 2021 - voter.getYear() >= 18).toList());
        voterDeque1.addAll(listVoter.stream().filter(voter -> 2021 - voter.getYear() < 18).toList());
        listVoter.stream().filter(voter -> 2021 - voter.getYear() < 18).forEach(System.out::println);
        voterDeque1.forEach(System.out::println);
    }

    public void setVoter(Voter voter) {
        voterDeque.add(voter);
    }

    public void getStation() {
        for (Station stationStand : stationStandMap.values()) {
            stationStand.get();
        }
        for (Station stationMili : stationMiliMap.values()) {
            stationMili.get();
        }
        for (Station stationQua : stationQuaMap.values()) {
            stationQua.get();
        }
    }

    public void addStationStand(String address) {
        stationStandMap.put(count, new Station(count, address, new ArrayList<>()));
        count++;
    }

    public void addStationMili(String address) {
        stationMiliMap.put(count, new Station(count, address, new ArrayList<>()));
        count++;
    }

    public void addStationQua(String address) {
        stationQuaMap.put(count, new Station(count, address, new ArrayList<>()));
        count++;
    }
    public void getQua(){
        for (Station value : stationQuaMap.values()) {
            value.getAddressId();
        }
    }
    public void getSta(){
        for (Station value : stationStandMap.values()) {
            value.getAddressId();
        }
    }
    public void getMili(){
        for (Station value : stationMiliMap.values()) {
            value.getAddressId();
        }
    }

    public void updateStation() {
            for (Voter voter : voterDeque) {
                if (2021 - voter.getYear() < 18){
                    System.out.println("Немає 18 років :" + voter);
                }
                for (Integer integer : stationQuaMap.keySet()) {
                    if (voter.getPollStation() == integer && voter.isQuarantine()) {
                        stationQuaMap.get(integer).setVoterList(voterDeque.poll());
                    }
                }
                for (Integer integer : stationMiliMap.keySet()) {
                    if (voter.getPollStation() == integer && voter.isMilitary() && !voter.isQuarantine()) {
                        stationMiliMap.get(integer).setVoterList(voterDeque.poll());
                    }
                }
                for (Integer integer : stationStandMap.keySet()) {
                    if (voter.getPollStation() == integer) {
                        if (!voter.isMilitary() && !voter.isQuarantine())
                        stationStandMap.get(integer).setVoterList(voterDeque.poll());
                    }
                }
            }

            }


        public void election(List<Parties> partiesList){
                for (Station value : stationStandMap.values()) {
                    for (Voter voter : value.getVoterList()) {
                        if (voter.getYear() % 2 == 0) {
                            Collections.shuffle(partiesList);
                            if(!electinMap.containsKey(partiesList.get(1).getNameParties())){
                                electinMap.put(partiesList.get(1).getNameParties(), 1);
                            }
                            if(electinMap.containsKey(partiesList.get(1).getNameParties())){
                                electinMap.replace(partiesList.get(1).getNameParties(), electinMap.get(partiesList.get(1).getNameParties()) + 1);
                        }
                    }

                }
            }
            for (Station value : stationQuaMap.values()) {
                for (Voter voter : value.getVoterList()) {
                    if (voter.getYear() % 2 == 0) {
                        Collections.shuffle(partiesList);
                        if(!electinMap.containsKey(partiesList.get(1).getNameParties())){
                            electinMap.put(partiesList.get(1).getNameParties(), 1);
                        }
                        if(electinMap.containsKey(partiesList.get(1).getNameParties())){
                            electinMap.replace(partiesList.get(1).getNameParties(), electinMap.get(partiesList.get(1).getNameParties()) + 1);
                        }
                    }

                }
            }
            for (Station value : stationMiliMap.values()) {
                for (Voter voter : value.getVoterList()) {
                    if (voter.getYear() % 2 == 0) {
                        Collections.shuffle(partiesList);
                        if(!electinMap.containsKey(partiesList.get(1).getNameParties())){
                            electinMap.put(partiesList.get(1).getNameParties(), 1);
                        }
                        if(electinMap.containsKey(partiesList.get(1).getNameParties())){
                            electinMap.replace(partiesList.get(1).getNameParties(), electinMap.get(partiesList.get(1).getNameParties()) + 1);
                        }
                    }

                }
            }

        }
        public void getElection(){
            System.out.println(electinMap);
            String maxKey = (electinMap.entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getValue))
                    .get().getKey());
            System.out.println("Вибори виграла партія: " + maxKey);
        }
}

