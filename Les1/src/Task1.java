import java.util.Scanner;

/*Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)*/
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите n: ");
        int n = sc.nextInt();
        triangular(n);
    }
    static void triangular(int n){
        int T;
        T = n*(n+1)/2;
        System.out.println(T);
    }
}