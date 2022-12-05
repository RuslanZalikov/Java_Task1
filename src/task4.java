import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class task4 {
    public static void main(String[] args){
        System.out.println("-----------------\n1.\n-----------------");
        System.out.println(splitLN(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println("-----------------\n2.\n-----------------");
        for (String value: split("((()))(())()()(()())")){
            System.out.println(value);
        }
        System.out.println("-----------------\n3.\n-----------------");
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println("-----------------\n4.\n-----------------");
        System.out.println(overTime(new double[] {13.25, 15, 30, 1.5}));
        System.out.println("-----------------\n5.\n-----------------");
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println("-----------------\n6.\n-----------------");
        System.out.println(bugger(4));
        System.out.println("-----------------\n7.\n-----------------");
        System.out.println(toStarShorthand("abbcccaa"));
        System.out.println("-----------------\n7.2\n-----------------");
        System.out.println(toStarShorthandUpdate("abbcccaa"));
        System.out.println("-----------------\n8.\n-----------------");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println("-----------------\n9.\n-----------------");
        System.out.println(trouble(666789, 12345667));
        System.out.println("-----------------\n10.\n-----------------");
        System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
    }
    public static String splitLN(int n, int k, String s){
        String[] mass = s.split(" ");
        String new_s = "";
        int tmp_count = 0;
        for (int i = 0; i < mass.length; i++){
            if (mass[i].length() + tmp_count <= k){
                new_s += mass[i] + " ";
                tmp_count += mass[i].length();
            }
            else{
                new_s += "\n" + mass[i] + " ";
                tmp_count = mass[i].length();
            }
        }
        return new_s;
    }
//    public static String[] split(String s){
//        String[] new_s_right = s.split("[)]+");
//        String[] new_s_left = s.split("[(]+");
//        String[] new_s = new String[new_s_right.length];
//        for (int i = 0; i < new_s.length; i++){
//            new_s[i] = new_s_right[i] + new_s_left[i+1];
//            int j = 0;
//            for (j = 1; new_s_right[i].length() != new_s_left[i + 1].length() || i+j < new_s_right.length; j++){
////                new_s[i] = new_s_right[i] + new_s_left[i+1];
//                new_s[i] += new_s_right[i + j] + new_s_left[i + j + 1];
//            }
//            i+=j;
//        }
//        for (int i = 0; i < new_s.length; i++){
//            if (new_s[i] == null){
//                new_s[i] = "\t";
//            }
//        }
//        return new_s;
//
//    }
    public static ArrayList<String> split(String s){
        int count = 0;
        String tmp = "";
        ArrayList<String> new_s = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                count++;
            }
            else{
                count--;
            }
            tmp += s.charAt(i);
            if (count == 0){
                new_s.add(tmp);
                tmp = "";
            }
        }
        return new_s;
    }
    public static String toCamelCase(String s){
        String new_s = s;
        while(new_s.indexOf("_") != -1){
            new_s = new_s.substring(0, new_s.indexOf("_")) + (char)(new_s.charAt(new_s.indexOf("_")+1)-32) + new_s.substring(new_s.indexOf("_") + 2);
        }
        return new_s;
    }
    public static String toSnakeCase(String s){
        String new_s = s;
        for(int i = 0; i < new_s.length(); i++){
            if (new_s.charAt(i) > 65 && new_s.charAt(i) < 90){
                new_s = new_s.substring(0, i) + "_" + (char)(new_s.charAt(i) + 32) + new_s.substring(i + 1);
            }
        }
        return new_s;
    }
    public static String overTime(double[] number){
        double start = number[0], finish = number[1], price = number[2];
        double xprofit = number[3];
        double sum = 0;
        sum = (finish - start)*price;
        if (finish > 17){
            sum += (finish - 17)*price*(xprofit - 1);
        }
        return ("$" + String.format("%.2f", sum)).replace(',','.');
    }
    public static String BMI(String a, String b){
        String new_a = a.split(" ")[0];
        String new_b = b.split(" ")[0];
        double d_a = Double.parseDouble(new_a), d_b = Double.parseDouble(new_b);
        if (a.split(" ")[1].equals("pounds")){
            d_a *= 0.453592;
        }
        if (b.split(" ")[1].equals("inches")){
            d_b *= 0.0254;
        }
        double imt = d_a/(d_b*d_b);
        if (imt < 18.5){
            return (String.format("%.1f", imt) + " Underweight").replace(',','.');
        }
        else if (imt > 18.5 && imt < 25){
            return (String.format("%.1f", imt) + " Normal weight").replace(',','.');
        }
        else {
            return (String.format("%.1f", imt) + " Overweight").replace(',','.');
        }

    }
    public static int bugger(int n){
        if(n < 10){
            return 0;
        }
        int sum = 1;
        while(n != 0){
            sum *= n%10;
            n /= 10;
        }
        return bugger(sum) + 1;
    }
    public static String toStarShorthand(String s){
        HashMap<Character, Integer> hashmap = new HashMap<>();
        String new_s = "";
        for (int i = 0; i < s.length(); i++){
            if(!hashmap.containsKey(s.charAt(i))){
                hashmap.put(s.charAt(i), 1);
            }
            else {
                hashmap.put(s.charAt(i), hashmap.get(s.charAt(i)) + 1);
            }
        }
        for (char key: hashmap.keySet()){
            if (hashmap.get(key) == 1){
                new_s += key;
            }
            else{
                new_s += key;
                new_s += "*";
                new_s += hashmap.get(key);
            }
        }
        return new_s;
    }
    public static String toStarShorthandUpdate(String s){
        s += "$";
        String new_s = "";
        int count = 1;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i-1) == s.charAt(i)) {
                count++;
            }
            else{
                if(count == 1){
                    new_s += s.charAt(i-1);
                }
                else{
                    new_s += s.charAt(i-1) + "*" + count;
                }
                count = 1;
            }
        }
        return new_s;
    }

    public static boolean doesRhyme(String s_f, String s_s){
        String[] new_s_f = s_f.substring(s_f.lastIndexOf(" ")).toLowerCase().split("[^aeyuio]");
        String[] new_s_s = s_s.substring(s_s.lastIndexOf(" ")).toLowerCase().split("[^aeyuio]");
        String string_f = "";
        String string_s = "";
        for (int i = 0; i < new_s_f.length; i++){
            string_f += new_s_f[i];
        }
        for (int i = 0; i < new_s_s.length; i++){
            string_s += new_s_s[i];
        }
        return string_f.equals(string_s);
    }
    public static boolean trouble(long num_1, long num_2){
        String string_1 = Long.toString(num_1);
        String string_2 = Long.toString(num_2);
        HashMap<Character, Integer> hashmap_1 = new HashMap<>();
        HashMap<Character, Integer> hashmap_2 = new HashMap<>();
        HashMap<Character, Integer> hashmap_1_1 = new HashMap<>();
        HashMap<Character, Integer> hashmap_2_2 = new HashMap<>();
        for (int i = 0; i < string_1.length(); i++){
            if(!hashmap_1.containsKey(string_1.charAt(i))){
                hashmap_1.put(string_1.charAt(i), 1);
            }
            else {
                hashmap_1.put(string_1.charAt(i), hashmap_1.get(string_1.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < string_2.length(); i++){
            if(!hashmap_2.containsKey(string_2.charAt(i))){
                hashmap_2.put(string_2.charAt(i), 1);
            }
            else {
                hashmap_2.put(string_2.charAt(i), hashmap_2.get(string_2.charAt(i)) + 1);
            }
        }
        for (char key: hashmap_1.keySet()){
            if(hashmap_1.get(key) == 3){
                hashmap_1_1.put(key, 1);
            }
        }
        for (char key: hashmap_2.keySet()){
            if(hashmap_2.get(key) == 2){
                hashmap_2_2.put(key, 1);
            }
        }
        for (char key: hashmap_1_1.keySet()){
            for (char key_2: hashmap_2_2.keySet()){
                if (key == key_2){
                    return true;
                }
            }
        }
        return false;
    }
    public static int countUniqueBooks(String s, char a){
        boolean flag = false;
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == a && !flag){
                flag = true;
                continue;
            }
            if(s.charAt(i) == a && flag){
                flag = false;
                continue;
            }
            if(flag){
                hs.add(s.charAt(i));
            }
        }
        return hs.size();
    }
}
