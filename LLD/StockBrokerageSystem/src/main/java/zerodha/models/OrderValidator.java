package zerodha.models;

import zerodha.enums.TransactionType;
import zerodha.models.ZerodhaUser;

public class OrderValidator {
    // its job is to validate the order...
    public static System system;

    public boolean validateOrder(String userId, Order order){
        ZerodhaUser user = system.getUser(userId);
        if(order.getTransactionType().equals(TransactionType.BUY)){
            //CHECKING IF USER HAVE FUNDS TO BUY
        } else {
            //CHECKING IF USER HAS STOCK TO SELL
        }
        // assuming user have made valid order request...
        return true;
    }
}