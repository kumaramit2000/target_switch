package zerodha.models;

public class OrderExecutioner {
    public ExchangeConnector exchangeConnector;

    public void placeOrder(String userId, Order order){
        ExchangeConnector instance = exchangeConnector.getExchangeConnectorInstance();
        instance.sendOrderToExchange(userId,order);
    }
}
