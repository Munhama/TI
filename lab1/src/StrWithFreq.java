import java.util.ArrayList;

public class StrWithFreq {
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
