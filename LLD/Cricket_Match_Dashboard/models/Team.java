package models;

@Data
public class Team {
    String teamName;
    List<CricketPlayer> players;
    Deque<CricketPlayer> availablePlayers;
    int totalTeamScore;
    int totalWickets;
    CricketPlayer currentPlayer;
    CricketPlayer strikePlayer;

    public Team(String teamName) {
        this.players = new ArrayList<>();
        this.availablePlayers = new LinkedList<>();
        this.totalTeamScore = 0;
        this.currentPlayer = null;
        this.strikePlayer = null;
        this.teamName = teamName;
        this.totalWickets = 0;
    }

    public void addPlayer(CricketPlayer player){
        if(this.players.contains(player)){
            System.out.println("Player is already present in Team!!!!");
        } else {
            this.players.add(player);
            this.availablePlayers.addLast(player);
        }
    }

    public void assignPlayers(){
        if(availablePlayers.size()>=2){
            this.currentPlayer = availablePlayers.pool();
            this.strikePlayer = availablePlayers.pool();
        }
    }

    public boolean isNextBatsmanAvailable(){
        if(this.availablePlayers.size()>0){
            return true;
        } else {
            return false;
        }
    }

    public void swapStrike(){
        CricketPlayer temp = this.currentPlayer;
        this.currentPlayer = this.strikePlayer;
        this.strikePlayer = temp;
    }

    public void updateScore(int score){
        currentPlayer.updatePlayerScore(score);
        changeStrikeIfValid(score);
        totalTeamScore+=score;
    }

    private void changeStrikeIfValid(int score){
        if(score!=0 && score%2!=0){
            CricketPlayer temp = this.currentPlayer;
            this.currentPlayer = this.strikePlayer;
            this.strikePlayer = temp;
        }
    }

    public void updateScore(int score, String type){
        if(type=="Nb"){
            totalTeamScore+=score;
        } else {
            totalTeamScore+=score;
        }
    }

    public void updateWicket(){
        this.totalWickets++;
        if(isNextBatsmanAvailable()){
            currentPlayer.updatePlayerScore(0);
            CricketPlayer py = availablePlayers.poll();
            this.currentPlayer = py;
        } else {
            System.out.println("All Out!!! No Player left...");
        }
    }
}