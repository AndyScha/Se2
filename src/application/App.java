package application;

import java.util.ArrayList;
import java.util.List;

/**
 * Main application class.
 *
 */
public class App {

    /**
     * Default constructor.
     */
    public App() {
    }

    /**
     * main() function.
     *
     * @param args command line arguments passed to <i>main()</i>.
     */
    public static void main(String[] args) {
        int n = 36;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
                return;
            }
        }
        try {
            var app = new App();
            var factors = app.factorize(n);
            System.out.println("Hello, App!");
            System.out.println(String.format("n=%d factorized is: %s", n, factors.toString()));
            //
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Factorize a number into smallest prime factors.
     * <p>
     * Examples:
     * <pre>
     * n=27 -> [3, 3, 3]
     * n=1092 -> [2, 2, 3, 7, 13]
     * n=10952347 -> [7, 23, 59, 1153]
     * </pre>
     *
     * @param n number to factorize
     * @return list of factors
     * @throws IllegalArgumentException if n is negative
     */
    public List<Integer> factorize(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("illegal negative parameter: " + n);
        }

        List<Integer> factors = new ArrayList<>();

        if (n == 0) {
            factors.add(0);
            return factors;
        }

        if (n == 1) {
            factors.add(1);
            return factors;
        }

        // Check for the smallest prime factor (2) and divide n by 2 until it's no longer divisible by 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Check for the rest of the prime factors, starting with 3
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If there is a remaining prime factor greater than 2, add it to the list
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}