import java.math.BigInteger;


// -------------------------------------------------------------------------
/**
 *  This checks all numbers up to 2500 to see if each number is a Mersenne prime
 *  number by checking to see if it is both prime and a Mersenne number
 *
 *  @author Meredith McGlynn
 *  @version Apr 5, 2013
 */
public class LucasLehemer
{

    // ----------------------------------------------------------
    /**
     * This method takes the outputs for both isPrime and isMersenne to see
     * if p is a Mersenne prime, and prints out the results
     * @param args
     */

    public static void main(String[] args)
    {
        int upb;
        upb = 2500;

        System.out.print("The Mersenne primes are: ");
        System.out.println();
        for (int p = 3; p <= upb; p += 2)
        {
            //This sees if p is both a prime and if M sub p is a prime as well

            if (isPrime(p) && isMersenne(p))
            {
                System.out.print(" M" + p + ", p = " + p);
                System.out.println();
            }
            if (p == 61)
            {    System.out.println("For p = 61, the result for isPrime is " +
            isPrime(61) + " and the result for isMersenne is " + isMersenne(61));
            System.out.println();
            }
            if (p == 67)
            {
                System.out.println("For p = 67, the result for isPrime is " +
            isPrime(67) + " and the result for isMersenne is " + isMersenne(67));
                System.out.println();
            }

        }

    }

    // ----------------------------------------------------------
    /**
     * This method checks if the number p is prime
     * @param p
     * @return true or false depending on the result
     */
    public static boolean isPrime(int p)
    {
        if (p == 2)
            return true;
        //if p is 1 or less than 1, it is not a prime. If p mod 2 is 0, then
        //p is even and therefore not a prime number
        else if (p <= 1 || p % 2 == 0)
            return false;
        else {
  //this uses the sieve of Sieve of Eratosthenes to find if p is a prime number
            int to = (int)Math.sqrt(p);
            for (int i = 3; i <= to; i += 2)
                if (p % i == 0)
                    return false;
            return true;
        }
    }

    // ----------------------------------------------------------
    /**
     * This tests to see if the Mersenne number is prime
     * @param p the number being tests
     * @return true or false depending on the result
     */
    public static boolean isMersenne(int p)
    {
        //2 is a prime number
        if (p == 2)
        {
            return true;
        }
        else
        {
            //This creates 2 to the pth power - 1
            BigInteger m_p = BigInteger.ONE.shiftLeft(p).subtract(BigInteger.ONE);
            BigInteger s = BigInteger.valueOf(4);
            //The Lucas-Lehmer test described on p. 260
            for (int i = 3; i <= p; i++)
                s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(m_p);
            //the answer to this return is true if 0 or else false
            return s.equals(BigInteger.ZERO);
        }
    }




}
