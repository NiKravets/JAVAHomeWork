import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/*К калькулятору из предыдущего дз добавить логирование.*/

public class Test4 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double num1 = getInt();
        LOGGER.log(Level.INFO,"Первое число " + num1);
        double num2 = getInt();
        LOGGER.log(Level.INFO,"Второе число " + num2);
        char operation = getOperation();
        LOGGER.log(Level.INFO,"Операция " + operation);
        double result = calc(num1,num2,operation);
        LOGGER.log(Level.INFO,"Результат операции " + result);


    }
    public static double getInt() {
        System.out.println("Введите число:");
        double num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            LOGGER.log(Level.WARNING,"При вводе числа допущена ошибка. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            LOGGER.log(Level.WARNING,"Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }
    public static double calc(double num1,double num2, int operation){
        double result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1 * num2;
            case '/':
                result = num1/num2;
                break;
            default:
                LOGGER.log(Level.WARNING,"Операция не известна. Повторите ввод.");
                result = calc(num1,num2,getOperation());

        }
        return result;
    }

    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\Marshaque\\IdeaProjects\\JAVAHomeWork\\out\\log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Test4.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }
}
