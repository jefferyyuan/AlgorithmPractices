/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode,UndirectedGraphNode> record = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return cloneGraphPart(node,record);
    }
    
    UndirectedGraphNode cloneGraphPart(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> record)
    {
        if(node == null) return null;
        if(record.containsKey(node))
            return record.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        record.put(node, newNode);
        for(int i = 0;i < node.neighbors.size();i ++)
        {
            UndirectedGraphNode tempNode = node.neighbors.get(i);
            if(record.containsKey(tempNode))
                newNode.neighbors.add(record.get(tempNode));
            else
            {
                UndirectedGraphNode newTempNode = cloneGraphPart(tempNode,record);
                newNode.neighbors.add(newTempNode);
            }
        }
        return newNode;
    }
}