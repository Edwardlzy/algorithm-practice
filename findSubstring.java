public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || words == null || words.length == 0) return result;
        int len = words[0].length();
        
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (String item : words) hm.put(item, hm.containsKey(item) ? hm.get(item) + 1 : 1);
        
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> temp = new HashMap<String, Integer>(hm);
            for (int j = 0; j < words.length; j++) {
                String sub = s.substring(i + j * len, i + j * len + len);
                if (temp.containsKey(sub)) {
                    int count = temp.get(sub);
                    if (count == 1) temp.remove(sub);
                    else temp.put(sub, count - 1);
                    if (temp.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else break;
            }
        }
        return result;
    }
}