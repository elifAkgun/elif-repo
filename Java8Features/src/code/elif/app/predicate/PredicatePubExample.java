package code.elif.app.predicate;

import com.sun.codemodel.internal.JForEach;

import java.util.function.Predicate;

public class PredicatePubExample {

    public static void main(String[] args) {
        Person person1 = new Person("John",10,false);
        Person person2 = new Person("James",34,true);
        Person person3 = new Person("Mike",45,false);
        Person person4 = new Person("Tom",17,true);

        Person [] people = {person1,person2,person3,person4};

        Predicate<Person> isEnteredPub = (person -> (person.age>=18 && person.hasGirlFriend));

        System.out.println("Pub allowed list:");
        for (Person p :people) {
            if (isEnteredPub.test(p)){
                System.out.println("Congratulation " + p.name);
            }
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
}
