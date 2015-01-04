public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> record = new HashMap<Character, Character>();
        record.put(')', '(');
        record.put('}', '{');
        record.put(']', '[');
        Stack<Character> charStack = new Stack<Character>();
        for(int i = 0;i < s.length();i ++)
        {
            char c = s.charAt(i);
            if((!charStack.empty()) && charStack.peek() == record.get(c))
            {
                charStack.pop();
            }
            else
            {
                charStack.push(c);
            }
        }
        return charStack.empty();
    }
}