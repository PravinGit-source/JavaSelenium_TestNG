package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//List <String> names = new ArrayList<>();
//names.add("Aman");
//names.add("Ajit");
//names.add("Pravin");
//names.add("Sumit");
//names.add("Akhil");
//int count =0;
//for(int i=0; i<names.size();i++)
//{
//String actualname= names.get(i);
//if(actualname.startsWith("A"))
//{
//	count++;
//	System.out.println(actualname);
//}
//System.out.println(actualname);
//}
//		System.out.println(count);
	
//Long l = names.stream().filter(s->s.startsWith("A")).count();
//System.out.println(l);

long d = Stream.of("Atul","Anuj","Pravin","Sumit","Akhila").filter(s->s.startsWith("A")).count();
System.out.println(d);
System.out.println("---------------------------------------------------------------------------------");
Stream.of("Aman", "Ajit", "Pravin", "Sumit", "Akhil")
.filter(s -> s.length()>5)
.forEach(s->System.out.println(s));;
System.out.println("---------------------------------------------------------------------------------");
Stream.of("Aman", "Ajit", "Pravin", "Sumit", "Akhil").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
System.out.println("---------------------------------------------------------------------------------");
List <String> names = Arrays.asList("Atul","Anuj","Pravin","Sumit","Akhila");
List <String> names1 = Arrays.asList("Aman","Ajit","Pravin","Sumit","Akhil");
names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
System.out.println("---------------------------------------------------------------------------------");
Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
newStream.sorted().forEach(s->System.out.println(s));
List<String> ls = Stream.of("Aman", "Ajit", "Pravin", "Sumit", "Akhil").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
System.out.println("---------------------------------------------------------------------------------");
System.out.println(ls.get(1));
System.out.println("---------------------------------------------------------------------------------");
List<Integer> values=Arrays.asList(1,3,4,3,6,7,1,8);
List<Integer>li = values.stream().distinct().sorted().collect(Collectors.toList());
System.out.println(li.get(3));




	}

}
