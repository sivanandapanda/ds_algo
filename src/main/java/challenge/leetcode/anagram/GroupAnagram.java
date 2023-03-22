package challenge.leetcode.anagram;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/submissions/
 * leetcode 49
 */
public class GroupAnagram {

    //time complexity = (number of items * time taken for sorting) = O(m*nlogn)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {

            char[] c = word.toCharArray();
            Arrays.sort(c);
            String hash = new String(c);
            if (map.containsKey(hash)) {
                map.get(hash).add(word);
            } else {
                List<String> l = new ArrayList<>();
                l.add(word);
                map.put(hash, l);
            }
        }

        return new ArrayList<>(map.values());
    }

    //time complexity = (number of items * avg length of strings) = O(m*n)
    public List<List<String>> groupAnagrams_2(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            int[] chars = new int[26];

            for (Character aChar : s.toCharArray()) {
                int indexOfChar = aChar - 'a';
                chars[indexOfChar] = chars[indexOfChar] + 1;
            }

            String key = Arrays.toString(chars);

            if (result.containsKey(key)) {
                List<String> anagram = result.get(key);
                anagram.add(s);
            } else {
                var anagrams = new ArrayList<String>();
                anagrams.add(s);
                result.put(key, anagrams);
            }
        }

        return result.values().stream().toList();
    }

    //over engineered
    /*public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return new ArrayList<>();
        if (strs.length == 1) return List.of(List.of(strs[0]));

        //return simpleIterative(strs);

        return tryDivideAndConcur(strs, 0, strs.length-1);
    }

    private ArrayList<List<String>> simpleIterative(String[] strs) {
        var groups = new ArrayList<List<String>>();

        for (String str : strs) {
            checkAndAdd(groups, str);
        }

        return groups;
    }

    private List<List<String>> tryDivideAndConcur(String[] strs, int startIndex, int endIndex) {
        if (startIndex > endIndex) return new ArrayList<>();

        if ((endIndex - startIndex) == 0) {
            List<List<String>> result = new ArrayList<>();
            var list = new ArrayList<String>();
            list.add(strs[startIndex]);
            result.add(list);
            return result;
        }

        if ((endIndex - startIndex) == 1) {
            List<List<String>> result = new ArrayList<>();

            if (isAnagram(strs[startIndex], strs[endIndex])) {
                var list = new ArrayList<String>();
                list.add(strs[startIndex]);
                list.add(strs[endIndex]);
                result.add(list);
            } else {
                var list1 = new ArrayList<String>();
                list1.add(strs[startIndex]);
                result.add(list1);

                var list2 = new ArrayList<String>();
                list2.add(strs[endIndex]);
                result.add(list2);
            }

            return result;
        }

        int middle = (endIndex + startIndex) / 2;
        List<List<String>> left = tryDivideAndConcur(strs, startIndex, middle);
        List<List<String>> right = tryDivideAndConcur(strs, middle+1, endIndex);

        return mergeTwoLists(left, right);
    }

    private List<List<String>> mergeTwoLists(List<List<String>> list1, List<List<String>> list2) {
        List<List<String>> result = new ArrayList<>(list1);

        for (List<String> list : list2) {
            boolean foundGroup = false;
            for (List<String> resultList : result) {
                if(isAnagram(list.get(0), resultList.get(0))) {
                    resultList.addAll(list);
                    foundGroup = true;
                    break;
                }
            }

            if(!foundGroup) {
                result.add(list);
            }
        }

        return result;
    }

    private void checkAndAdd(List<List<String>> groups, String str) {
        boolean foundGroup = false;

        for (List<String> group : groups) {
            var first = group.get(0);

            if (isAnagram(first, str)) {
                group.add(str);
                foundGroup = true;
                break;
            }
        }

        if (!foundGroup) {
            var list = new ArrayList<String>();
            list.add(str);
            groups.add(list);
        }
    }

    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> s1CharCount = new HashMap<>();
        Map<Character, Integer> s2CharCount = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            var charAt = s1.charAt(i);

            var count = s1CharCount.getOrDefault(charAt, 0);
            s1CharCount.put(charAt, count + 1);

            var s2CharAt = s2.charAt(i);

            var s2Count = s2CharCount.getOrDefault(s2CharAt, 0);
            s2CharCount.put(s2CharAt, s2Count + 1);
        }

        if (s1CharCount.size() != s2CharCount.size()) return false;

        for (Character character : s1CharCount.keySet()) {
            if (!s2CharCount.containsKey(character)) {
                return false;
            }

            if (!Objects.equals(s1CharCount.get(character), s2CharCount.get(character))) {
                return false;
            }
        }

        return true;
    }*/

}
