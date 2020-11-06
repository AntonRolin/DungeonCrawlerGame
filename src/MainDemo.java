import java.util.List;

/**
 * Created by: Anton Rolin
 * Date: 03/10/2020
 * Time: 18:21
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class MainDemo {
    public static void main(String[] args) {


        Game game = new Game();
        int kills = game.gameLogic();


        System.out.println();
        System.out.println("     GAME OVER");
    }
}
