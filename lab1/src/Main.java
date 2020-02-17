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

        System.out.println("Энтропия частоты отдельных символов");
        System.out.print("F1: ");
        Entropia entropia1 = new Entropia("F1.txt");
        System.out.print("F2: ");
        Entropia entropia2 = new Entropia("F2.txt");
        System.out.print("Теоретическое значение F1: ");
        System.out.println(Math.log10(arr.size())/Math.log10(2));
        System.out.print("Теоретическое значение F2: ");
        System.out.println(Math.log10(tempArr.size())/Math.log10(2));

        System.out.println("Энтропия частоты пар символов");
        System.out.print("F1: ");
        EntropiaPair entropiaPair = new EntropiaPair("F1.txt");
        System.out.print("F2: ");
        EntropiaPair entropiaPair2 = new EntropiaPair("F2.txt");
        System.out.print("Теоретическое значение F1: ");
        System.out.println(Math.log10(arr.size())/Math.log10(2));
        System.out.print("Теоретическое значение F2: ");
        System.out.println(Math.log10(tempArr.size())/Math.log10(2));

        System.out.println("Энтропия частоты отдельных символов");
        System.out.print("F3: ");
        Entropia entropia3 = new Entropia("F3.txt");
        System.out.println("Энтропия частоты пар символов");
        System.out.print("F3: ");
        EntropiaPair entropiaPair3 = new EntropiaPair("F3.txt");

        System.out.println("Энтропия частоты отдельных символов русский алфавит");
        System.out.print("F3: ");
        EntropiaRus entropiaRus = new EntropiaRus("F3.txt");
        System.out.println("Энтропия частоты пар символов русский алфавит");
        System.out.print("F3: ");
        EntropiaPairRus entropiaPairRus = new EntropiaPairRus("F3.txt");
    }
}
