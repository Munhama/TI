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
//        System.out.print("Теоретическое: ");
//        System.out.println(Math.log10(arr.size())/Math.log10(2));
        System.out.println("пары:");
//        System.out.print("F1: ");
        EntropiaPair entropiaPair = new EntropiaPair("F1.txt");
        System.out.print("Теоретическое: ");
        ArrayList<Double> D = new ArrayList<>();
        D.add((double)1/3);
        D.add((double)1/3);
        D.add((double)1/3);
        System.out.println(ShenonD(D));




        System.out.print("F2: ");
        Entropia entropia2 = new Entropia("F2.txt");


//        System.out.print("Теоретическое: ");
//        System.out.println(Math.log10(tempArr.size())/Math.log10(2));


        System.out.print("пары: ");
        EntropiaPair entropiaPair2 = new EntropiaPair("F2.txt");

        System.out.print("Теоретическое: ");
       ArrayList<Integer> inShenon = new ArrayList<>();
        for(CharWithProb t :tempArr){
            inShenon.add(t.probability);
        }
        System.out.println(Shenon(inShenon));
//        System.out.println(Math.log10(tempArr.size())/Math.log10(2));

        System.out.println("Энтропия частоты отдельных символов");
        System.out.print("F3: ");
        Entropia entropia3 = new Entropia("F3.txt");
        System.out.print("Теоретическое значение F3: ");
        System.out.println(Math.log10(256)/Math.log10(2));
        System.out.println("Энтропия частоты пар символов");
        System.out.print("F3: ");
        EntropiaPair entropiaPair3 = new EntropiaPair("F3.txt");

        System.out.println("Энтропия частоты отдельных символов русский алфавит");
        System.out.print("F3: ");
        EntropiaRus entropiaRus = new EntropiaRus("F3.txt");
        System.out.print("Теоретическое значение F3 русский алфавит: ");
        System.out.println(Math.log10(35)/Math.log10(2));
        System.out.println("Энтропия частоты пар символов русский алфавит");
        System.out.print("F3: ");
        EntropiaPairRus entropiaPairRus = new EntropiaPairRus("F3.txt");
    }
    private static Double Shenon(ArrayList<Integer> probs){
        int sum=0;
        for(int pr: probs){
            sum+=pr;
        }
        double result =0.0;
        for(int pr: probs){
            result+= (pr*1.0/sum)*(Math.log10(pr*1.0/sum)/Math.log10(2));
        }
        return -1*result;
    }

    private static Double ShenonD(ArrayList<Double> probs){
        double sum=0;
        for(double pr: probs){
            sum+=pr;
        }
        double result =0.0;
        for(double pr: probs){
            result+= (pr*1.0/sum)*(Math.log10(pr*1.0/sum)/Math.log10(2));
        }
        return -1*result;
    }
}
