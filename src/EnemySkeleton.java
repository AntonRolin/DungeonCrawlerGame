/**
 * Created by: Anton Rolin
 * Date: 03/10/2020
 * Time: 18:23
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class EnemySkeleton extends Character{

    public EnemySkeleton(int hp, int atk){
        super(hp, atk);
        this.characterType = CharacterTypes.SKELETON;
    }
}
