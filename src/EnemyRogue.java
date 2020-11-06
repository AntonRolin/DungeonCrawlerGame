/**
 * Created by: Anton Rolin
 * Date: 08/10/2020
 * Time: 10:31
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class EnemyRogue extends Character{

    public EnemyRogue(int hp, int atk){
        super(hp, atk);
        this.characterType = CharacterTypes.ROGUE;
    }
}
