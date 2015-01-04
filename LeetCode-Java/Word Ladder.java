public class Solution {
    
    List<String> getNext(String curString, Set<String> dict)
    {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder strBuilder = new StringBuilder(curString);
        for(int j = 0;j < curString.length();j ++)
        {
            for(int k = 0;k < 26;k ++)
            {
                char c = (char)((int)'a' + k);
                if(c == curString.charAt(j)) continue;
                strBuilder.setCharAt(j, c);
                String tempString = strBuilder.toString();
                if(dict.contains(tempString))
                    result.add(tempString);
            }
            strBuilder.setCharAt(j, curString.charAt(j));
        }
        return result;
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(start);
        dict.add(end);
        HashMap<String,Integer> startDistance = new HashMap<String,Integer>();
        startDistance.put(start, 0);
        HashMap<String,Integer> endDistance = new HashMap<String,Integer>();
        endDistance.put(end, 0);
        LinkedList<String> startList = new LinkedList<String>();
        startList.addLast(start);
        LinkedList<String> endList = new LinkedList<String>();
        endList.addLast(end);
        int startCount = 1, endCount = 1;
        int distance = 0;
        while(startCount != 0 && endCount != 0)
        {
            distance ++;
            int newStartCount = 0;
            while(startCount > 0)
            {
                startCount --;
                String s = startList.pollFirst();
                List<String> tempList = getNext(s, dict);
                for(String next: tempList)
                {
                    if(startDistance.containsKey(next))
                        continue;
                    startDistance.put(next, distance);
                    newStartCount ++;
                    startList.addLast(next);
                    if(endDistance.containsKey(next))
                        return distance + endDistance.get(next) + 1;
                }
            }
            startCount = newStartCount;
            
            int newEndCount = 0;
            while(endCount > 0)
            {
                endCount --;
                String s = endList.pollFirst();
                List<String> tempList = getNext(s, dict);
                for(String next: tempList)
                {
                    if(endDistance.containsKey(next))
                        continue;
                    endDistance.put(next, distance);
                    newEndCount ++;
                    endList.addLast(next);
                    if(startDistance.containsKey(next))
                        return distance + startDistance.get(next) + 1;
                }
            }
            endCount = newEndCount;
        }
        return 0;
    }
}