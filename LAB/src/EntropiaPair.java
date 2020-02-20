import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EntropiaPair {
    public EntropiaPair(String fileName) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        try (FileReader reader = new FileReader(fileName)) {

            int c;
            while ((c = reader.read()) != -1) {

                readArr.add((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        ArrayList<String> arrStr = new ArrayList<String>();
        for (int i = 1; i < readArr.size(); i++) {
            arrStr.add(readArr.get(i - 1).toString() + readArr.get(i).toString());
        }

        Set<String> unic = new HashSet<String>(arrStr);
        ArrayList<StrWithFreq> prFreq = new ArrayList<>();

        for (String str : unic) {
            prFreq.add(new StrWithFreq(arrStr, str));
        }
        int unicLength = unic.size();
        CountToPair counts = new CountToPair(unic, arrStr);

        double H = 0;
        for (StrWithFreq fr : prFreq) {
            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));

        }
        H *= -1.0 / 2;
        System.out.println(H);
    }
}
