import java.util.Random;

/**
 * Created by: Anton Rolin
 * Date: 03/10/2020
 * Time: 18:22
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class MainCharacter extends Character{

    private int numOfHealthPots = 2;
    private int healthPotHeal = 40;
    private int critChance;
    private double critDamage = 200;

    Random rand = new Random();

    public MainCharacter(int hp, int atk, int critChance){
        super(hp, atk);
        this.critChance = critChance;
        this.characterType = CharacterTypes.PROTAGONIST;
    }

    public boolean useHealthPotion(){
        if(numOfHealthPots > 0) {
            setHp(this.getHp() + healthPotHeal);
            numOfHealthPots -= 1;
            return true;
        }
        else
            return false;
    }

    public double attack(){
        int critRand = rand.nextInt(100)+1;
        if(critRand >= this.critChance)
            return this.getAtk();
        else
            System.out.println(ConsoleColors.RED_BOLD+"CRIT!"+ConsoleColors.RESET);
            return this.getAtk()*(critDamage/100);
    }

    public int getHealthPotHeal() { return healthPotHeal; }

    public int getNumOfHealthPots() { return numOfHealthPots; }

    public int getCritChance() { return critChance; }

    public double getCritDamage() { return critDamage; }

    public void setNumOfHealthPots(int numOfHealthPots) { this.numOfHealthPots = numOfHealthPots; }

    public void setHealthPotHeal(int healthPotHeal) { this.healthPotHeal = healthPotHeal; }

    public void setCritDamage(double critDamage) { this.critDamage = critDamage; }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
        if( critChance > 100)
            this.critChance = 100;
    }
}
