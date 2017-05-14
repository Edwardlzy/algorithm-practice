public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int i = 0;
        List<Integer> result = new ArrayList<Integer>();
        result.add(kill);
        
        while (i < ppid.size()) {
            if (ppid.get(i) == kill) {
                if (ppid.contains(pid.get(i))) result.addAll(killProcess(pid, ppid, pid.get(i)));
                else result.add(pid.get(i));
            }
            i++;
        }
        return result;
    }
}