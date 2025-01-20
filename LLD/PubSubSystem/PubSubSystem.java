// PubSubSystem class to manage topics, publishers, and subscribers
class PubSubSystem {
    private final Map<String, Topic> topics;

    public PubSubSystem() {
        this.topics = new ConcurrentHashMap<>();
    }

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    public void deleteTopic(String topicName) {
        Topic topic = topics.remove(topicName);
        if (topic != null) {
            topic.shutdown();
        }
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.addSubscriber(subscriber);
        } else {
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }
    }

    public void unsubscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.removeSubscriber(subscriber);
        }
    }

    public void publish(String topicName, Message message) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.publish(message);
        } else {
            throw new IllegalArgumentException("Topic does not exist: " + topicName);
        }
    }
}
