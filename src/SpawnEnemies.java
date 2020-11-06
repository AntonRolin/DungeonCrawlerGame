import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by: Anton Rolin
 * Date: 04/10/2020
 * Time: 17:08
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class SpawnEnemies {


    public List<Character> generateEnemies() {
        List<Character> enemies = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int randHP, randATK;

            Random rand = new Random();
            int enemyType = rand.nextInt(2);
            if(i>=5)
                enemyType = rand.nextInt(3);

            switch(enemyType){
//Skeleton
                case 0:
                    randHP = rand.nextInt(20)+30;
                    randATK = rand.nextInt(10)+5;
                    enemies.add(new EnemySkeleton(randHP, randATK));
                    break;
//Warrior
                case 1:
                    randHP = rand.nextInt(50)+40;
                    randATK = rand.nextInt(5)+5;
                    enemies.add(new EnemyWarrior(randHP, randATK));
                    break;
//Rogue
                case 2:
                    randHP = rand.nextInt(30)+25;
                    randATK = rand.nextInt(25)+15;
                    enemies.add(new EnemyRogue(randHP, randATK));
                    break;
//Necromancer
                case 3:
                    randHP = rand.nextInt(30)+25;
                    randATK = rand.nextInt(25)+15;
                    enemies.add(new EnemyNecromancer(randHP, randATK));
                    break;
            }
        }
        return enemies;
    }


}
