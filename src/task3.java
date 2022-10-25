import java.util.HashSet;
import java.util.Set;
public class task3 {
    public static void main(String[] args){
        System.out.println(solutions(1,0,0));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(97));
        System.out.println(flipEndChars("evg"));
        System.out.println(isValidHexCode("CD5C5C"));
        System.out.println(same(new int[] {1, 2, 3}, new int[] {1, 2, 3, 3}));
        System.out.println(isKaprekar(0));
        System.out.println(longestZero("01100001011000"));
        System.out.println(nextPrime(11));
        System.out.println(rightTriangle(70, 130, 110));
    }
    public static int solutions(double a, double b, double c){
        double D = b*b - 4*a*c;
        return D > 0 ? 2 : D == 0 ? 1 : 0;
    }
    public static int findZip(String s){
        return s.indexOf("zip", s.indexOf("zip") + 1);
    }
    public static boolean checkPerfect(int value){
        int sum = 0;
        for (int i = 1; i <= value/2; i++){
            if (value % i == 0){
                sum += i;
            }
        }
        return value == sum;
    }
    public static String flipEndChars(String s) {
        if (s.length() < 2) {
            return "incompatible";
        } else if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return "Two's a pair.";
        } else {
            char tmp = s.charAt(0);
            s = s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);
            return s;
        }
    }
    public static boolean isValidHexCode(String s){
            return s.length() == 7 && s.matches("^#[0-9a-fA-F]*$");
    }
    public static boolean same(int[] a, int[] b){
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        for (int i = 0; i < a.length; i++){
            first.add(a[i]);
        }
        for (int i = 0; i < b.length; i++){
            second.add(b[i]);
        }
        return first.size() == second.size();
    }
    public static boolean isKaprekar(int n){
        int temp = n*n;
        int size = 0;
        while (temp != 0) {
            size++;
            temp /= 10;
        }
        temp = n*n;
        int left, right;
        int tmp_size = (size+1)/2;
        if (tmp_size == 0){
            return temp == n;
        }
        right = (int) (temp%Math.pow(10, tmp_size));
        left = (int) (temp/Math.pow(10, tmp_size));
        return left+right == n;
    }
    public static String longestZero(String s){
        String new_s = "";
        int k = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                k++;
                if (k - 1 == new_s.length()){
                    new_s += '0';
                }
            }
            else if (s.charAt(i) == '1'){
                k = 0;
            }
        }
        return new_s;
    }
    public static int nextPrime(int n){
        int[] a = new int[2*n];
        int size = a.length;
        for (int i = 0; i < size; i++){
            a[i] = i;
        }
        for (int i = 2; i < size; i++){
            if (a[i] != 0){
                for (int j = 2*i; j < size; j+=i){
                    a[j] = 0;
                }
            }
        }
        for (int i = 0; i <= n; i++){
            if (i == n && a[i] != 0){
                return n;
            }
        }
        for (int i = n+1; i < size; i++){
            if (a[i] != 0){
                return i;
            }
        }
        return 0;
    }
    public static boolean rightTriangle(int x, int y, int z){
        int max = Math.max(x, Math.max(y, z)), min = Math.min(x, Math.min(y, z));
        return Math.pow(max, 2) == Math.pow(min, 2) + Math.pow(x + y + z - max - min , 2);
    }
}
