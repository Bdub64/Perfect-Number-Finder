public class PrimeFinder {
    private static int lastPrime = 0;
  
    public static int getCurPrime(){return lastPrime;}
    public static void setCurPrime(int lp){lastPrime = lp;}
    
    public static int getNextPrime(){
        int iter;
      for(iter = lastPrime + 1; !isPrime(iter); iter++){}
      lastPrime = iter;
      return iter;
    }
  
    public static boolean isPrime(long n) {
      // Corner case
      if( n == 2 || n == 3){return true;}
      
      if (n <= 1 ||n % 2 == 0 || n % 3 == 0) {return false;}
  
      for (int i = 5; i <= Math.sqrt(n); i = i + 6){
        if (n % i == 0 || n % (i + 2) == 0){return false;}}
  
      return true;
    }
  }