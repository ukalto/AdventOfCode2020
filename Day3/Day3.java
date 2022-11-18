import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    static List<String> list = new ArrayList<>();
    static long treeCounter = 1;

    private static void loadArray() {
        try {
            list = Files.readAllLines(new File("Inputs/Day3.txt").toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countTrees(int x, int y) {
        int treeCount = 0;
        for (int i = 0, j = 0; i < list.size(); i += y, j += x) {
            if (list.get(i).charAt(j % list.get(i).length()) == '#')
                treeCount++;
        }
        treeCounter *= treeCount;
        return treeCount;
    }

    public static void main(String[] args) {
        loadArray();
        System.out.println(countTrees(1, 1));
        System.out.println(countTrees(3, 1));
        System.out.println(countTrees(5, 1));
        System.out.println(countTrees(7, 1));
        System.out.println(countTrees(1, 2));
        System.out.println(treeCounter);
    }
}