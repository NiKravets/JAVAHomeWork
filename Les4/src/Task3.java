import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.lang.Character.isDigit;

/*В калькулятор добавьте возможность отменить последнюю операцию.*/
public class Task3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = "";
        double num1 = getInt();
        runCalc(s,num1);

    }
    public static void runCalc(String s, double num1){
        if(s.equals("stop")) return;
        double num2 = getInt();
        char operation = getOperation();
        double result = calc(num1, num2, operation);
        System.out.println("Введите команду: ");
        s = command(s,num1,result);
        runCalc(s,num1);
    }    

    public static double getInt() {
        System.out.println("Введите число:");
        double num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            LOGGER.log(Level.INFO, "Число " + num);
        } else {
            LOGGER.log(Level.WARNING, "При вводе числа допущена ошибка. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
            LOGGER.log(Level.INFO, "Операция " + operation);
        } else {
            LOGGER.log(Level.WARNING, "Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, double num2, int operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                LOGGER.log(Level.INFO, "Результат операции " + result);
                break;
            case '-':
                result = num1 - num2;
                LOGGER.log(Level.INFO, "Результат операции " + result);
                break;
            case '*':
                result = num1 * num2;
                LOGGER.log(Level.INFO, "Результат операции " + result);
                break;
            case '/':
                result = num1 / num2;
                LOGGER.log(Level.INFO, "Результат операции " + result);
                break;
            default:
                LOGGER.log(Level.WARNING, "Операция не известна. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }

    public static String command(String s, double num1, double result){
        s = scanner.next();
        switch (s) {
            case "continue":
                num1 = result;
                System.out.println("Следующая операция\n" +
                        "первое число " + num1);
                break;
            case "cancel":
                System.out.println("Отмена операции\n" +
                        "первое число " + num1);
                break;
            case "stop":
                break;
            default:
                System.out.println("Команда не известна. Повторите ввод.");
                command(s, num1, result);
        }
        return s;
    }

    static Logger LOGGER;
    static {
        try (FileInputStream ins = new FileInputStream("C:\\Users\\Marshaque\\IdeaProjects\\JAVAHomeWork\\out\\log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Task3.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
}

