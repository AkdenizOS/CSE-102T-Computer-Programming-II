package chapter13;

public class TestEdible {
  public static void main(String[] args) {
    Object[] objects = {new Tiger(), new Chicken(), new Apple(),
     new Object(), new Orange(), new Rectangle()};
    for (int i = 0; i < objects.length; i++) {
      if (objects[i] instanceof Edible)
        System.out.println(((Edible)objects[i]).howToEat());

      if (objects[i] instanceof Animal) {
        System.out.println(((Animal)objects[i]).sound());
      }
    }
  }
}

abstract class Animal {
  /** Return animal sound */
  public abstract String sound();
}

class Chicken extends Animal implements Edible {
  @Override
  public String howToEat() {
    return "Chicken: Julienne";
  }
    
  @Override
  public String sound() {
    return "Chicken: GIDAK";
  }
}

class Tiger extends Animal implements Edible {
  @Override
  public String sound() {
    return "Tiger: ROAR";
  }
  @Override
  public String howToEat() {
    return "Tiger: Carefully";
  }
}

abstract class Fruit implements Edible {
  // Data fields, constructors, and methods omitted here
}

class Apple extends Fruit {
  @Override
  public String howToEat() {
    return "Apple: Bite";
  }
}

class Orange extends Fruit {
  @Override
  public String howToEat() {
    return "Orange: Juice";
  }
}
