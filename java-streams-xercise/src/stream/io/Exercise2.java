package stream.io;

import java.time.Duration;
import java.util.stream.Stream;

public class Exercise2 {

	public static void main(String[] args) {
	
//		List<Integer> list = Arrays.asList(1,2,3,6,7,8,234,1,245,6,1,2,8);
//		
//		list.stream().filter(i-> i%2==0 ).forEach(i->System.out.println(i));
		
		
//		Integer i=CustomStreams.streamOfInt().filter(x->x>29).findFirst().orElse(-1);
//		System.out.print(i);
//		
//		CustomStreams.streamOfStr().map(ii-> ii.charAt(0)).forEach(System.out::println);
		
		
		CustomStreams.streamOfInt()
		.map( i -> CustomStreams.streamOfUsr().filter(user->user.id == i))
		.forEach(System.out::println);
		
		CustomStreams.streamOfUsr().
		filter(user -> CustomStreams.streamOfInt().anyMatch(i-> i == user.id))
		.forEach(System.out::println);;
		
		CustomStreams.streamOfUsr().
		filter(user -> CustomStreams.streamOfInt().anyMatch(i-> i == user.id))
		.forEach(System.out::println);
		
		//CustomStreams.streamOfInt().anyMatch(i-> i!=1).forEach(System.out::println);
	}

}

class CustomStreams {
	
	public static Stream<Integer> streamOfInt() {
		
		return Stream.iterate(1,i->i+1).limit(5);
	}
	
public static Stream<String> streamOfStr() {
		
		return Stream.of("Apple","Orange", "pine","red","green","rgukt");
	}

public static Stream<User> streamOfUsr() {
	
	return Stream.of(new User(2,"vekatesj"), new User(5,"Ramu"),
			new User(3,"Jugdhesh"), new User(7, "Hunger"), new User(6,"RAGHU"));
}

	public static Flux<Integer> getReactiveInt(){
	
		return Flux.range(1,10).delayElements(Duration.ofSeconds(1));
	}
	
	
	
}

class User{
	int id;
	String lname;
	public User(int id, String lname) {
		super();
		this.id = id;
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", lname=" + lname + "]";
	}
	
	
	
}
