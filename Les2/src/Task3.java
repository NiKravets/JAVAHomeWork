import java.util.Scanner;

/*Напишите метод, который принимает на вход строку (String)
и определяет является ли строка палиндромом (возвращает boolean значение).*/
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число или слово: ");
        String s = sc.nextLine();
        String punct = "[\\p{Punct}]|[\\s]";
        s = s.replaceAll(punct,"").toLowerCase();
        System.out.println(s);
        System.out.println(isPalindrome(s));


    }
    public static boolean isPalindrome(String s){
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if (s.charAt(i) != s.charAt(length-i-1)){
                return false;
            }
        }
        return true;


    }
}
