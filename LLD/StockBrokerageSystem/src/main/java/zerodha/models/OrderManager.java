package zerodha.models;

public class OrderManager {
    public OrderValidator orderValidator;
    public OrderExecutioner orderExecutioner;

    public OrderManager() {
        this.orderValidator = new OrderValidator();
        this.orderExecutioner = new OrderExecutioner();
    }

    public void placeOrder(String userId, Order order){
        if(orderValidator.validateOrder(userId,order)){
            orderExecutioner.placeOrder(userId,order);
        }
    }
}
