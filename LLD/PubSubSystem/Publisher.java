// Publisher class to represent a publisher
class Publisher {
    private final String name;

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void publish(PubSubSystem pubSubSystem, String topicName, Message message) {
        pubSubSystem.publish(topicName, message);
    }
}
