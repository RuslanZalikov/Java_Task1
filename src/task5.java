import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.util.*;
import java.math.BigInteger;

public class task5 {
    public static void main(String[] args){
        System.out.println("-----------------\n1.\n-----------------");
        System.out.println(encrypt("Sunshine"));
        System.out.println(decrypt(new ArrayList<Integer>(Arrays.asList(72, 33, -73, 84, -12, -3, 13, -13, -68))));
        System.out.println("-----------------\n2.\n-----------------");
        System.out.println(canMove("knight", "B5", "D6"));
        System.out.println("-----------------\n3.\n-----------------");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println("-----------------\n4.\n-----------------");
        System.out.println(sumDigProd(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        System.out.println("-----------------\n5.\n-----------------");
        System.out.println(sameVowelGroup(new ArrayList<String>(Arrays.asList("hoops", "chuff", "bot", "bottom"))));
        System.out.println("-----------------\n6.\n-----------------");
        System.out.println(validateCard("1234567890123452"));
        System.out.println("-----------------\n7.\n-----------------");
        System.out.println(numToEng(0));
        System.out.println("-----------------\n8.\n-----------------");
        System.out.println("-----------------\n9.\n-----------------");
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println("-----------------\n10.\n-----------------");
        System.out.println(hexLattice(37));

    }


    public static ArrayList<Integer> encrypt(String s){
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int)s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            result.add((int)s.charAt(i)-(int)s.charAt(i-1));
        }
        return result;
    }


    public static String decrypt(ArrayList<Integer> array){
        String s = "";
        s += (char)(int)array.get(0);
        for(int i = 1; i < array.size(); i++){
            s += (char)((int)s.charAt(s.length()-1) + (int)array.get(i));
        }
        return s;
    }


    public static boolean canMove(String name, String pos, String target){
        if (pos.charAt(0) < 'A' || pos.charAt(0) > 'H' || pos.charAt(1) < '0' || pos.charAt(1) > '8'){
            return false;
        }
        if (target.charAt(0) < 'A' || target.charAt(0) > 'H' || target.charAt(1) < '0' || target.charAt(1) > '8'){
            return false;
        }
        if (name.equals("pawns")){
            if ((int)pos.charAt(1)-'0' == 2 || (int)pos.charAt(1)-'0' == 7){
                return Math.abs((int)pos.charAt(1) - (int)target.charAt(1)) <= 2
                        && Math.abs((int)pos.charAt(1) - (int)target.charAt(1)) >= 1
                        && pos.charAt(0) == target.charAt(0);
            }
            else if ((int)pos.charAt(1)-'0' > 2 && (int)pos.charAt(1)-'0' < 7){
                return Math.abs((int)pos.charAt(1) - (int)target.charAt(1)) == 1
                        && pos.charAt(0) == target.charAt(0);
            }
            else {
                return false;
            }
        }
        else if (name.equals("king")){
            return Math.pow(pos.charAt(0) - target.charAt(0), 2) + Math.pow(pos.charAt(1) - target.charAt(1), 2) <= 2;
        }
        else if (name.equals("rook")){
            return pos.charAt(0) == target.charAt(0) || pos.charAt(1) == target.charAt(1);
        }
        else if(name.equals("bishop")){
            return Math.abs(pos.charAt(0) - target.charAt(0)) == Math.abs(pos.charAt(1) - target.charAt(1));
        }
        else if(name.equals("queen")){
            return (pos.charAt(0) == target.charAt(0) || pos.charAt(1) == target.charAt(1))
                    || (Math.abs(pos.charAt(0) - target.charAt(0)) == Math.abs(pos.charAt(1) - target.charAt(1)));
        }
        else if(name.equals("knight")){
            return (Math.abs(pos.charAt(0) - target.charAt(0)) == 2 && Math.abs(pos.charAt(1) - target.charAt(1)) == 1)
                    || (Math.abs(pos.charAt(0) - target.charAt(0)) == 1 && Math.abs(pos.charAt(1) - target.charAt(1)) == 2);
        }
        else {
            return false;
        }
    }


    public static boolean canComplete(String short_s, String s){
        int k = 0;
        for (int i = 0; i < short_s.length(); i++){
            while(short_s.charAt(i) != s.charAt(k) && k + 1 < s.length()){
                k++;
            }
            if (short_s.charAt(i) == s.charAt(k)){
                k++;
            }
            if(i + 1 != short_s.length() && k + 1 >= s.length()){
                return false;
            }
        }
        return true;
    }


    public static int sumDigProd(ArrayList<Integer> array){
        if(array.size() == 1 && array.get(0) == 0){
            return 0;
        }
        int summ = 0;
        for (int i = 0; i < array.size(); i++){
            summ += array.get(i);
        }
        int result = 10;
        while(result / 10 != 0) {
            int dot = 1;
            while (summ != 0) {
                dot *= summ % 10;
                summ /= 10;
            }
            result = dot;
            summ = dot;
        }
        return result;
    }


    public static ArrayList<String> sameVowelGroup(ArrayList<String> array) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<Character> first = new HashSet<>();
        for (int i = 0; i < array.get(0).length(); i++) {
            if (help_sameVowelGroup(array.get(0).charAt(i))){
                first.add(array.get(0).charAt(i));
            }
        }
        result.add(array.get(0));
        HashSet<Character> temp = new HashSet<>();
        for (int j = 1; j < array.size(); j++){
            for (int i = 0; i < array.get(j).length(); i++) {
                if (help_sameVowelGroup(array.get(j).charAt(i))){
                    temp.add(array.get(j).charAt(i));
                }
            }
            if (first.equals(temp)){
                result.add(array.get(j));
            }
            temp.clear();
        }
        return result;
    }
    public static boolean help_sameVowelGroup(char a){
        return a == 'a' || a == 'e' || a == 'y' || a == 'u' || a == 'i' || a == 'o';
    }

    public static boolean validateCard(String number){
        if (number.length() < 14 || number.length() > 19){
            return false;
        }
        char control = number.charAt(number.length()-1);
        String temp = "";
        for (int i = number.length() - 2; i >= 0; i--){
            temp += number.charAt(i);
        }
        String new_s = "";
        for (int i = 0; i < temp.length(); i++){
            if (i%2 == 0){
                new_s += help_valudateCard(temp.charAt(i));
            }
            else {
                new_s += temp.charAt(i);
            }
        }
        int summ = 0;
        for (int i = 0; i < new_s.length(); i++){
            summ += new_s.charAt(i) - '0';
        }
        return 10 - (summ%10) == control - '0';
    }
    public static String help_valudateCard(char value){
        int temp = (int)value - '0';
        temp *= 2;
        String s = Integer.toString(temp);
        int summ = 0;
        for(int i = 0; i < s.length(); i++){
            summ += (int)s.charAt(i) - '0';
        }
        return Integer.toString(summ);
    }


    public static String numToEng(int n){
        if (n == 0){
            return "zero";
        }
        HashMap<Integer, String> MP = new HashMap<>(){{
            put(1, "one");put(2, "two");put(3, "three");put(4, "four");
            put(5, "five");put(6, "six");put(7, "seven");put(8, "eight");put(9, "nine");
            put(10, "ten");put(11, "eleven");put(12, "twelve");put(13, "thirteen");put(14, "fourteen");
            put(15, "fifteen");put(16, "sixteen");put(17, "seventeen");put(18, "eighteen");put(19, "nineteen");
        }};
        HashMap<Integer, String> TEN = new HashMap<>(){{
            put(2, "twenty");put(3, "thirty");put(4, "forty");put(5, "fifty");put(6, "sixty");
            put(7, "seventy");put(8, "eighty");put(9, "ninety");
        }};
        if (n <= 20){
            return MP.get(n);
        }
        String s = Integer.toString(n);
        String new_s = "";
        if (n < 100){
            new_s += TEN.get(s.charAt(0) - '0') + " " + MP.get(s.charAt(1) - '0');
            return new_s;
        }
        else {
            String ten = "";
            String one = "";
            if (TEN.get(s.charAt(1) - '0') != null){
                ten = TEN.get(s.charAt(1) - '0') + " ";
            }
            if (MP.get(s.charAt(2) - '0') != null){
                one = MP.get(s.charAt(2) - '0');
            }
            new_s += MP.get(s.charAt(0) - '0') + " hundred " + ten + one;
            return new_s;
        }
    }


    public static String correctTitle(String s){
        String[] new_s = s.split(" ");
        s = "";
        for (int i = 0; i < new_s.length; i++){
            new_s[i] = new_s[i].toLowerCase();
            if (!new_s[i].equals("and") && !new_s[i].equals("the") && !new_s[i].equals("of") && !new_s[i].equals("in")){
                new_s[i] = (char)(new_s[i].charAt(0)-('a'-'A')) + new_s[i].substring(1);
            }
            s += new_s[i] + " ";
        }
        return s;
    }


    public static String hexLattice(int k){
        String new_s = "";
        for (int i = 1; 3*i*(i-1) + 1 <= k; i++){
            if (3*i*(i-1) + 1 == k){
                double D = Math.sqrt(12*k - 3);
                int n = (3 + (int)Math.round(D)) / 6;
                for (int j = n; j <= n*2 - 1; j++){
                    new_s += help_hexLattice(j);
                    new_s += '\n';
                }
                for (int j = n*2 - 2; j >= n; j--){
                    new_s += help_hexLattice(j);
                    new_s += '\n';
                }
                return new_s;
            }
        }
        return "invalid";
    }
    public static String help_hexLattice(int n){
        String new_s = "";
        for (int i = 0; i < n; i++){
            new_s += "o";
        }
        return new_s;
    }
}
