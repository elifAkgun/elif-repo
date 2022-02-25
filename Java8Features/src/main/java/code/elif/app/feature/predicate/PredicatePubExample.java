package code.elif.app.feature.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicatePubExample {

    public static void main(String[] args) {
        Person person1 = new Person("John", 10, false);
        Person person2 = new Person("James", 34, true);
        Person person3 = new Person("Mike", 45, false);
        Person person4 = new Person("Tom", 17, true);

        Person[] people = {person1, person2, person3, person4};

        Predicate<Person> isEnteredPub = (person -> (person.age >= 18 && person.hasGirlFriend));

        Person lastEnteredPerson = new Person();

        System.out.println("Pub allowed list:");
        for (Person p : people) {
            if (isEnteredPub.test(p)) {
                lastEnteredPerson = p;
                System.out.println("Congratulation " + p.name);
            }
        }

        Predicate<Person> isLastEnteredPersonJames = Predicate.isEqual(
                new Person("James", 34, true));

        if(isLastEnteredPersonJames.test(lastEnteredPerson)){
            System.out.println("The last entered person is still James..");
        }
    }
}

class Person {
    String name;
    int age;
    boolean hasGirlFriend;

    public Person(String name, int age, boolean hasGirlFriend) {
        this.name = name;
        this.age = age;
        this.hasGirlFriend = hasGirlFriend;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                hasGirlFriend == person.hasGirlFriend &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, hasGirlFriend);
    }
}
