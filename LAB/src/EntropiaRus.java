import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EntropiaRus {
    public EntropiaRus(String fileName) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                Character ch = (char) c;
                readArr.add(ch.toString().toLowerCase().charAt(0));
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        ArrayList<Character> readArr2 = new ArrayList<Character>();
        String[] string = readArr.toString().replaceAll("[^а-яё]", "").split("");
        for (String str : string) {
            readArr2.add(str.charAt(0));
        }

        StringBuilder wordsChangeNotRepeat = new StringBuilder();
        for (char c : readArr2) {
            if (wordsChangeNotRepeat.toString().indexOf(c) == -1)
                wordsChangeNotRepeat.append(c);
        }

        String result = wordsChangeNotRepeat.toString();

        ArrayList<Frequency> frArr = new ArrayList<Frequency>();
        for (String ch : result.split("")) {
            frArr.add(new Frequency(readArr2, ch.charAt(0)));
        }

        double H = 0;
        for (Frequency fr : frArr) {

            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));
        }
        H *= -1;
        System.out.println(H);
    }
}
