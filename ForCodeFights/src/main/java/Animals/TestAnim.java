package Animals;

import java.util.ArrayList;

public class TestAnim {
    public static void main(String[] args) {
        ArrayList<Animals> animals = new ArrayList<>();
        Animals dog = new Dog();
        Animals cat = new Cat();
        animals.add(dog);
        animals.add(cat);
        for (Animals creature : animals) {
            System.out.println(creature.say());
        }
    }
}
