class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for i in range(len(s)):
            if (s[i] in ['(', '[', '{']):
                stack.append(s[i])
            else:
                if (s[i] == ')'):
                    if (len(stack) > 0 and stack[-1] == '('):
                        stack.pop()
                    else:
                        return False
                elif (s[i] == ']'):
                    if (len(stack) > 0 and stack[-1] == '['):
                        stack.pop()
                    else:
                        return False
                else:
                    if (len(stack) > 0 and stack[-1] == '{'):
                        stack.pop()
                    else:
                        return False
        return len(stack) == 0