package com.phonepe.battleShipGame.services;

import com.phonepe.battleShipGame.models.Battlefield;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ViewBattleFieldService {
    private static final Logger logger = LoggerFactory.getLogger(ViewBattleFieldService.class);
    private final Battlefield battlefield;

    public ViewBattleFieldService(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    /**
     * display the battlefield as a NxN grid and all the ships along with the grids occupied by each ship.
     * @return Final BattleField occupied with Ship's.
     */
    public String viewBattleField() {
        validateGameInitialized();
        return battlefield.viewBattleField();
    }

    private synchronized void validateGameInitialized() {
        if (battlefield == null) {
            logger.error("Game is not yet initialized!");
            throw new IllegalStateException("Game not initialized!");
        }
    }
}
