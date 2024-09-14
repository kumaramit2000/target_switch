package models;

@Data
public class CricketPlayer extends Player {
    PlayerData playerData;
    boolean onStike;
    boolean isOut;

    public CricketPlayer(String playerName) {
        super(playerName);
        this.onStike = false;
        this.isOut = false;
        this.playerData = new PlayerData();
    }

    public void updatePlayerScore(int score){
        playerData.updatePlayerScore(score);
    }
}