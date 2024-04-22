package programmers.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.math.*;
import java.util.Set;

public class 소수_찾기 {
//    public int solution(String numbers) {
//        int answer = 0;
//        var list = new ArrayList<String>();
//        for(int i=0; i<numbers.length(); i++){
//            list.add(String.valueOf(numbers.charAt(i)));
//        }
//        for(int a=0; a<numbers.length(); a++){
//            var flags = new boolean[numbers.length()];
//            var check = new ArrayList<String>();
//            check.add(list.get(a));
//            for(int b=0; b<numbers.length(); b++){
//                if(a==b){
//                    if(isPrime(check)){
//                        answer++;
//                    }
//                }
//                for(int c=0; c<numbers.length(); c++){
//                    for(int d=0; d<numbers.length(); d++){
//                        for(int e=0; e<numbers.length(); e++){
//                            for(int f=0; f<numbers.length(); f++){
//                                for(int g=0; g<numbers.length(); g++){
//
//                                }
//                            }
//                        }
//                    }
//                }
//                if(isPrime(check)) {
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }
//
//    public boolean isPrime(List<String> numbers){
//        var sb = new StringBuffer();
//        for (int i=0; i<numbers.size(); i++){
//            sb.append(numbers.get(i));
//        }
//        var num = Integer.parseInt(sb.toString());
//        return isPrime(num);
//    }
//
//    private boolean isPrime(int num) {
//        for(int i=2; i<=Math.sqrt(num); i++) {
//            if(num%i==0){
//                return false;
//            }
//        }
//        return true;
//    }
    public static void main(String[] args) {
        var p = new 소수_찾기();
        p.solution("1234567");
    }
    public int solution(String numbers) {
        Set<Integer> permutations = new HashSet<>();
        permute(numbers, "", permutations);

        Set<Integer> primes = new HashSet<>();
        for (int number : permutations) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }

        return primes.size();
    }

    private void permute(String str, String prefix, Set<Integer> permutations) {
        if (!prefix.isEmpty()) {
            permutations.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < str.length(); i++) {
            permute(str.substring(0,i) + str.substring(i+1, str.length()), prefix + str.charAt(i), permutations);
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
