import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
    static List<String> list = new ArrayList<>();
    static List<String> advancedList = new ArrayList<>();
    static int validCounter = 0;
    static List<String> validEcl = new ArrayList<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

    private static void loadList() {
        try {
            list = Files.readAllLines(new File("Inputs/Day4.txt").toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countValids1() {
        for (int i = 0; i < advancedList.size(); i++) {
            if (advancedList.get(i).contains("byr:"))
                if (advancedList.get(i).contains("iyr:"))
                    if (advancedList.get(i).contains("eyr:"))
                        if (advancedList.get(i).contains("hgt:"))
                            if (advancedList.get(i).contains("hcl:"))
                                if (advancedList.get(i).contains("ecl:"))
                                    if (advancedList.get(i).contains("pid:"))
                                        validCounter++;
        }
        return validCounter;
    }

    private static int countValids2() {
        for (int i = 0; i < advancedList.size(); i++) {
            String[] parts = advancedList.get(i).split(" ");
            int counter = 0;
            for (int j = 0; j < parts.length; j++) {
                if (parts[j].contains("byr:")) {
                    int x = Integer.parseInt(parts[j].substring(4));
                    if (x >= 1920 && x <= 2002)
                        counter++;
                } else if (parts[j].contains("iyr:")) {
                    int x = Integer.parseInt(parts[j].substring(4));
                    if (x >= 2010 && x <= 2020)
                        counter++;
                } else if (parts[j].contains("eyr:")) {
                    int x = Integer.parseInt(parts[j].substring(4));
                    if (x >= 2020 && x <= 2030)
                        counter++;
                } else if (parts[j].contains("hgt:")) {
                    String x = parts[j].substring(4);
                    String[] y = null;
                    String measure = "";
                    if (x.contains("in")) {
                        y = x.split("in");
                        measure = "in";
                    } else if (x.contains("cm")) {
                        y = x.split("cm");
                        measure = "cm";
                    }
                    int z = 0;
                    if (y != null)
                        z = Integer.parseInt(y[0]);
                    if ((measure.equals("cm") && z >= 150 && z <= 193) || (measure.equals("in") && z >= 59 && z <= 76)) {
                        counter++;
                    }
                } else if (parts[j].contains("hcl:")) {
                    String x = parts[j].substring(5);
                    if (x.length() == 6) {
                        for (int k = 0, z = 0; k < x.length(); k++) {
                            char c = x.charAt(k);
                            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f'))
                                z++;
                            if (z == 6)
                                counter++;
                        }
                    }
                } else if (parts[j].contains("ecl:")) {
                    String x = parts[j].substring(4);
                    if (validEcl.contains(x))
                        counter++;
                } else if (parts[j].contains("pid:")) {
                    String x = parts[j].substring(4);
                    if (x.length() == 9)
                        counter++;
                }
            }
            if (counter == 7)
                validCounter++;
        }
        return validCounter;
    }

    private static void loadAvancedList() {
        String row = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                row += list.get(i);
                advancedList.add(row);
            } else if (!list.get(i).equals("")) {
                row += list.get(i) + " ";
            } else {
                advancedList.add(row);
                row = "";
            }
        }
    }

    public static void main(String[] args) {
        loadList();
        loadAvancedList();
        System.out.println("Part 1: " + countValids1());
        validCounter = 0;
        System.out.println("Part 2: " + countValids2());
    }
}