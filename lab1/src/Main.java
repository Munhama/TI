import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Character> arr = new ArrayList<Character>();
        arr.add('a');
        arr.add('b');
        arr.add('c');
        FileGenerate file = new FileGenerate(arr, "F1.txt");

        ArrayList<CharWithProb> tempArr = new ArrayList<CharWithProb>();
        tempArr.add(new CharWithProb('a', 5));
        tempArr.add(new CharWithProb('b', 3));
        tempArr.add(new CharWithProb('c', 2));

        ArrayList<Character> arr2 = new ArrayList<Character>();
        for (CharWithProb el : tempArr) {
            for (int i = 0; i < el.probability; i++) {
                arr2.add(el.character);
            }
        }
        FileGenerate file2 = new FileGenerate(arr2, "F2.txt");

        Entropia entropia1 = new Entropia("F1.txt");
        Entropia entropia2 = new Entropia("F2.txt");

        EntropiaPair entropiaPair = new EntropiaPair("F1.txt");
        EntropiaPair entropiaPair2 = new EntropiaPair("F2.txt");
    }
}
