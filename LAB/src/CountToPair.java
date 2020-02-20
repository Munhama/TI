import java.util.ArrayList;
import java.util.Set;

public class CountToPair {
    public ArrayList<Integer> result;
   public CountToPair(Set<String> unic, ArrayList<String> arrStr){
       result = new ArrayList<>();
       for(String un: unic){
           int count = 0;
           for(String str: arrStr){
                if(un.equals(str)) count++;
           }
           result.add(count);
       }
   }
}
