import java.util.*;
;

/*Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени.*/
public class Task2 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>(Arrays.asList("Иван Иванов",
                "Светлана Петрова","Кристина Белова","Анна Мусина","Анна Крутова",
                "Иван Юрин","Петр Лыков","Павел Чернов","Петр Чернышов","Мария Федорова",
                "Марина Светлова","Мария Савина","Мария Рыкова","Марина Лугова","Анна Владимирова",
                "Иван Мечников","Петр Петин","Иван Ежов"));

        sortedNames(employees);
    }

    public static void sortedNames(List<String> input){
        Map<String,Integer> names =new HashMap<>();
        int count= 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                if (input.get(i).split(" ")[0].equals(input.get(j).split(" ")[0])) {
                    count++;
                }
            }
            names.putIfAbsent(input.get(i).split(" ")[0], count);
            count = 0;
        }
        names.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
