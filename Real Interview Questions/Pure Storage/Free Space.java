

public class Folder {
	String host;
	ArrayList<MyArray> myarrays;
	ArrayList<Folder> folders;
	public Folder(String t_host) {
		host = t_host;
		myarrays = new ArrayList<MyArray>();
		folders = new ArrayList<Folder>();
	}
}

public class MyArray {
	public int getFreeSpace() {
		// return free space of an array
	}
}

// recursively
public int getFreeSpaceFolder(Folder myFolder) {
	int result = 0;
	if (myFolder == null) {
		return result;
	}
	if (myFolder.myarrays != null) {
		for (int i = 0; i < myFolder.myarrays.size(); i++) {
			result += myFolder.myarrays.get(i).getFreeSpace();
		}
	}
	if (myFolder.folders != null) {
		for (int i = 0; i < myFolder.folders.size(); i++) {
			result += getFreeSpaceFolder(myFolder.folders.get(i));
		}
	}
	return result;
}

// non-recursively
public int getFreeSpaceFolder(Folder myFolder) {
	int result = 0;
	LinkedList<Folder> queue = new LinkedList<Folder>();
	queue.addLast(myFolder);
	while (queue.size() != 0) {
		Folder tempFolder = queue.pollFirst();
		if (tempFolder == null) {
			continue;
		}
		if (tempFolder.myarrays != null) {
			for (int i = 0; i < tempFolder.myarrays.size(); i++) {
				result += tempFolder.myarrays.get(i).getFreeSpace();
			}
		}
		if (tempFolder.folders != null) {
			for (int i = 0; i < tempFolder.folders.size(); i++) {
				queue.addLast(tempFolder.folders.get(i));
			}
		}
	}
	return result;
}