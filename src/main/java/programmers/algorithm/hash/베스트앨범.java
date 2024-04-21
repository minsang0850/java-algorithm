package programmers.algorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 베스트앨범 {

    public static void main(String[] args) {
        var p = new 베스트앨범();
        var genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        var plays = new int[]{500, 600, 150, 800, 2500};
        var answer = p.solution(genres, plays);
        System.out.println(answer);
    }
    public int[] solution(String[] genres, int[] plays) {
        var answer = new ArrayList<Integer>();
        var genreMap = new HashMap<String, List<Integer[]>>();
        for (int i = 0; i < genres.length; i++) {
            var genre = genres[i];
            var play = plays[i];
            if (genreMap.containsKey(genre)) {
                genreMap.get(genre).add(new Integer[]{i, play});
            } else {
                genreMap.put(genre, new ArrayList<>());
                genreMap.get(genre).add(new Integer[]{i, play});
            }
        }
        var sortedGenres = genreMap.values()
                .stream()
                .sorted((a, b) -> {
                    var aSum = 0;
                    for (Integer[] i : a) {
                        aSum += i[1];
                    }
                    var bSum = 0;
                    for (Integer[] j : b) {
                        bSum += j[1];
                    }
                    if (aSum >= bSum) {
                        return -1;
                    }
                    return 1;
                })
                .collect(Collectors.toList());
        for (List<Integer[]> playsForGenre : sortedGenres) {
            playsForGenre.sort((a,b) -> {
                if(a[1] > b[1]){
                    return -1;
                }
                if(a[1] == b[1]){
                    if(a[0]<b[0]){
                        return -1;
                    }
                }
                return 1;
            });
            if(playsForGenre.size()>=2) {
                answer.add(playsForGenre.get(0)[0]);
                answer.add(playsForGenre.get(1)[0]);
            }
            else if (playsForGenre.size()==1){
                answer.add(playsForGenre.get(0)[0]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
