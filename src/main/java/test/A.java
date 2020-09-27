package test;

public class A {
    int a;
    {
        System.out.println("A");
    }
    static {
        System.out.println("B");
    }
    public A() {
        System.out.println("C");
    }

    public static void main(String[] args) {
        new A().a();
    }

    public void a() {
        class B {
            public void b() {
                System.out.println("jakas podmetoda");
            }
        }
        B b = new B();
        b.b();
    }
}
