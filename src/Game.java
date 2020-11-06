import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by: Anton Rolin
 * Date: 03/10/2020
 * Time: 19:26
 * Project: DungeonCrawler1
 * Copyright: MIT
 */
public class Game {
    MainCharacter mainChar = new MainCharacter(200, 20, 0);
    SpawnEnemies spawnEnemies = new SpawnEnemies();
    List<Character> enemies = spawnEnemies.generateEnemies();

    public int gameLogic(){
        int kills = 0;

        for (Character enemy: enemies) {
            int outcome = battle(mainChar, enemy);
            if(outcome == 0)
                break;

            if(kills%2 == 0 && kills != 0)
                chooseTreasure(mainChar);
            if(kills%5 == 0 && kills != 0)
                chooseArtifact(mainChar);

            kills++;
        }
        return kills;
    }
    /**
     * Battle between two characters, loops until one is dead
     * @param mainChar: One MainCharacter has to be input
     * @param enemy: One enemy has to be input
     * @return: An int depending on the outcome
     *          0 = Hero lost the battle
     *          1 = Hero won the battle
     */
    public int battle(MainCharacter mainChar, Character enemy) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean enemyAlive = true;

        System.out.println();
        System.out.println(ConsoleColors.RED + "Enemy " + enemy.getCharacterType() + " has appeared!" + ConsoleColors.RESET);

        while (enemyAlive) {
            System.out.println("--------------------------------------------");
            System.out.println("Your HP: " + mainChar.getHp() + "       Enemy HP: " + enemy.getHp());
            System.out.println("Health potions remaining: "+ mainChar.getNumOfHealthPots());
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Attack!");
            System.out.println("2. Use health potion");
            System.out.println("3. Run!");
            while (input != 1 && input != 2 && input != 3) {
                input = scan.nextInt();
            }
            System.out.println("--------------------------------------------");
            System.out.println();

            switch (input) {
                case 1:
                    int dmg = (int) mainChar.attack();
                    System.out.println("You hit the enemy for " + dmg + " damage!");
                    enemy.setHp(enemy.getHp() - dmg);
                    System.out.println(enemy.getCharacterType() + " has " + enemy.getHp() + " HP left");
                    break;
                case 2:
                    boolean HPpot = mainChar.useHealthPotion();
                    if (HPpot) {
                        System.out.println("You healed for " + mainChar.getHealthPotHeal() + ". You now have " + mainChar.getHp() + " HP!");
                    } else
                        System.out.println("No health pots remaining");
                    break;
                case 3:
                    System.out.println("You ran home. Coward!");
                    return 0;
            }
            input = 0;
            if (enemy.getHp() == 0)
                enemyAlive = false;

            if (enemyAlive) {
                System.out.println("The "+ enemy.getCharacterType()+" attacks you for "+ enemy.getAtk()+" damage!");
                mainChar.setHp(mainChar.getHp()- enemy.getAtk());

                if (mainChar.getHp() == 0) {
                    System.out.println("You have fallen in battle!");
                    return 0;
                }
            }
        }
        Random rand = new Random();
        int hpPotionDropChance = rand.nextInt(100);
        if(hpPotionDropChance >= 75){                               //25% drop chance
            System.out.println(ConsoleColors.CYAN+"Enemy dropped a health potion!"+ConsoleColors.RESET);
            mainChar.setNumOfHealthPots(mainChar.getNumOfHealthPots()+1);
        }

        System.out.println("You won the battle!");
        return 1;
    }



    public void chooseTreasure(MainCharacter mainChar){
        Scanner scan = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW+ "------CHOOSE A TREASURE------"+ConsoleColors.RESET);
        System.out.println("1. Cloag of Agility (+2% CRIT DAMAGE)   Current: " + mainChar.getCritDamage()+"%");
        System.out.println("2. Long Sword (+2 ATTACK DAMAGE)   Current: " + mainChar.getAtk()+" AD");
        System.out.println("3. Rejuvenation Beads (+4 HEALTH POT HEAL)   Current: " + mainChar.getHealthPotHeal()+" Heal");
        System.out.println("4. Ruby Crystal (+35 HP)   Current: " + mainChar.getHp()+" HP");
        int input = scan.nextInt();

        switch (input){
            case 1:
                mainChar.setCritDamage(mainChar.getCritDamage()+2);
                break;
            case 2:
                mainChar.setAtk(mainChar.getAtk()+2);
                break;
            case 3:
                mainChar.setHealthPotHeal(mainChar.getHealthPotHeal()+4);
                break;
            case 4:
                mainChar.setHp(mainChar.getHp()+35);
                break;
            default:
                break;
        }
    }

    public void chooseArtifact(MainCharacter mainChar){
        Scanner scan = new Scanner(System.in);

        System.out.println(ConsoleColors.YELLOW+ "------CHOOSE AN ARTIFACT------"+ConsoleColors.RESET);
        System.out.println("1. Infinity Edge (+10% CRIT CHANCE)   Current: " + mainChar.getCritChance()+"%");
        System.out.println("2. Youmuu's Ghostblade (+7 ATTACK DAMAGE)   Current: " + mainChar.getAtk()+" AD");
        System.out.println("3. Ardent Censer (+10 HEALTH POT HEAL)   Current: " + mainChar.getHealthPotHeal());
        System.out.println("4. Warmog's Armor (+150 HP)   Current: " + mainChar.getHp());
        int input = scan.nextInt();

        switch (input){
            case 1:
                mainChar.setCritChance(mainChar.getCritChance()+10);
                break;
            case 2:
                mainChar.setAtk(mainChar.getAtk()+7);
                break;
            case 3:
                mainChar.setHealthPotHeal(mainChar.getHealthPotHeal()+10);
                break;
            case 4:
                mainChar.setHp(mainChar.getHp()+150);
                break;
            default:
                break;
        }
    }
}
