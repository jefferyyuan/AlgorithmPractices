public boolean isValid(String s) {
    HashMap<Character, Character> record = new HashMap<Character, Character>();
    record.put(')', '(');
    record.put(']', '[');
    record.put('}', '{');
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(!record.containsKey(c))
            stack.push(c);
        else{
            if(stack.empty() || stack.pop() != record.get(c))
                return false;
        }
    }
    return stack.empty();
}