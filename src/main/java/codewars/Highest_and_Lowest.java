package codewars;

import java.util.ArrayList;

public class Highest_and_Lowest {
    public static String highAndLow(String numbers) {
        var splitedNumbers = numbers.split(" ");
        var newNumbers = new ArrayList<Integer>();
        for (int i=0; i< splitedNumbers.length; i++){
            newNumbers.add(Integer.parseInt(splitedNumbers[i]));
        }
        var min = newNumbers.get(0);
        var max = newNumbers.get(0);
        for (int i=0; i< newNumbers.size(); i++) {
            if(max<newNumbers.get(i)){
                max = newNumbers.get(i);
            }
            if(min>newNumbers.get(i)){
                min = newNumbers.get(i);
            }
        }
        return max + " " + min;
    }
}
