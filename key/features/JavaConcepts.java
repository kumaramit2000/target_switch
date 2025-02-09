package com.phonepe.battleShipGame;

import java.util.*;
import java.util.stream.Collectors;


class Animal {
    void eat() {
        System.out.println("This animal is eating.");
    }
    void makeSound() {
        System.out.println("Animal makes a sound");
    }

}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog is barking.");
    }
    @Override
    void makeSound() {
        System.out.println("Dog barks...");
    }
}

class PitBull extends Dog {
    void printDetails() {
        System.out.println("dog details.");
    }
}

class Outer {
    static class Nested {
        void display() {
            System.out.println("Hello from Static Nested Class!");
        }
    }
}

final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class User {
    int id;
    String name;
    String city;

    // Constructor
    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getter methods (Optional for this example)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', city='" + city + "'}";
    }
}


public class Sample {

    public static void main(String[] args) {

        FixedBuffer buffer = new FixedBuffer(10);  // Buffer of size 10

        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();
        t1.start();
        t2.start();

        int[] numbers = {5, 2, 9, 1, 7};

        numbers = Arrays.stream(numbers)
                .sorted()
                .toArray();

        numbers = Arrays.stream(numbers)
                .boxed()  // Convert int to Integer
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)  // Convert back to int[]
                .toArray();

        List<Integer> numbers1 = Arrays.asList(5, 2, 9, 1, 7);

        // Ascending Order
        List<Integer> sortedList = numbers1.stream()
                .sorted()
                .collect(Collectors.toList());

        // Descending Order
        List<Integer> sortedDescList = numbers1.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        String str = "hello";
        // Convert String to char array
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);  // Sort characters
        // Convert back to String
        String sortedStr = new String(charArray);

//        Outer.Nested obj = new Outer.Nested();  // No need for Outer instance
//        obj.display();  // Output: Hello from Static Nested Class!

        List<User> userList = Arrays.asList(
                new User(1, "Alice", "New York"),
                new User(2, "Bob", "Los Angeles"),
                new User(3, "Charlie", "Chicago")
        );

        // Using Stream to populate the map
        Map<User, String> userMap = userList.stream()
                .collect(Collectors.toMap(
                        user -> user,  // Key is the User object itself
                        user -> "user." + user.getId() + "_" + user.getName() + "_" + user.getCity()  // Value is the formatted string
                ));
    }

}



class FixedBuffer {
    private final List<Integer> buffer;
    private final int capacity;

    public FixedBuffer(int capacity) {
        this.buffer = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    // Add item to the buffer (Producer)
    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();  // Wait if buffer is full
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notifyAll();  // Notify consumer that the buffer has data
    }

    // Remove item from the buffer (Consumer)
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();  // Wait if buffer is empty
        }
        int value = buffer.remove(0);
        System.out.println("Consumed: " + value);
        notifyAll();  // Notify producer that the buffer has space
        return value;
    }
}

class ThreadA extends Thread{
    public void run(FixedBuffer buffer){
        try {
            for (int i = 0; i < 20; i++) {  // Produce 20 items
                buffer.produce(i);
                Thread.sleep(100);  // Simulate time to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ThreadB extends Thread{
    public void run(FixedBuffer buffer){
        try {
            for (int i = 0; i < 20; i++) {  // Consume 20 items
                buffer.consume();
                Thread.sleep(150);  // Simulate time to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
