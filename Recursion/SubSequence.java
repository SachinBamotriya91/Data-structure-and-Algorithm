import java.util.ArrayList;
import java.util.Scanner;

public class SubSequence {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        ArrayList<String> ss = new ArrayList<>();
        ss = gss(input);
        System.out.println(ss);
        scan.close();

    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> brs = new ArrayList<>();
            brs.add("");
            return brs;
        }
        char f = str.charAt(0);
        String rss = str.substring(1);
        ArrayList<String> ross = gss(rss);
        ArrayList<String> ros = new ArrayList<>();
        for (String val : ross) {
            ros.add("" + val);
        }
        for (String val : ross) {
            ros.add(f + val);
        }

        return ros;
    }

}
