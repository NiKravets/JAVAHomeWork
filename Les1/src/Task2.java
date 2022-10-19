import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Вывести все простые числа от 1 до 1000*/
public class Task2 {
    public static void main(String[] args) {
        long time = System.nanoTime();
        List<Integer> pr = getAllPrimes(1000);
        System.out.println(pr);
        time = System.nanoTime() - time;
        System.out.printf("Time %,9.3f ms\n", time/1_000_000.0);
    }
    /*Поиск простых чисел через Решето Эратосфена*/
    public static List<Integer> getAllPrimes(int sieveSize){
        var sieve = new boolean[sieveSize];
        Arrays.fill(sieve,true);
        sieve[0] =false;
        sieve[1]= false;

        for (int i = 2; i*i < sieve.length; i++) {
            if(sieve[i]){
                for (int j = i * i; j < sieveSize; j += i) {
                    sieve[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < sieve.length; i++) {
            if(sieve[i]){
                primes.add(i);
            }
        }
        return primes;
    }
}
