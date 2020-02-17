import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EntropiaPairRus {
    public EntropiaPairRus(String fileName) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        try (FileReader reader = new FileReader(fileName)) {

            int c;
            while ((c = reader.read()) != -1) {

                readArr.add((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        ArrayList<Character> readArr2 = new ArrayList<Character>();
        String[] string = readArr.toString().replaceAll("[^а-яё]", "").split("");
        for (String str : string) {
            readArr2.add(str.charAt(0));
        }

        ArrayList<String> arrStr = new ArrayList<String>();
        for (int i = 1; i < readArr2.size(); i++) {
            arrStr.add(readArr2.get(i - 1).toString() + readArr2.get(i).toString());
        }

        Set<String> unic = new HashSet<String>(arrStr);
        ArrayList<StrWithFreq> prFreq = new ArrayList<>();

        for (String str : unic) {
            prFreq.add(new StrWithFreq(arrStr, str));
        }

        double H = 0;
        for (StrWithFreq fr : prFreq) {
            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));
        }
        H *= -1.0 / 2;
        System.out.println(H);
    }
}
