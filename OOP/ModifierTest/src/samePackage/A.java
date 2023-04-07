package samePackage;

public class A {
    public void _pub() {
        System.out.println("public");
    }

    private void _pri() {
        System.out.println("private");
    }

    protected void _prot() {
        System.out.println("protected");
    }

    void _def() {
        System.out.println("default");
    }

    void a() {
        _pub();
    }

    void b() {
        _pri();
    }

    void c() {
        _prot();
    }

    void d() {
        _def();
    }

    public static void main(String[] args) {
        A test = new A();
        test.a();
        test.b();
        test.c();
        test.d();
    }
}
