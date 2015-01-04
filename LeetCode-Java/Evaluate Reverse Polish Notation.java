public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> tokenStack = new Stack<Integer>();
        for(int i = 0;i < tokens.length; i ++)
        {
            if(!isOperator(tokens[i])) 
                tokenStack.push(Integer.valueOf(tokens[i]));
            else
            {
                String operator = tokens[i];
                int right = tokenStack.pop();
                int left = tokenStack.pop();
                int result = compute(operator,left,right);
                tokenStack.push(result);
            }
        }
        return tokenStack.pop();
    }
    
    boolean isOperator(String c)
    {
        if( c.compareTo("+") == 0 
            || c.compareTo("-") == 0 
            || c.compareTo("*") == 0 
            || c.compareTo("/") == 0)
            return true;
        else
            return false;
    }
    
    int compute(String c, int left, int right)
    {
        int result = 0;
        if(c.compareTo("+") == 0 )
        {
            result = left + right;
        }
        else if(c.compareTo("-") == 0 )
        {
            result = left - right;
        }
        else if(c.compareTo("*") == 0 )
        {
            result = left * right;
        }
        else
        {
            result = left / right;
        }
        return result;
    }
}