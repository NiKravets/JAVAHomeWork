import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/* Пусть дан произвольный список целых чисел, удалить из него четные числа*/
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        System.out.println("Введите диапазон чисел: ");
        int n = scanner.nextInt();
        List<Integer> s = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            s.add(i, (int) (Math.random() * 2*n - n ));
        }
        System.out.println(s);
        oddList(s);
    }
    public static void oddList(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2 == 0){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}
