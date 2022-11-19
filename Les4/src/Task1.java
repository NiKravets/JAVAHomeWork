import java.util.LinkedList;
import java.util.List;

/*Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/
public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(List.of(3456,37,3586,245,23468,68));
        System.out.println(ll);
        reverse(ll);
    }
    public static void reverse(LinkedList<Integer> input){
        LinkedList<Integer> output = new LinkedList<>();
        for (int i = 0; i < input.size(); i++) {
            output.add(0, input.get(i));
        }
        System.out.println(output);
    }
}
