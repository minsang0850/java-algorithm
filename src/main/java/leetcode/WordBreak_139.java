package leetcode;

import java.util.List;

public class WordBreak_139 {
    Boolean[] dp = new Boolean[301];

    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict, 0);
    }

    private boolean dp(String subStr, List<String> wordDict, int num) {
        if (dp[num] != null) {
            return dp[num];
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (subStr.startsWith(wordDict.get(i))) {
                var flag = dp(subStr.substring(wordDict.get(i).length()), wordDict, num + wordDict.get(i).length());
                if (flag) {
                    dp[num] = true;
                    return true;
                }
            }
        }
        dp[num] = subStr.isEmpty();
        return dp[num];
    }
}
