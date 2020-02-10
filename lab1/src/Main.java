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
        tempArr.add(new CharWithProb('a',5));
        tempArr.add(new CharWithProb('b',3));
        tempArr.add(new CharWithProb('c',2));

        ArrayList<Character> arr2 = new ArrayList<Character>();
        for (CharWithProb el : tempArr) {
            for (int i=0; i<el.probability; i++){
                arr2.add(el.character);
            }
        }
        FileGenerate file2 = new FileGenerate(arr2, "F2.txt");

        ArrayList<Character> readArr = new ArrayList<Character>();
        try(FileReader reader = new FileReader("F2.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                readArr.add((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        StringBuilder wordsChangeNotRepeat = new StringBuilder();
        for (char c : readArr) {
            if (wordsChangeNotRepeat.toString().indexOf(c) == -1) //тут подчёркивает с
                wordsChangeNotRepeat.append(c);
        }

        String result = wordsChangeNotRepeat.toString();
        System.out.println(result);
        ArrayList<Frequency> frArr = new ArrayList<Frequency>();
        for (String ch : result.split("")){
            frArr.add(new Frequency(readArr, ch.charAt(0)));
        }

        double H = 0;
        for (Frequency fr : frArr){
//            System.out.println(fr.symbol);
//            System.out.println(fr.freq);
//            System.out.println(Math.log10(8)/Math.log10(2));
            H += fr.freq * (Math.log10(fr.freq)/Math.log10(2));
        }
        H *= -1;
        System.out.println(H);
    }
}
