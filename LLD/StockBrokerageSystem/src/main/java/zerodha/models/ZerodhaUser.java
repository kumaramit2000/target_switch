package zerodha.models;

public class ZerodhaUser {
    public String id;
    public String name;
//    funds
//    watchlist
//    portfolio

    public ZerodhaUser(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

