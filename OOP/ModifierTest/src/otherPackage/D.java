package otherPackage;

import samePackage.A;

public class D {
    A test = new A();

    void a() {
        test._pub();
    }

    void b() {
        test._pri();
    }

    void c() {
        test._prot();
    }

    void d() {
        test._def();
    }
}
