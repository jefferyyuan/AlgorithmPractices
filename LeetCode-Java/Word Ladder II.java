public class Solution {
    
    class WordNode{
        int distance;
        String content;
        List<WordNode> nextList;
        public WordNode(int val, String s)
        {
            distance = val;
            content = s;
            nextList = new ArrayList<WordNode>();
        }
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        dict.add(start);
        dict.add(end);
        
        HashMap<String, WordNode> record = new HashMap<String, WordNode>();
        record.put(start, new WordNode(0, start));
        record.put(end, new WordNode(-1, end));
        
        LinkedList<String> startList = new LinkedList<String>();
        startList.addLast(start);
        
        LinkedList<String> endList = new LinkedList<String>();
        endList.addLast(end);
        
        int startCount = 1, endCount = 1;
        int distance = 0;
        
        while(startCount != 0  && endCount != 0)
        {
            distance ++;
            boolean isEnd = false;
            int newStartCount = 0;
            while(startCount > 0)
            {
                startCount --;
                String s = startList.pollFirst();
                List<String> tempList = getNext(s, dict);
                for(String next: tempList)
                {
                    if(!record.containsKey(next))
                    {
                        WordNode tempNode = new WordNode(distance,next);
                        tempNode.nextList.add(record.get(s));
                        record.put(next,tempNode);
                        startList.addLast(next);
                        newStartCount ++;
                    }
                    else
                    {
                        WordNode tempNode = record.get(next);
                        if(tempNode.distance == distance)
                        {
                            tempNode.nextList.add(record.get(s));
                        }
                        else if(tempNode.distance >= 0)
                        {
                            continue;
                        }
                        else
                        {
                            isEnd = true;
                            tempNode.nextList.add(record.get(s));
                        }
                    }
                }
            }
            startCount = newStartCount;
            if(isEnd)
                break;
            
            int newEndCount = 0;
            while(endCount > 0)
            {
                endCount --;
                String s = endList.pollFirst();
                List<String> tempList = getNext(s, dict);
                for(String next: tempList)
                {
                    if(!record.containsKey(next))
                    {
                        WordNode tempNode = new WordNode(- distance - 1,next);
                        record.get(s).nextList.add(tempNode);
                        record.put(next,tempNode);
                        endList.addLast(next);
                        newEndCount ++;
                    }
                    else
                    {
                        WordNode tempNode = record.get(next);
                        if(tempNode.distance == - distance - 1)
                        {
                            record.get(s).nextList.add(tempNode);
                        }
                        else if(tempNode.distance < 0)
                        {
                            continue;
                        }
                        else
                        {
                            isEnd = true;
                            record.get(s).nextList.add(tempNode);
                        }
                    }
                }
            }
            endCount = newEndCount;
            if(isEnd)
                break;
        }
        List<String> tempResult = new ArrayList<String>();
        traverseNode(record.get(end), result, tempResult);
        return result;
    }
    void traverseNode(WordNode root, List<List<String>> result, List<String> tempResult)
    {
        if(root == null)
            return;
        if(root.distance == 0)
        {
            tempResult.add(0, root.content);
            result.add(new ArrayList<String>(tempResult));
            tempResult.remove(0);
        }
        else
        {
            tempResult.add(0, root.content);
            for(int i = 0;i < root.nextList.size();i ++)
            {
                traverseNode(root.nextList.get(i), result, tempResult);
            }
            tempResult.remove(0);
        }
    }
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
}