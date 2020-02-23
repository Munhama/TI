import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EntropiaTriple {
    public double entropPair;

    public EntropiaTriple(String str) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        for (char ch: str.toCharArray()){
            readArr.add(ch);
        }
        ArrayList<String> arrStr = new ArrayList<String>();
        for (int i = 2; i < readArr.size(); i++) {
            arrStr.add(readArr.get(i - 2).toString()  + readArr.get(i - 1).toString() + readArr.get(i).toString());
        }

        Set<String> unic = new HashSet<String>(arrStr);
        ArrayList<StrWithFreqTriple> prFreq = new ArrayList<StrWithFreqTriple>();

        for (String str1 : unic) {
            prFreq.add(new StrWithFreqTriple(arrStr, str1));
        }

        double H = 0;
        for (StrWithFreqTriple fr : prFreq) {
            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));
        }
        H *= -1.0 / 3;
        entropPair = H;
    }
}


class StrWithFreqTriple {
    public String symbol;
    public double freq;

    public StrWithFreqTriple(ArrayList<String> all, String symbol) {
        this.symbol = symbol;
        int j = 0;
        for (String ch : all) {
            if (this.symbol.equals(ch)) j++;
        }

        this.freq = j * 1.0 / all.size();
    }
}
