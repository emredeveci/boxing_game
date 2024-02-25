
import java.util.Random;

public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    void run() {
        if (isCheck()) {
            //below method assigns a truthy boolean value to the first attacker
            firstAttacker();
            while (this.f1.health > 0 && this.f2.health > 0) {

                if (this.f1.isFirst) {
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                }

                if (this.f2.isFirst) {
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                }

                System.out.println(this.f1.name + " HP is: " + this.f1.health);
                System.out.println(this.f2.name + " HP is: " + this.f2.health);
            }
        } else {
            System.out.println("The weight classes of the fighters are not compatible.");
        }
    }

    boolean isCheck() {
        return ((this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight));
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println("The winner is: " + this.f2.name);
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println("The winner is: " + this.f1.name);
            return true;
        }

        return false;
    }

    //This method generates an integer number between 0 and 1, using a Random method
    void firstAttacker() {
        Random random = new Random();
        int randomNum = random.nextInt(2);

        if (randomNum == 0) {
            this.f1.isFirst = true;
        } else {
            this.f2.isFirst = true;
        }
    }
}
