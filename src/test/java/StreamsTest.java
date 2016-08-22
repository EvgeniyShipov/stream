import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.*;

public class StreamsTest {

    Person person1 = new Person("John", 25);
    Person person2 = new Person("Sara", 23);
    Person person3 = new Person("Diana", 3);
    List<Person> list = new ArrayList<>();

    @Test
    public void streamsTestFilter() throws Exception {
        list.add(person1);
        list.add(person2);
        list.add(person3);
        Assert.assertEquals(list.stream().filter(p -> p.getAge() > 20).collect(toMap(Person::getName, Person::getAge)),
                Streams.of(list).filter(p -> p.getAge() > 20).toMap(Person::getName, Person::getAge));
    }

    @Test
    public void streamsTestTransform() throws Exception {
        list.add(person1);
        list.add(person2);
        list.add(person3);
        Assert.assertEquals(list.stream().map(p -> new Person(p.getName(), p.getAge() + 5)).collect(toMap(Person::getName, Person::getAge)),
                Streams.of(list).transform(p -> new Person(p.getName(), p.getAge() + 5)).toMap(Person::getName, Person::getAge));
    }

    @Test
    public void streamsTestToMap() throws Exception {
        list.add(person1);
        list.add(person2);
        list.add(person3);
        Assert.assertEquals(list.stream().collect(toMap(Person::getName, p -> p.getAge() + 5)), Streams.of(list).toMap(Person::getName, p -> p.getAge() + 5));

    }

}