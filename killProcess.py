class Solution(object):
    def killProcess(self, pid, ppid, kill):
        """
        :type pid: List[int]
        :type ppid: List[int]
        :type kill: int
        :rtype: List[int]
        """
        n = len(pid)
        adjlst = {}
        
        for i in xrange(n):
            if adjlst.has_key(ppid[i]):
                adjlst[ppid[i]].append(i)
            else:
                adjlst[ppid[i]] = [i]
        result = [kill]
        
        def dfs(x):
            if not adjlst.has_key(x):
                return
            for i in adjlst[x]:
                temp = pid[i]
                result.append(temp)
                dfs(temp)
        
        dfs(kill)
        return result