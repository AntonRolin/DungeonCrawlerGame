/**
 * Created by: Anton Rolin
 * Date: 04/10/2020
 * Time: 17:02
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class EnemyWarrior extends Character{

    public EnemyWarrior(int hp, int atk){
        super(hp, atk);
        this.characterType = CharacterTypes.WARRIOR;
    }
}
