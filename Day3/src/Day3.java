import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    static List<String> list = new ArrayList<>();
    static int treeCounter = 0;

    private static void loadArray() {
        try {
            list = Files.readAllLines(new File("Inputs/Day3.txt").toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countTrees() {
        return treeCounter;
    }

    public static void main(String[] args) {
        loadArray();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(countTrees());
    }
}