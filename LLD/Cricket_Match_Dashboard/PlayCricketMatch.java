import models.Team;
public class PlayCricketMatch {
    public static void main(String[] args) {
        Team ind;
        Team eng;
        Match match = new Match("2 Over Match | India Tour Of Eng",ind,eng,5,2);
        match.addPlayerInTeam(ind, new String[]{"P1","P2","P3","P4","P5"});
        match.addPlayerInTeam(eng, new String[]{"P1","P2","P3","P4","P5"});
        match.startMatch(ind);
    }
}
