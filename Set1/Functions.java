
public class Functions {
    public int ceil(double x) {
        int y = (int) x;
        if (x == y) {
            return y;
        }
        return y + 1;
    }

    public int floor(double x) {
        int y = (int) x;
        if (x < y) {
            return y - 1;
        }
        return y;
    }

    public int modulo(int a, int b) {
        return a - (a / b) * b;
    }

    public int[] erastosthenes(int k) {
        int[] primes = new int[k];
        int primecount = 0;
        int i = 2;
        boolean isprime;

        while (primecount < k) {
            isprime = true;
            for (int x : primes) {
                if (x == 0) {
                    break;
                }
                if (modulo(i, x) == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) {
                primes[primecount] = i;
                primecount++;
            }
            i++;
        }
        return primes;
    }
}
