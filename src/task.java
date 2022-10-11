public class task {
    public static void main(String[] args){
        System.out.println(sumOfCubes(new int[] {1, 2, 3}));
    }
    public static int remainder(int a, int b){return a%b;}
    public static int triArea(int n, int f){return n*f/2;}
    public static int animals(int ch, int c, int p){return ch*2 + c*4 + p*4;}
    public static boolean profitableGamble(double prob, int prize, int pay){return prob*prize > pay;}
    public static String operation(double N, double a, double b){
        if (a + b == N){return "added";}
        else if (a - b == N){return "subtracted";}
        else if (a * b == N){return "multiplaid";}
        else if (a / b == N){return "devided";}
        else{return "None";}
    }
    public static int ctoa(char n){return (int) n;}
    public static int addUpTo(int n){return n*(n + 1)/2;}
    public static int nextEdge(int a, int b){return a + b - 1;}
    public static double sumOfCubes(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += Math.pow(a[i], 3);
        }
        return sum;
    }
    public static boolean abcmath(int a, int b, int c){return (a * Math.pow(2, b))%c == 0;}
}
