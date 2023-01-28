package code.elif.app.features.java14;

public record Person(int id, String name, String lastName) {
    public Person {
        if (id <= 0 || name == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Invalid Person");
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person(1, "Andrea", "Apple");
        System.out.println(person1.name());

        Person person2 = new Person(1, "Andrea", "Apple");
        System.out.println("Are they the same person : " + person1.equals(person2));
    }
}
