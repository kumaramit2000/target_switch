package zerodha;

import zerodha.enums.ExchangeType;
import zerodha.enums.OrderType;
import zerodha.enums.TransactionType;
import zerodha.models.Order;
import zerodha.models.OrderManager;
import zerodha.models.Stock;
import zerodha.models.ZerodhaUser;

public class Demo {

    ZerodhaUser user = new ZerodhaUser("abc","Amit");

    Stock stock = new Stock( 1000.1,"TCS", ExchangeType.NSE);

    Order order = new Order(OrderType.LIMIT, TransactionType.BUY, 1100, 20, stock, ExchangeType.NSE);

    OrderManager orderManager = new OrderManager();

//    user.getId();

//    orderManager.placeOrder(user.getId(), order);

}
