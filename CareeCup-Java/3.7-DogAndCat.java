public class Animal{
	int timestamp;
	int category; // 0 for cat and 1 for dog
	public Animal(int t_time, int t_type){
		timestamp = t_time;
		category = t_type;
	}
}

public class Container{
	List<LinkedList<Animal>> animalList;
	int time = 0;
	public Container(){
		animalList = new ArrayList<LinkedList<Animal>>();
		for(int i = 0;i < 2;i ++){
			animalList.add(new LinkedList<Animal>());
		}
		time = 0;
	}

	public void enqueue(int type){
		time ++;
		animalList.get(type).addLast(new Animal(time, type));
	}

	public Animal dequeueAny(){
		int catAge = Integer.MAX_VALUE;
		if(animalList.get(0).size() > 0)
			catAge = animalList.get(0).getFirst().timestamp;
		int dogAge = Integer.MAX_VALUE;
		if(animalList.get(1).size() > 0)
			dogAge = animalList.get(1).getFirst().timestamp;
		if(animalList.get(0).size() == 0 && animalList.get(1).size() == 0)
			return null;
		else if(catAge < dogAge)
			return animalList.get(0).pollFirst();
		else 
			return animalList.get(1).pollFirst();
	}

	public Animal dequeueCat(){
		return animalList.get(0).pollFirst();
	}

	public Animal dequeueDog(){
		return animalList.get(1).pollFirst();
	}
}

public void test_1(){
	Container tempContainer = new Container();
	tempContainer.enqueue(0);
	tempContainer.enqueue(1);
	tempContainer.enqueue(1);
	tempContainer.enqueue(0);
	System.out.println(tempContainer.dequeueAny().category);
	System.out.println(tempContainer.dequeueDog().category);
	System.out.println(tempContainer.dequeueAny().category);
	System.out.println(tempContainer.dequeueAny().category);
}