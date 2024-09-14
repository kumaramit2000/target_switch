package models;
@Data
public class PlayerData {
    int score;
    int ballPlayed;
    int noOfFours;
    int noOfSixs;
    int wicketTaken;

    public PlayerData() {
        this.score = 0;
        this.wicketTaken = 0;
        this.noOfSixs = 0;
        this.noOfFours = 0;
        this.ballPlayed = 0;
    }

    private void updateScore(int score){
        this.score+=score;
    }

    private void updateBallPlayed(){
        this.ballPlayed++;
    }

    private void updateNoOfFours(){
        this.noOfFours++;
    }

    private void updateNoOfSixs(){
        this.noOfSixs++;
    }

    public void updatePlayerScore(int score){
        updateScore(score);
        updateBallPlayed();
        if(score==4){
            updateNoOfFours();
        } else if(score==6){
            updateNoOfSixs();
        }
    }
}