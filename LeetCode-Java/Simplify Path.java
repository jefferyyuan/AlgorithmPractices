public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> record = new LinkedList<String>();
        int startIndex = 0;
        while(startIndex < path.length())
        {
            while(startIndex < path.length() && path.charAt(startIndex) == '/')
                startIndex ++;
            if(startIndex >= path.length())
                break;
            int tempIndex = startIndex + 1;
            while(tempIndex < path.length() && path.charAt(tempIndex) != '/')
                tempIndex ++;
            if(tempIndex == startIndex)
                continue;
            String tempString = path.substring(startIndex, tempIndex);
            startIndex = tempIndex;
            if(tempString.compareTo(".") == 0)
            {
                continue;
            }
            else if(tempString.compareTo("..") == 0)
            {
                if(record.size() > 0)
                    record.removeLast();
            }
            else
            {
                record.addLast(tempString);
            }
        }
        String result = "";
        while(record.size() > 0)
        {
            result += "/" + record.pollFirst();
        }
        if(result.length() == 0)
            result += "/";
        return result;
    }
}