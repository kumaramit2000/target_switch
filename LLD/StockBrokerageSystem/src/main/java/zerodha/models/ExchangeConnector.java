package zerodha.models;

/*
Singleton Design Pattern
*/
public class ExchangeConnector {
    public static volatile ExchangeConnector instance;
    private ExchangeConnector(){};

    // Best Performance for Multithreading
    // Synchronization occurs only once when creating the instance.
    // Improves performance compared to the synchronized method.
    public ExchangeConnector getExchangeConnectorInstance(){
        if(instance==null){ // first check
            synchronized (ExchangeConnector.class) {
                if (instance == null) { // second check
                    instance = new ExchangeConnector();
                }
            }
        }
        return instance;
    }

    public void sendOrderToExchange(String userId, Order order){
        // order is send to exch... congrats!!!
    }
}
