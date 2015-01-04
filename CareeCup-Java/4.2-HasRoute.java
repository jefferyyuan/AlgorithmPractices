public class GraphNode{
	int val;
	boolean hasVisited;
	List<GraphNode> toList;
	public GraphNode(int t_value){
		val = t_value;
		hasVisited = false;
		toList = new ArrayList<GraphNode>();
	}
}

public boolean hasRoute(GraphNode start, GraphNode end){
	
}