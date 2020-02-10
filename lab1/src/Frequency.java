import java.util.ArrayList;

public class Frequency {
    public Character symbol;
    public double freq;

    public Frequency(ArrayList<Character> all, Character symbol) {
        this.symbol = symbol;
        int j = 0;
        for (Character ch : all){
            if (this.symbol.equals(ch)) j++;
        }
//        System.out.println(j);
//        System.out.println(this.symbol);
        this.freq = j*1.0/all.size();
    }
}
