public class permutationStr {
    public static boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];

        for(int i=0; i<s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++; // a -> 0, b -> 1
        }

        int windSize = s1.length();

        for(int i=0; i<s2.length(); i++) {
            int windIdx = 0, idx = i;
            int windFreq[] = new int[26];

            while (windIdx < windSize && idx < s2.length()) {
                windFreq[s2.charAt(idx) - 'a'] ++;
                windIdx++; idx++;
            }

            if(isFreqSame(freq, windFreq)) { //found
                return true;
            }
        }

        return false;

    }

    static boolean isFreqSame(int freq1[], int freq2[]) { //O(1)
        for(int i=0; i<26; i++) {
            if(freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
