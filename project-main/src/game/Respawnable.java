package game;

import edu.monash.fit2099.engine.actions.Action;

public interface Respawnable {
    int getTurnsToRespawn();
    void countDown();
    Action respawn();
}