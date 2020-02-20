import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Entropia {
    public Entropia(String fileName) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {

                readArr.add((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        StringBuilder wordsChangeNotRepeat = new StringBuilder();
        for (char c : readArr) {
            if (wordsChangeNotRepeat.toString().indexOf(c) == -1)
                wordsChangeNotRepeat.append(c);
        }

        String result = wordsChangeNotRepeat.toString();

        ArrayList<Frequency> frArr = new ArrayList<Frequency>();
        for (String ch : result.split("")) {
            frArr.add(new Frequency(readArr, ch.charAt(0)));
        }

        double H = 0;
//        System.out.println("");
//        for(Frequency f: frArr){
//            System.out.print(" "+f.freq);
//        }
//        System.out.println("");
        for (Frequency fr : frArr) {

            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));
        }
        H *= -1;
        System.out.println(H);
    }
}
