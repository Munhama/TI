import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanCode {

    private static ArrayList<SymbolPrefix> symbolPrefixes;

    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();

        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

        assert trees.size() > 0;

        while (trees.size() > 1) {

            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            symbolPrefixes.add(new SymbolPrefix(leaf.value.toString(), prefix.toString()));
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void entropia(String fileName) {
        ArrayList<Character> readArr = new ArrayList<Character>();
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                readArr.add(Character.toString(ch).toLowerCase().charAt(0));
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        ArrayList<Character> readArr2 = new ArrayList<Character>();
        StringBuilder wordsChange = new StringBuilder();
        if (fileName.equals("F3.txt")) {
            String[] string = readArr.toString().replaceAll("[^а-яё]", "").split("");
            for (String str : string) {
                readArr2.add(str.charAt(0));
            }

            for (char c : readArr2) {
                wordsChange.append(c);
            }
        } else {
            for (char c : readArr) {
                wordsChange.append(c);
            }
        }
        String result = wordsChange.toString();

        int[] charFreqs = new int[10000];
        for (char c : result.toCharArray()) {
            charFreqs[c]++;
        }

        HuffmanTree tree = buildTree(charFreqs);

        symbolPrefixes = new ArrayList<>();
        System.out.println("______________________________________________________");
        printCodes(tree, new StringBuffer());
        String coded = result;

        double awg = 0;
        for (SymbolPrefix sp : symbolPrefixes) {
            coded = coded.replaceAll(sp.symbol, sp.prefix);
            awg += sp.prefix.length();
        }
        double L = awg/symbolPrefixes.size();
//        System.out.println("L " + L);

        StringBuilder wordsChangeNotRepeat = new StringBuilder();
        for (char c : coded.toCharArray()) {
            if (wordsChangeNotRepeat.toString().indexOf(c) == -1)
                wordsChangeNotRepeat.append(c);
        }

        ArrayList<Frequency> frArr = new ArrayList<Frequency>();
        for (String ch : wordsChangeNotRepeat.toString().split("")) {
            frArr.add(new Frequency(coded.toCharArray(), ch.charAt(0)));
        }

        double H = 0;
        for (Frequency fr : frArr) {

            H += fr.freq * (Math.log10(fr.freq) / Math.log10(2));
        }
        H *= -1;

        Entropia e = new Entropia(fileName);
        double mu = L-e.entrop;
        System.out.println("mu " + mu);
        System.out.println("H " + H);
        EntropiaPair ep = new EntropiaPair(coded);
        System.out.println("Pair " + ep.entropPair);
        EntropiaTriple et = new EntropiaTriple(coded);
        System.out.println("Triple " + et.entropPair);
    }

    public static void main(String[] args) {

        entropia("F1.txt");
        entropia("F2.txt");
        entropia("F3.txt");

    }
}