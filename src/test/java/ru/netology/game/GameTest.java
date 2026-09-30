package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "RUS", 100);
    Player player2 = new Player(2, "USA", 80);
    Player player3 = new Player(3, "GER", 100);
    Player player4 = new Player(4, "FR", 10);

    @BeforeEach
    void setup() {
        game.registered(player1);
        game.registered(player2);
    }

    @Test
    void registered() {
        Assertions.assertEquals(player1, game.findByName("RUS"));
    }

    @Test
    void notRegistered() {
        Assertions.assertNull(game.findByName("GER"));
    }

    @Test
    void round1() {

        Assertions.assertEquals(1, game.round("RUS", "USA"));
    }

    @Test
    void round2() {
        Assertions.assertEquals(2, game.round("USA", "RUS"));
    }

    @Test
    void round0() {
        game.registered(player3);

        Assertions.assertEquals(0, game.round("RUS", "GER"));
    }

    @Test
    void roundThrowException_1(){
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("GER","RUS");
        });
    }

    @Test
    void roundThrowException_2(){
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("RUS","GER");
        });
    }

}
