import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _14_Streams {
    @Test
    public void streamfilter_1(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Furkan");
        names.add("Faruk");
        names.add("Ahmet");
        names.add("Kemal");
        names.add("Fırat");

        int count=0;

        for (int i=0;i<names.size();i++){
            if (names.get(i).startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamfilter_2(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Furkan");
        names.add("Faruk");
        names.add("Ahmet");
        names.add("Kemal");
        names.add("Fırat");

        long c= names.stream().filter(s->s.startsWith("F")).count();
        System.out.println(c);
        System.out.println("-------------");

        System.out.println(Stream.of("Furkan","Fırat","Ayse").filter(s -> s.startsWith("F")).count());
        System.out.println("-------------");

        long d = Stream.of("Furkan","Fırat","Ayse").filter(s->
        {
            s.startsWith("F");
            return false;
        }
        ).count();
        System.out.println(d);
        System.out.println("-------------");

        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
        System.out.println("-------------");

        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));

    }

    @Test
    public void streamMap(){
        Stream.of("Furkan","Ali","Ahmet","Mehmet").filter(s -> s.endsWith("t")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        System.out.println("-------------");

        ArrayList<String> names = new ArrayList<>();
        names.add("Furkan");
        names.add("Faruk");
        names.add("Ahmet");
        names.add("Kemal");
        names.add("Fırat");
        List<String> names1 = Arrays.asList("Aaaa","Abbb","Accc","Dccc");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        System.out.println("-------------");

        Stream<String> newStream= Stream.concat(names.stream(),names1.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Furkan"));   //concat should be there with anyMatch otherwise equalsIgnoreCase does not work.
        System.out.println(flag);
        Assert.assertTrue(flag,"does not match");
    }

    @Test
    public void streamCollect(){
        List<String> ls = Stream.of("aaa","bbb","ccc").map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(1));

        System.out.println("--------");

        List<Integer> values = Arrays.asList(5,7,6,1,2,5,5,7,4);
        values.stream().distinct().forEach(s-> System.out.println(s));
        System.out.println("--------");
        List<Integer> listOfvalues = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(listOfvalues.get(3)+"    "+"3rd index");

    }

}
