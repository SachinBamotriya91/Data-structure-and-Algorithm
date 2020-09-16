import java.util.ArrayList;
import java.util.Scanner;

public class KeyPadCombination {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
        ArrayList<String> result = new ArrayList<String>();
        result = getKPC(str);
        System.out.println(result);
    }

    static String[] code = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    // 678;
    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> em = new ArrayList<>();
            em.add("");
            return em;
        }

        char ch = str.charAt(0); // 'm6'
        String rss = str.substring(1); // 78
        ArrayList<String> ross = getKPC(rss); // [tv,tw,tx,uv,uw,ux];

        ArrayList<String> ros = new ArrayList<>();
        String codeChar = code[ch - '0']; // pqrs //'0'=48 '6'=48+6=54 '6'-'0'=54-48=6
        for (int i = 0; i < codeChar.length(); i++) {
            char chcode = codeChar.charAt(i); // p,q,r,s
            for (String val : ross) {
                ros.add(chcode + val); //
            }
        }
        return ros;
    }

}
