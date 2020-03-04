import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EntropiaPair {
    public double entropPair;

    public EntropiaPair(String str) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        for (char ch: str.toCharArray()){
            readArr.add(ch);
        }
        ArrayList<String> arrStr = new ArrayList<String>();
        for (int i = 1; i < readArr.size(); i++) {
            arrStr.add(readArr.get(i - 1).toString() + readArr.get(i).toString());
        }

        Set<String> unic = new HashSet<String>(arrStr);
        ArrayList<StrWithFreq> prFreq = new ArrayList<StrWithFreq>();

        for (String str1 : unic) {
            prFreq.add(new StrWithFreq(arrStr, str1));
        }

        double H = 0;
        for (StrWithFreq fr : prFreq) {
            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));
        }
        H *= -1.0 / 2;
        entropPair = H;
    }
}


class StrWithFreq {
    public String symbol;
    public double freq;

    public StrWithFreq(ArrayList<String> all, String symbol) {
        this.symbol = symbol;
        int j = 0;
        for (String ch : all) {
            if (this.symbol.equals(ch)) j++;
        }

        this.freq = j * 1.0 / all.size();
    }
}
