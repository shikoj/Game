package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    void registered() {
        Player player = new Player(1, "RUS", 100);
        game.registered(player);
        Assertions.assertEquals(player, game.findByName("RUS"));
    }
    @Test
    void notRegistered(){
        Player player1 = new Player(1, "RUS", 100);
        Player player2 = new Player(2, "USA", 80);
        game.registered(player1);
        Assertions.assertNull(game.findByName("USA"));
    }

    @Test
    void findByName() {
    }

    @Test
    void round() {
    }
}
