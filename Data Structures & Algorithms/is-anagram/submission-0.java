class Solution {
    public boolean isAnagram(String s, String t) {

        char[] freq = new char[26];

        char[] sChar = s.toCharArray();

        for(int i = 0; i < sChar.length; i++){

            freq[sChar[i] - 'a']++;

        }

        char[] tChar = t.toCharArray();


        for(int i = 0; i < tChar.length; i++){

            freq[tChar[i] - 'a']--;

        }

        for(int i = 0; i < freq.length; i++){

            if(freq[i] != 0) return false;

        }

        return true;

    }
}
