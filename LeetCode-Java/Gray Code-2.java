/*
 * Using bit operations
 * ref(bit hack): http://graphics.stanford.edu/~seander/bithacks.html
 * ref(single bit operation): http://stackoverflow.com/questions/47981/how-do-you-set-clear-and-toggle-a-single-bit-in-c-c
 * setting a bit: number |= 1 << x;
 * clearing a bit: number &= ~(1 << x);
 * toggling a bit: number ^= 1 << x;
 * checking a bit: bit = number & (1 << x);
 */
public class Solution {
    public List<Integer> grayCode(int n) {
       List<Integer> result = new ArrayList<Integer>();
       int v = 0;
       result.add(v);
       for(int i = 1;i < 1 << n;i ++) 
       {
           v ^= 1 << countRightZeros(i);
           result.add(v);
       }
       return result;
    }
    public static int countRightZeros(int v)
	{
		int c = 32; // c will be the number of zero bits on the right
		v &= -v;
		if ((v) != 0) c--;
		if ((v & 0x0000FFFF) != 0) c -= 16;
		if ((v & 0x00FF00FF) != 0) c -= 8;
		if ((v & 0x0F0F0F0F) != 0) c -= 4;
		if ((v & 0x33333333) != 0) c -= 2;
		if ((v & 0x55555555) != 0) c -= 1;
		return c;
	}
}