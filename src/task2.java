public class task2 {
    public static void main(String[] args){
        System.out.println(repeat("mice", 5));
        System.out.println(differenceMaxMin(new int[] {10, 2, 34, 5, 67}));
        System.out.println(isAvgWhole(new int[] {10, 2, 34, 5, 67}));
        int[] S = cumulativeSum(new int[] {10, 2, 34, 5, 67});
        System.out.println("-----------------");
        for (int i = 0; i < S.length; i++){
            System.out.println(S[i]);
        }
        System.out.println("-----------------");
        System.out.println(getDecimalPlaces("43.56"));
        System.out.println(Fibonacci(7));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("automatic", "auto-"));
        System.out.println(isPostfix("automation", "-mation"));
        System.out.println(step(8));
    }
    public static String repeat(String s, int n){ //вернуть строку где каждый элемент повторяется n раз
        String new_s = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < n; j++){
                new_s += s.charAt(i);
            }
        }
        return new_s;
    }
    public static int differenceMaxMin(int[] mass){ //вернуть разницу макс и мин элементов массивов
        int min = mass[0], max = mass[0];
        for (int i = 1; i < mass.length; i++){
            min = Math.min(min, mass[i]);
            max = Math.max(max, mass[i]);
        }
        return max - min;
    }
    public static boolean isAvgWhole(int[] mass){ //является ли среднее значение всех элементов массива целым числом или нет
        double avg = 0;
        for (int value: mass){
            avg += value;
        }
        avg /= mass.length;
        return avg == (int) avg;
    }
    public static int[] cumulativeSum(int[] mass){//префиксные суммы
        int[] summ = new int[mass.length];
        summ[0] = mass[0];
        for (int i = 1; i < mass.length; i++){
            summ[i] = summ[i - 1] + mass[i];
        }
        return summ;
    }
    public static int getDecimalPlaces(String s){//Создайте функцию, которая возвращает число десятичных знаков
        return s.length() - s.indexOf(".") - 1;
    }
    public static int Fibonacci(int n){
        if (n == 1){return 1;}
        if (n == 0){return 1;}
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static boolean isValid(String s){//index mail
        return s.length() == 5 && s.indexOf(" ") == -1 && s.matches("^[0-9]*$");
    }
    public static boolean isStrangePair(String first, String second){//Пара строк образует странную пару
        return first.charAt(0) == second.charAt(second.length() - 1) && second.charAt(0) == first.charAt(first.length() - 1);
    }
    public static boolean isPrefix(String word, String pref){
        for (int i = 0; i < pref.length()-1; i++){
            if (word.charAt(i) != pref.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPostfix(String word, String post){
        int raz = word.length() - post.length();
        for (int i = post.length() - 1; i > 0; i--){
            if (word.charAt(i + raz) != post.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static int step(int n){
        return n + 2*(n%2);
    }
}
