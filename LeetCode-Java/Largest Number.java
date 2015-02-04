public class Solution {
    public String largestNumber(int[] num) {
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i < num.length; i++){
    		list.add(num[i]);
    	}
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                String o1 = v1.toString() + v2.toString();
                String o2 = v2.toString() + v1.toString();
                return o1.compareTo(o2);
            }
        });
        StringBuffer result = new StringBuffer();
        for(int i = list.size() - 1; i >= 0; i--){
            result.append(list.get(i));
        }
        String tempResult = result.toString();
        int index = 0;
        while(index < tempResult.length() && tempResult.charAt(index) == '0')
            index ++;
        if(index == tempResult.length())
            return "0";
        else
            return tempResult.substring(index);
    }
}