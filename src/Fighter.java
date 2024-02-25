public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;
    boolean isFirst;

    Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
        this.isFirst = false;
    }

    int hit(Fighter opponent) {
        if(opponent.isDodge()){
            System.out.println(opponent.name + " dodged the attack.");
            return opponent.health;
        }
        if (opponent.health - this.damage < 0) {
            System.out.println("The fight is over.");
            return 0;
        }
        System.out.println(this.name + " inflicted " + this.damage + " damage on " + opponent.name);
        return opponent.health - this.damage;
    }

    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }
}
