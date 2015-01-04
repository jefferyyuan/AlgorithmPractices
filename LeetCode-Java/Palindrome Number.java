// this solution is right, but mostly out of luck
// negative cases?
// overflow cases? I guess it's right, however it's not guarenteed.
public class Solution {
    public boolean isPalindrome(int x) {
        int newX = 0;
        int y = x;
        while(y > 0)
        {
            newX = newX * 10 + y % 10;
            y = y / 10;
        }
        return newX == x;
    }
}