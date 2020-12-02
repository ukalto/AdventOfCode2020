import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class main {
    static List<String> list = new ArrayList<>();
    static int valuea = 0;
    static int valueb = 0;
    static int valuec = 0;

    private static void loadArray() {
        try {
            list = Files.readAllLines(new File("file.txt").toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String searchOutOf22020() {
        for (int i = 0; i < list.size(); i++) {
            valuea = Integer.parseInt(list.get(i));
            for (int j = 0; j < list.size(); j++) {
                valueb = Integer.parseInt(list.get(j));
                if ((valuea + valueb) == 2020) {
                    return valuea * valueb + " ";
                }
            }
        }
        return "No Match";
    }

    private static String searchOutOf32020() {
        for (int i = 0; i < list.size(); i++) {
            valuea = Integer.parseInt(list.get(i));
            for (int j = 0; j < list.size(); j++) {
                valueb = Integer.parseInt(list.get(j));
                for (int k = 0; k < list.size(); k++) {
                    valuec = Integer.parseInt(list.get(k));
                    if ((valuea + valueb + valuec) == 2020) {
                        return valuea * valueb * valuec + " ";
                    }
                }
            }
        }
        return "No Match";
    }

    public static void main(String[] args) {
        loadArray();
        System.out.println(searchOutOf22020());
        System.out.println(searchOutOf32020());
    }
}