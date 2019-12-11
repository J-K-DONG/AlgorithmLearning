package datastructures;

public class Calculate {

    public static int abs(int x){
        if (x < 0){
            return -x;
        }else {
            return x;
        }
    }

    public static double abs(double x){
        if (x < 0.0){
            return -x;
        }else {
            return x;
        }
    }


    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

// 牛顿迭代法取平方根
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (abs(t - c / t) > err * t){
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    public static double hypotenuse(double a, double b) {
        return sqrt(a * a + b * b);
    }


    public static void main(String[] args){
//        System.out.println("123");
        double x = sqrt(101);
        System.out.println(x);
        System.out.println(Math.sqrt(101));
    }
}
