package test;

class Cat {
    private static Cat instance;
    private String name;

    // private 생성자
    private Cat(String name) {
        this.name = name;
    }

    // 싱글톤 인스턴스를 얻는 메서드
    public static Cat getInstance(String name) {
        if (instance == null) {
            instance = new Cat(name);
        }
        return instance;
    }

    public void speak() {
        System.out.println(name + " Meow");
    }
}

public class ttest {
    public static void main(String[] args) {

        Cat a = Cat.getInstance("nabi");
        a.speak();

        Cat b = Cat.getInstance("ttugi");
        b.speak();

        // 두 객체가 같은지 확인
        System.out.println(a);
        System.out.println(b);
        System.out.println("a == b: " + (a == b));
    }
}
