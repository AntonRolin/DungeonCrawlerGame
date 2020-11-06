/**
 * Created by: Anton Rolin
 * Date: 08/10/2020
 * Time: 19:56
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class EnemyNecromancer extends Character{

    public EnemyNecromancer(int hp, int atk){
        super(hp, atk);
        this.characterType = CharacterTypes.NECROMANCER;
    }
}
