
// Topic class to manage messages and subscriptions
class Topic {
    private final String name;
    private final List<Subscriber> subscribers;
    private final ExecutorService executorService;

    public Topic(String name) {
        this.name = name;
        this.subscribers = new CopyOnWriteArrayList<>();
        this.executorService = Executors.newCachedThreadPool();
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(Message message) {
        for (Subscriber subscriber : subscribers) {
            executorService.submit(() -> subscriber.receive(message));
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
