import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> filtor = new TreeMap<>(Map.of( ));
        List<Notebook> notebookArrayList = new ArrayList<>(List.of(new Notebook(58999, 4.24, "HUAWEI", "mateBookD15BoMWFQ9", 15.6, 16, 512, "windows 10", 4),
                new Notebook(94799, 4.75, "MSI", "katana11UE269XRU", 17.3, 16, 512, "windows 10", 6),
                new Notebook(71999, 4.54, "HUAWEI", "mateBookD16RLEFX", 16, 16, 512, "Windows 11", 6),
                new Notebook(63499, 3.74, "MSI", "katana11SC483XRU", 17.3, 8, 256, "без ОС", 4),
                new Notebook(74999, 4.03, "GIGABYTE", "g5ge", 15.6, 16, 512, "без ОС", 4),
                new Notebook(127899, 4.56, "AORUS", "xe415", 15.6, 16, 1000, "без ОС", 8),
                new Notebook(162999, 4.62, "MSI", "vectorGP76", 17.3, 16, 1000, "windows 11", 8),
                new Notebook(82799, 3.97, "Apple", "macBookAir", 13.3, 8, 256, "macOS", 4),
                new Notebook(50599, 4.25, "Lenovo", "v15G2ALC", 15.6, 8, 512, "без ОС", 4),
                new Notebook(64399, 4.64, "Acer", "aspire7A715", 15.6, 8, 256, "windows 10", 4),
                new Notebook(78199, 4.44, "ASUS", "tUFDashF15", 15.6, 8, 512, "Linux", 4),
                new Notebook(30349, 4.16, "HP", "g8", 15.6, 4, 128, "windows 10", 2),
                new Notebook(87399, 4.42, "HP", "victus16", 16.1, 16, 512, "без ОС", 4),
                new Notebook(216999, 3.86, "MSI", "mcreatorZ16P", 16, 32, 1000, "windows 11", 8)));


        for (Notebook n : notebookArrayList) {
            System.out.println(n);
        }
        String act;

        System.out.println("выбор действия: (add)добавить фильтр, (del)удалить фильтр, (price) сортировать по цене, (rating)сортировать по рейтингу, " +
                "(save)вывести модели по фильтрам, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while (!act.equals("exit")) {
            //добавление фильтра
            if (act.equals("add")) {
                System.out.println("Введите цифру, соответствующую необходимому критерию: \n" +
                        "1 - Цена\n" +
                        "2 - Компания\n" +
                        "3 - Диагональ экрана\n" +
                        "4 - ОЗУ\n" +
                        "5 - Объем ЖД\n" +
                        "6 - Операционная система\n" +
                        "7 - Объем видеопамяти\n" +
                        "8 - вернуться назад");

                String name = bf.readLine();
                if (name.equals("8")) {
                    System.out.println("выбор действия: (add)добавить фильтр, (del)удалить фильтр, (price) сортировать по цене, (rating)сортировать по рейтингу, " +
                            "(filter)вывести модели по фильтрам, (exit)выход");
                    act = bf.readLine();
                } else {
                    System.out.println("Введите значение:");
                    String value = bf.readLine();
                    filtor.put(name, value);
                    System.out.println(filtor);
                }
            } else {
                //удаление фильтра
                if (act.equals("del")) {
                    System.out.println("Введите цифру, соответствующую необходимому критерию: \n" +
                            "1 - Цена\n" +
                            "2 - Компания\n" +
                            "3 - Диагональ экрана\n" +
                            "4 - ОЗУ\n" +
                            "5 - Объем ЖД\n" +
                            "6 - Операционная система\n" +
                            "7 - Объем видеопамяти\n" +
                            "8 - вернуться назад");
                    String name = bf.readLine();
                    if (name.equals("8")) {
                        System.out.println("выбор действия: (add)добавить фильтр, (del)удалить фильтр, (price) сортировать по цене, (rating)сортировать по рейтингу, " +
                                "(filter)вывести модели по фильтрам, (exit)выход");
                    } else {
                        filtor.remove(name);
                        System.out.println(filtor);
                    }
                } else {
                    //сортировать по цене
                    if (act.equals("price")) {
                        notebookArrayList.sort(new PriceComparator());
                        for (Notebook n : notebookArrayList) System.out.println(n);
                    } else {
                        //сортировать по рейтингу
                        if (act.equals("rating")) {
                            notebookArrayList.sort(new RatingComparator());
                            for (Notebook n : notebookArrayList) System.out.println(n);
                        } else {
                            //вывод списка по фильтрам
                            if (act.equals("filter")) {
                                notebookArrayList = notebookArrayList.stream().filter(notebook
                                        -> notebook.getPrice() > Integer.parseInt(filtor.get("1")) &&
                                        notebook.getCompany().equals(filtor.get("2")) &&
                                        notebook.getScreenDiagonal() > Double.parseDouble(filtor.get("3")) &&
                                        notebook.getRam() > Integer.parseInt(filtor.get("4")) &&
                                        notebook.getHardDiskCapacity() > Integer.parseInt(filtor.get("5")) &&
                                        notebook.getOperatingSystem().equals(filtor.get("6")) &&
                                        notebook.getVideoMemory() > Integer.parseInt(filtor.get("7"))).collect(Collectors.toList());
                                for (Notebook n : notebookArrayList) System.out.println(n);

                            }
                        }
                    }
                }
                //запрос на следующее действие
                System.out.println("выбор действия: (add)добавить фильтр, (del)удалить фильтр, (price) сортировать по цене, (rating)сортировать по рейтингу, " +
                        "(save)вывести модели по фильтрам, (exit)выход");
                act = bf.readLine();
            }
        }
    }
}
