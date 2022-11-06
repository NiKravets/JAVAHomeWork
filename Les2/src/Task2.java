import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/*Дана json строка(сохранить в файл и читать из файла):
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова", "оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
        Студент [фамилия] получил [оценка] по предмету [предмет].
        Пример вывода:
        Студент Иванов получил 5 по предмету Математика.
        Студент Петрова получил 4 по предмету Информатика.
        Студент Краснов получил 5 по предмету Физика.*/
public class Task2 {
    public static void main(String[] args) {

        JSONObject object1 = new JSONObject();
        object1.put("фимилия","Иванов");
        object1.put("оценка","5");
        object1.put("предмет","Математика");
        JSONObject object2 = new JSONObject();
        object2.put("фимилия","Петрова");
        object2.put("оценка","4");
        object2.put("предмет","Информатика");
        JSONObject object3 = new JSONObject();
        object3.put("фимилия","Краснов");
        object3.put("оценка","5");
        object3.put("предмет","Физика");
        JSONArray listMain = new JSONArray();
        listMain.add(object1);
        listMain.add(object2);
        listMain.add(object3);

        try (FileWriter file = new FileWriter("school.json")){
            file.write((listMain.toJSONString()));
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("school.json"));
            JSONArray listMainRead = (JSONArray) obj;
            System.out.println(listMainRead);
            StringBuilder sb = new StringBuilder();
            listMainRead.forEach( emp -> parseListMain( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseListMain(JSONObject object){
        String name = (String) object.get("фимилия");
        String grade = (String) object.get("оценка");
        String subject = (String) object.get("предмет");
        System.out.printf("Студент %s получил %s по предмету %s .\n",name,grade,subject);
    }

}
