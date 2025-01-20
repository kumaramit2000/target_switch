// Example usage
public class PubSubExample {
    public static void main(String[] args) {
        PubSubSystem pubSubSystem = new PubSubSystem();

        // Create topics
        pubSubSystem.createTopic("Sports");
        pubSubSystem.createTopic("Technology");

        // Create subscribers
        Subscriber subscriber1 = message -> System.out.println("Subscriber 1 received: " + message.getContent());
        Subscriber subscriber2 = message -> System.out.println("Subscriber 2 received: " + message.getContent());

        // Subscribe to topics
        pubSubSystem.subscribe("Sports", subscriber1);
        pubSubSystem.subscribe("Sports", subscriber2);
        pubSubSystem.subscribe("Technology", subscriber1);

        // Create publishers
        Publisher publisher1 = new Publisher("Publisher 1");
        Publisher publisher2 = new Publisher("Publisher 2");

        // Publish messages
        publisher1.publish(pubSubSystem, "Sports", new Message("Football match today"));
        publisher2.publish(pubSubSystem, "Technology", new Message("New Java version released"));

        // Unsubscribe
        pubSubSystem.unsubscribe("Sports", subscriber2);

        // Publish another message
        publisher1.publish(pubSubSystem, "Sports", new Message("Cricket World Cup update"));

        // Delete a topic
        pubSubSystem.deleteTopic("Technology");
    }
}
