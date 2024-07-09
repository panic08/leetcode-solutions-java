package longestRepeatingCharacterReplacement;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        int l = 0;

        int longestStreak = 0;

        for (int r = 0; r < sChars.length; r++) {
            if (characterCountMap.containsKey(sChars[r])) {
                characterCountMap.put(sChars[r], characterCountMap.get(sChars[r]) + 1);
            } else {
                characterCountMap.put(sChars[r], 1);
            }

            int windowLength = r - l + 1;
            int charWithMostCount = 0;

            for (int value : characterCountMap.values()) {
                charWithMostCount = Math.max(charWithMostCount, value);
            }

            if (windowLength - charWithMostCount <= k) {
                for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
                    if (entry.getValue() > charWithMostCount) {
                        charWithMostCount = entry.getValue();
                    }
                }
            } else {
                while (windowLength - charWithMostCount > k) {
                    characterCountMap.put(sChars[l], characterCountMap.get(sChars[l]) - 1);

                    for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
                        if (entry.getValue() > charWithMostCount) {
                            charWithMostCount = entry.getValue();
                        }
                    }
                    l++;
                    windowLength = r - l + 1;
                }
            }


            longestStreak = Math.max(longestStreak, windowLength);
        }

        return longestStreak;
    }
}
