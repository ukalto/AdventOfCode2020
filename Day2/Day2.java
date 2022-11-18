import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    static List<String> list = new ArrayList<>();
    static int counter = 0;
    static int helper = 0;
    static int[] number1;
    static int[] number2;
    static String[] value;
    static String[] text;

    private static void loadArray() {
        Scanner scanner = null;
        scanner = new Scanner(new File("Inputs/Day2.txt").getAbsolutePath());
        scanner.useDelimiter("[ \\r\\n]+");

        while (scanner.hasNextLine()) {
            String next = scanner.next();
            list.add(next);
        }
        scanner.close();

        number1 = new int[list.size() / 3];
        number2 = new int[list.size() / 3];
        value = new String[list.size() / 3];
        text = new String[list.size() / 3];
    }

    private static void fillArrays() {
        for (int i = 0; i < list.size(); i++) {
            if (i % 3 == 0) {
                number1[helper] = Integer.parseInt(list.get(i).substring(0, list.get(i).indexOf("-")));
                number2[helper] = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("-") + 1));
            } else if (i % 3 == 1) {
                value[helper] = list.get(i).substring(0, list.get(i).indexOf(":"));
            } else {
                text[helper] = list.get(i);
                helper++;
            }
        }
        helper = 0;
    }

    private static int checkValidPartOne() {
        for (int j = 0; j < list.size() / 3; j++) {
            for (int i = 0; i < text[j].length(); i++) {
                if (Character.toString(text[j].charAt(i)).equals(value[j])) {
                    helper++;
                }
            }
            if (helper >= number1[j] && helper <= number2[j]) {
                counter++;
            }
            helper = 0;
        }
        return counter;
    }

    private static int checkValidPartTwo() {
        for (int j = 0; j < text.length; j++) {
            if (Character.toString(text[j].charAt(number1[j] - 1)).equals(value[j]) && !Character.toString(text[j].charAt(number2[j] - 1)).equals(value[j]) ||
                    !Character.toString(text[j].charAt(number1[j] - 1)).equals(value[j]) && Character.toString(text[j].charAt(number2[j] - 1)).equals(value[j])) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        loadArray();
        fillArrays();
        System.out.println(checkValidPartOne());
        counter = 0;
        System.out.println(checkValidPartTwo());
    }
}