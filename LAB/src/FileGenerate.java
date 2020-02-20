import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FileGenerate {
    public FileGenerate(ArrayList<Character> mas, String fileName) {

        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (int i = 0; i < 10000; i++) {
                writer.append(getFullRandomElement(mas));
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public Character getFullRandomElement(ArrayList<Character> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
