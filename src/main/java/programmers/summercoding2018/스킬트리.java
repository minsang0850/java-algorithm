package programmers.summercoding2018;

import java.util.HashSet;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree: skill_trees){
            var idx = 0;
            var set = new HashSet<Character>();
            for (int i=0; i<skill.length(); i++){
                set.add(skill.charAt(i));
            }
            var flag=true;
            for (int i=0; i<skillTree.length(); i++){
                if(set.contains(skillTree.charAt(i))){
                    if(skillTree.charAt(i) == skill.charAt(idx)) {
                        idx++;
                        continue;
                    } else {
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}
