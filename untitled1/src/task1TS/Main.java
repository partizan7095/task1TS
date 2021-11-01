package task1TS;

import java.io.*;
import java.util.*;

public class Main implements Serializable {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        Election election = new Election();
        PartiesList partiesList = new PartiesList();
        StationList stationList = new StationList();
        FileInputStream fis = null;
        try {

            FileInputStream fileIn = new FileInputStream("election.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            election = (Election) obj;
            System.out.println("The Object has been read from the file");
            objectIn.close();

        } catch (FileNotFoundException e) {
            System.out.print("");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//
//        }
        try {

            FileInputStream fileIn = new FileInputStream("partiesList.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            partiesList = (PartiesList) obj;
            System.out.println("The Object has been read from the file");
            objectIn.close();

        } catch (FileNotFoundException e) {
            System.out.print("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            FileInputStream fileIn = new FileInputStream("stationList.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            stationList = (StationList) obj;
            System.out.println("The Object has been read from the file");
            objectIn.close();

        }catch (FileNotFoundException e) {
            System.out.print("");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
//        election.add("Eduard", "HB476488", 8932564544L, 2001, 1, false, false);
//        election.add("Eduard", "HB476488", 8932564541L, 2001, 1, false, false);
//        election.add("Eduard", "HB476488", 8932564543L, 2001, 4, false, false);
//        election.add("Eduard", "HB476488", 8932564544L, 2000, 4, false, false);
//        election.add("Eduard", "HB476488", 8932564544L, 2001, 4, false, false);
//        election.add("Eduard", "HB476488", 8932564544L, 2002, 4, false, false);
//        election.add("Eduard", "HB476488", 8932564544L, 2001, 4, false, false);
//        election.add("Eduard", "HB476488", 8932564544L, 1996, 2, true, false);
//        election.add("Eduard", "HB476488", 8932564544L, 1996, 3, true, true);
//        election.add("Ольга", "HB566488", 7832565544L, 2000, 3, false, true);
//        election.add("Ольга2", "HB566488", 7832565544L, 1990, 1, false, false);
//        election.add("Злата", "HB566488", 1111111111L, 1970, 1, false, false);
//        election.add("Злата2", "HB566488", 1111111111L, 2003, 4, false, false);
//        partiesList.addParties("Vidrodzhenya", 23, 9, 2020, "left", new ArrayList<Candidat>(List.of(
//                new Candidat(new Voter("Василь", "НА372676", 1990, 1, false, false, 2345673482L), "Vidrodzhenya", 23),
//                new Candidat(new Voter("Віктор", "НА372985", 1980, 2, false, false, 5678365390L), "Vidrodzhenya", 13),
//                new Candidat(new Voter("Петро", "НА334564", 1985, 3, false, false, 5849364108L), "Vidrodzhenya", 33))));
//        partiesList.addParties("Partizany", 23, 9, 2020, "left", new ArrayList<Candidat>(List.of(
//                new Candidat(new Voter("Василь", "НА372676", 1990, 1, false, false, 1638462864L), "Partizany", 23),
//                new Candidat(new Voter("Віктор", "НА372985", 1980, 2, false, false, 2783746927L), "Partizany", 13),
//                new Candidat(new Voter("Петро", "НА334564", 1985, 3, false, false, 3897462817L), "Partizany", 33))));
//        partiesList.addParties("911", 20, 9, 2009, "right", new ArrayList<>());
            partiesList.sortedPart();
            stationList.setVoterList(election.getVoterList());

//            stationList.addStationStand("СтандартУмань, вул.Українська 2а");
//            stationList.addStationMili("ВійськоваКиїв, вул.Першотравнева 18");
//            stationList.addStationQua("КарантинБіла Церква, вул. Леваневського 38");
//            stationList.addStationStand("СтандартКиїв, вул. Декабристів 119");
            election.setCalendar(2022, 8);
            stationList.updateStation();
            stationList.setVoterList(election.getVoterList());
            Scanner scan = new Scanner(System.in);
            String s = "";
            String firstName;
            String passport;
            long codeID;
            int year;
            int pollStation;
            boolean military;
            boolean quarantine;
            String temp;

            while (!"10".equals(s)) {
                for (String s1 : Arrays.asList("1.Добавление участка", "2.Добавление гражданина", "3.Добавление партии", "4.Указать, что гражданин является кандидатомот определенной партии", "5.Показать избирательные участки", "6.Показать граждан", "7.Показать партии", "8.Выборы –требуется пройти по всем гражданам и у каждого спросить хочет ли он проголосовать.Если да– попросить выбрать партию и дать результат на избирательный участок, к которому относится избиратель.", "9.Показать результаты выборов –показать количество голосов, которые каждая партия получила от каждого участка. А также показать сколько получила всего каждая партия.", "10.Выход из программы")) {
                    System.out.println(s1);
                }
                s = scan.nextLine();
                if (Objects.equals(s, "1")) {
                    System.out.println("Введіть 1 щоб добавити обичний участок, 2 щоб добавити карантинний участок, 3 щоб добавити військовий участок");
                    temp = scan.next();
                    if (Objects.equals(temp, "1")) {
                        System.out.println("Введіть адрес");
                        temp = scan.next();
                        stationList.addStationStand(temp);
                    } else if (Objects.equals(temp, "2")) {
                        System.out.println("Введіть адрес");
                        temp = scan.next();
                        stationList.addStationMili(temp);
                    } else if (Objects.equals(temp, "3")) {
                        System.out.println("Введіть адрес");
                        temp = scan.next();
                        stationList.addStationQua(temp);
                    } else System.out.println("Невірний ввід");
                }
                if (Objects.equals(s, "2")) {
                    System.out.println("Введіть імʼя");
                    firstName = scan.next();
                    System.out.println("Введіть номер паспорта");
                    passport = scan.next();
                    String i;
                    codeID = 0;
                    do {
                        System.out.println("Введіть ідентифікаційний код, він складається з 10 чисел!");
                        i = scan.next();
                        try {
                            codeID = Long.parseLong(i);
                        } catch (NumberFormatException e) {
                            System.out.println("Невірний ввід!");
                        }

                    } while (i.length() != 10);

                    System.out.println("Введіть рік народження");
                    year = scan.nextInt();
                    if (2021 - year < 18) {
                        System.out.println("Вам меньше 18 років, ви не маєте права голосувати");
                        continue;
                    }
                    System.out.println("Введіть 1, якщо військовий, 0 якщо ні ");
                    military = scan.next().equals("1");
                    System.out.println("Введіть 1, якщо на карантині, 0 якщо ні ");
                    quarantine = scan.next().equals("1");
                    System.out.println("Виберіть виборчу дільницю");
                    if (quarantine) {
                        stationList.getQua();
                    } else if (military) {
                        stationList.getMili();
                    } else stationList.getSta();
                    pollStation = scan.nextInt();
                    election.add(firstName, passport, codeID, year, pollStation, military, quarantine);
                    stationList.setVoter(new Voter(firstName, passport, year, pollStation, military, quarantine, codeID));
                    stationList.updateStation();
                }
                if (Objects.equals(s, "3")) {
                    System.out.println("Ведіть назву партії");
                    String nameParties = scan.next();
                    System.out.println("Введіть день заснування партії");
                    int day = scan.nextInt();
                    System.out.println("Введіть місяць заснування партії");
                    int month = scan.nextInt();
                    System.out.println("Ведіть рік заснування партії");
                    int yearPart = scan.nextInt();
                    System.out.println("Введіть до якої фракції відноситься партія. left, right, middle");
                    String fraction = scan.next();

                    partiesList.addParties(nameParties, day, month, yearPart, fraction, new ArrayList<>());
                }
                if (Objects.equals(s, "4")) {
                    election.getAll();
                    System.out.println("Введіть ІНН громадянина який є кандидатом");
                    long inn = scan.nextLong();
                    System.out.println("Введіть назву партії");
                    String partiesName = scan.next();
                    System.out.println("Введіть рейтинг");
                    int rating = scan.nextInt();
                    partiesList.addCan(election.getVoter(inn), partiesName, rating);
                    election.removeVoter(inn);
                }
                if (Objects.equals(s, "5")) {
                    stationList.getStation();
                }
                if (Objects.equals(s, "6")) election.getAll();
                if (Objects.equals(s, "7")) partiesList.soutParties();
                if (Objects.equals(s, "8")) stationList.election(partiesList.getParties());
                if (Objects.equals(s, "9")) stationList.getElection();

            }

            FileOutputStream fout = null;
            try {
                fout = new FileOutputStream("election.txt");
                ObjectOutputStream oos = null;
                oos = new ObjectOutputStream(fout);
                oos.writeObject(election);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fout = new FileOutputStream("partiesList.txt");
                ObjectOutputStream oos = null;
                oos = new ObjectOutputStream(fout);
                oos.writeObject(partiesList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fout = new FileOutputStream("stationList.txt");
                ObjectOutputStream oos = null;
                oos = new ObjectOutputStream(fout);
                oos.writeObject(stationList);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



