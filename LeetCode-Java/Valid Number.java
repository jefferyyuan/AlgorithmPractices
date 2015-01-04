public class Solution {
    public boolean isNumber(String s) {
        // state 
        // -1 : invalid state
        // 0: initial with 0 or more ' '
        // 1: 0 or more ' ' + sign
        // 2: number only
        // 3: number + '.' + 0 or more number
        // 4: '.'
        // 5: valid number + 'E'/'e'
        // 6: valid number + 'E'/'e' + sign
        // 7: valid number + 'E'/'e' + valid number
        // 8: valid number + 1 or more ' '
        
        // input
        // 0: ' '
        // 1: sign
        // 2: number
        // 3: 'e'/'E'
        // 4: '.'
        // 5: invalid input
        int[][] automa = 
        {
          { 0, 1, 2, -1, 4, -1},
          { -1, -1, 2, -1, 4, -1},
          { 8, -1, 2, 5, 3, -1},
          { 8, -1, 3, 5, -1, -1},
          { -1, -1, 3, -1, -1, -1},
          { -1, 6, 7,  -1, -1, -1},
          { -1, -1, 7, -1, -1, -1},
          { 8, -1, 7, -1, -1, -1},
          { 8, -1, -1, -1, -1, -1}
        };
        
        int state = 0;
        for(int i = 0;i < s.length();i ++)
        {
            int transit = getInputType(s.charAt(i));
            state = automa[state][transit];
            if(state == -1)
                break;
        }
        if(state == 2 || state == 3 || state == 7 || state == 8)
            return true;
        else
            return false;
    }
    
    int getInputType(char c)
    {
        if(c == ' ')
            return 0;
        else if(c == '+' || c == '-')
            return 1;
        else if(c >= '0' && c <= '9')
            return 2;
        else if(c == 'e' || c == 'E')
            return 3;
        else if(c == '.')
            return 4;
        else
            return 5;
    }
}