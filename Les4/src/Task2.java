import java.util.LinkedList;
import java.util.Scanner;

/*Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди,
        dequeue() - возвращает первый элемент из очереди и удаляет его,
        first() - возвращает первый элемент из очереди, не удаляя.*/
public class Task2 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String s = "";
        System.out.println("Команда 1 добавить элемент в очередь\n" +
                "Команда 2 удалить и показать первый элемент из очереди\n" +
                "Команда 3 показать первый элемент очереди\n" +
                "Команда stop заканчивает программу\n");

        while (true){
            System.out.println("Введите команду: ");
            s = scanner.next();
            if (s.equals("1")) {
                System.out.println("Введите элемент: ");
                int n = scanner.nextInt();
                enqueue(ll,n);
            }
            if(s.equals("2")){
                dequeue(ll);
            }
            if (s.equals("3")){
                first(ll);
            }
            if (s.equals("stop")) break;
            else System.out.println(ll);
        }
    }
    public static void enqueue(LinkedList<Integer> input, int n){
        input.add(0,n);
    }
    public static void dequeue(LinkedList<Integer> input){
        System.out.println(input.removeLast());
    }
    public static void first(LinkedList<Integer> input){
        System.out.println(input.getLast());
    }
}
