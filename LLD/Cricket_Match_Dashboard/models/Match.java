import enums.MatchStatus;
package models;

@Data
public class Match {
    Team a;
    Team b;
    int totalOvers;
    int totalPlayers;
    MatchStatus matchStatus;
    Team battingTeam;
    Team prevBattingTeam;
    String matchName;
    Dashboard dashboard;

    public Match(String matchName, Team ind, Team eng, int totalPlayers, int totalOvers){
        this.matchName = matchName;
        this.a=ind;
        this.b=eng;
        this.totalPlayers = totalPlayers;
        this.totalOvers = totalOvers;
        this.battingTeam = null;
        this.prevBattingTeam = null;
        this.matchStatus = MatchStatus.NOT_STARTED;
    }

    public addPlayerInTeam(Team a, String[] players){
        if(players.length > totalPlayers){
            System.out.println("No of Players are more!!!!");
        } else {
            for(String playerName : players){
                a.addPlayer(new CricketPlayer(playerName));
            }
        }
    }

    public startMatch(Team team){
        this.matchStatus = MatchStatus.IN_PROGRESS;
        this.battingTeam = team;
        startBatting();
        switchTeam(team);
        startBatting();
        displayResult();
    }

    private void startBatting(){
        System.out.println("Batting team : " + this.battingTeam.teamName + " playing for overs : " + this.totalOvers);
        Scanner scanner = new Scanner(System.in);
        this.battingTeam.assignPlayers();
        for(int i=1;i<=this.totalOvers;i++){
            System.out.println("Current over is : "+ i);
            int ballPlayed = 0;
            while(ballPlayed<6){
                String currentBall = scanner.nextLine();
                if(currentBall != "Nb" && currentBall!="Wd") {
                    ballPlayed++;
                    updateScore(currentBall);
                    // If it's 2nd inning, then current playing team can win in any ball if they chase the runs successfully.
                    if (!this.battingTeam.isNextBatsmanAvailable() && this.prevBattingTeam != null && this.battingTeam.totalTeamScore >= this.prevBattingTeam.totalTeamScore) {
                        dashboard.displayScoreCard(this.battingTeam);
                    }
                } else {
                    if(currentBall == "Nb"){
                        //NB HAI
                        //e can do more operation here...
                        this.battingTeam.updateScore(1,"Nb");
                    } else {
                        //wide hai
                        this.battingTeam.updateScore(1,"Wd");
                    }
                }
            }
            this.battingTeam.swapStrike();
            dashboard.displayScoreCard(this.battingTeam);
        }
    }

    private void updateScore(String score){
        if(score=="Wk"){
            this.battingTeam.updateWicket();
        } else {
            if (score.length() == 1 && Integer.valueOf(score) >= 0 && Integer.valueOf(score) <= 6) {
                int num = Integer.valueOf(score);
                this.battingTeam.updateScore(num);
            }
        }
    }

    private void switchTeam(Team team){
        if(battingTeam.equals(team)){
            this.battingTeam=b;
            this.prevBattingTeam=a;
        } else{
            this.battingTeam=a;
            this.prevBattingTeam=b;
        }
    }

    private void displayResult(){
        this.matchStatus = MatchStatus.COMPLETED;
        if(this.battingTeam.totalTeamScore > this.prevBattingTeam.totalTeamScore){
            System.out.println("Result ::: " + this.battingTeam.teamName + "Won the Match by : " + this.battingTeam.totalTeamScore - this.prevBattingTeam.totalTeamScore + " runs!!!");
        } else {
            System.out.println("Result ::: " + this.prevBattingTeam.teamName + "Won the Match by : " + this.prevBattingTeam.totalTeamScore - this.battingTeam.totalTeamScore + " runs!!!");
        }
    }
}