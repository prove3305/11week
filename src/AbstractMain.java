abstract class Animal {
    // 추상 메서드 - 구현이 없다
    abstract void sound();

    // 일반 메서드 - 구현이 있다
    void eat() {
        System.out.println("먹이를 먹습니다.");
    }
}
class Lion extends Animal { //sound 매서드를 구현해야 에러가 안생긴다
    @Override
    void sound() {
        System.out.println("어흥");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("미야옹");
    }
}
public class AbstractMain {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound(); // 출력: 멍멍
        dog.eat();   // 출력: 먹이를 먹습니다.

        Animal cat = new Cat();
        cat.sound(); // 출력: 미야용
        cat.eat();   // 출력: 먹이를 먹습니다.
    }
}