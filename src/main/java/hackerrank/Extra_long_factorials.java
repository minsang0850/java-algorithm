package hackerrank;

import java.math.BigInteger;

public class Extra_long_factorials {
    public static void extraLongFactorials(int n) {
        getFactorial(n);
        System.out.println(getFactorial(n));
    }

    public static BigInteger getFactorial(int n) {
        BigInteger result=new BigInteger("1");;
        for(int i=1; i<=n; i++){
            result= result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}

