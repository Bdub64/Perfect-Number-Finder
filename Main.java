import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Would you like to scan(1) or calculate(2) for correct perfects?\n");
    int inp = Integer.parseInt(sc.nextLine());
    if(inp == 2){
        File logFile = new File(LocalDate.now() + "perfectCalc.txt");
        FileWriter log = new FileWriter(logFile);
        int i = PrimeFinder.getNextPrime();
        while (i < 10000) {
            log.write(String.valueOf(Math.pow(2, i - 1) * (Math.pow(2, i) - 1)) + "\n");
            i = PrimeFinder.getNextPrime();
        }        
        log.close();
    } else if(inp == 1){
        Scanner sc2 = new Scanner(LocalDate.now() + "perfectCalc.txt");
        float n = sc2.nextFloat();
        File logFile = new File(LocalDate.now() + "perfectVerify.txt");
        FileWriter log = new FileWriter(logFile);
        while(n != 0){
            HashSet<Float> factors = new HashSet<>();
            int step = n%2 == 0 ? 1 : 2;
            for(float i = 1; i <= Math.sqrt(n); i += step){
                if(n % i == 0){
                    factors.add(i);
                    factors.add(n/i);
                }
            }
            int sum = 0;
            factors.remove(n);
            for (float integer : factors) {
                sum += integer;
            }
            log.write((sum == n) + " " + sum + "\n");
            factors.clear();
            n = sc2.nextLong();
        }
        sc2.close();
        log.close();
    }
    sc.close();
  }
}