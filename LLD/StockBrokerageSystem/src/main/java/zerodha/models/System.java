package zerodha.models;

import java.util.HashMap;
import java.util.Map;

public class System {
    public static Map<String,ZerodhaUser> users;

    public System() {
        users = new HashMap<>();
    }

    public static void addUser(String userId, ZerodhaUser user){
        if(users.containsKey(userId)){
            //already present
        } else {
            users.put(userId,user);
        }
    }

    public static ZerodhaUser getUser(String userId){
        if(users.containsKey(userId)){
            return users.get(userId);
        } else {
            // user not present
            return null;
        }
    }

    public static Map<String, ZerodhaUser> getUsers() {
        return users;
    }
}
