package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import com.phonepe.battleShipGame.models.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    private static final Logger logger = LoggerFactory.getLogger(BattleService.class);
    private final Battlefield battlefield;

    public BattleService(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    /**
     * Starts the game and alternates turns between the players until the game ends.
     * Declares the winner at the end of the game.
     */
    public void startGame() {
        synchronized (this) {
            validateGameInitialized();
            Player currentPlayer = battlefield.getPlayerA();
            Player opponent = battlefield.getPlayerB();
            while (!battlefield.isGameOver()) {
                battlefield.fireMissile(currentPlayer, opponent);
                // Swap turn between planers
                Player temp = currentPlayer;
                currentPlayer = opponent;
                opponent = temp;
            }
            System.out.println("Game Over. " + (battlefield.getPlayerA().hasShips() ? "PlayerA wins!" : "PlayerB wins!"));
        }
    }

    private synchronized void validateGameInitialized() {
        if (battlefield == null) {
            logger.error("Game is not yet initialized!");
            throw new IllegalStateException("Game not initialized!");
        }
    }

}
