import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка*/
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер списка: ");
        int size = scanner.nextInt();
        List<Integer> s = new ArrayList<>(size);
        System.out.println("Заполните список: ");
        for (int i = 0; i < size; i++) {
            s.add(i, scanner.nextInt());
        }
        System.out.println(s);
        minMaxAverage(s);
    }
    public static void minMaxAverage(List<Integer> input){
        int min = input.get(0), max = input.get(0), sum = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            sum = sum + input.get(i);
            if(min > input.get(i)) min = input.get(i);
            if(max < input.get(i)) max = input.get(i);
        }
        System.out.println("Минимальное число в списке " + min );
        System.out.println("Максимальное число в списке " + max );
        System.out.println("среднее ариф. чисел в списке " + ((double) sum/input.size()) );
    }
}
