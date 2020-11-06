/**
 * Created by: Anton Rolin
 * Date: 03/10/2020
 * Time: 18:21
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class Character {

    private int hp;
    private int atk;
    protected CharacterTypes characterType;

    public Character(int hp, int atk){
        this.hp = hp;
        this.atk = atk;
    }


    public int getAtk() { return atk; }

    public int getHp() { return hp; }

    public void setAtk(int atk) { this.atk = atk; }

    public void setHp(int hp) {
        this.hp = hp;
        if(this.hp < 0)
            this.hp = 0;
    }

    public CharacterTypes getCharacterType() { return characterType; }
}
