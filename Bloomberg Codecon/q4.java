import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Your submission should *ONLY* use the following class name
public class Problem
{
	public class User{
		String name;
		int count;
		public User(String t_name) {
			name = t_name;
			count = 0;
		}
	}
	int compare(User a, User b) {
		if (a.count > b.count)
			return 1;
		else if(a.count == b.count) {
			if (a.name.compareTo(b.name) < 0) {
				return 1;
			} else if(a.name.compareTo(b.name) > 0) {
				return 0;
			} else {
				return -1;
			}
		}
		else 
			return -1;
	}
	public void init() {
		Scanner scan = new Scanner(System.in);
		String startUser = scan.next();
		int recommendCount = scan.nextInt();
		int caseCount = scan.nextInt();

		HashMap<String, HashSet<String>> relations = new HashMap<String, HashSet<String>>();
		for (int i = 0; i < caseCount; i++) {
			String a = scan.next();
			String b = scan.next();
			if (a.compareTo(b) == 0) {
				continue;
			}
			if (!relations.containsKey(a)) {
				relations.put(a, new HashSet<String>());
			}
			relations.get(a).add(b);

			if (!relations.containsKey(b)) {
				relations.put(b, new HashSet<String>());
			}
			relations.get(b).add(a);
		}
		
		HashSet<String> filter = relations.get(startUser);

		PriorityQueue<User> q = new PriorityQueue<User>(recommendCount,
				new Comparator<User>() {
					public int compare(User a, User b) {
						if (a.count > b.count)
							return 1;
						else if(a.count == b.count) {
							if (a.name.compareTo(b.name) < 0) {
								return 1;
							} else if(a.name.compareTo(b.name) > 0) {
								return 0;
							} else {
								return -1;
							}
						}
		
						else 
							return -1;
					}
				});
		for( String name : relations.keySet()) {
			if (name.compareTo(startUser) == 0) {
				continue;
			}
			if (filter.contains(name)) {
				continue;
			}
			User tempUser = new User(name);
			HashSet<String> tempFriends = relations.get(name);
			int tempCount = 0;
			for (String tName : tempFriends) {
				if (filter.contains(tName)) {
					tempCount++;
				}
			}
			tempUser.count = tempCount;
			if (q.size() < recommendCount) {
				q.add(tempUser);
			} else {
				User t2 = q.poll();
				if (compare(tempUser, t2) > 0) {
					q.add(tempUser);
				} else {
					q.add(t2);
				}
			}
		}
		ArrayList<String> finalResult = new ArrayList<String>();
		while(q.size() != 0) {
			User t = q.poll();
			finalResult.add(t.name);
		}
		for (int i = finalResult.size() - 1; i >= 0; i--) {
			System.out.print(finalResult.get(i) + " ");
		}
		scan.close();
	}
    public static void main(String[] args)
    {
    	Problem tool = new Problem();
    	//System.out.println(new String("a").compareTo(new String("b")));
    	tool.init();   
    }

}