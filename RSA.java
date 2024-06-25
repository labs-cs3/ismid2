#include<stdio.h>
#include<stdlib.h>

int modfun(int a, int n, int b) {
    if (b == 1) {
        return a % n;
    } else {
        return ((a % n) * modfun(a, n, b - 1)) % n;
    }
}

int gcd(int a, int b) {
    if (a == 0) {
        return b;
    } else if (b == 0) {
        return a;
    } else if (a == b) {
        return a;
    } else if (a > b) {
        return gcd(a - b, b);
    } else {
        return gcd(a, b - a);
    }
}

int totient(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (gcd(n, i) == 1) {
            count++;
        }
    }
    return count;
}

void main() {
    int a, b, n, e, d, phi, m;
    int em, dm;

    printf("Enter two prime numbers: ");
    scanf("%d %d", &a, &b);

    n = a * b;
    phi = totient(n);
    printf("%d\n", phi);
    /* phi = (a-1)*(b-1); */

    printf("Enter e value: ");
    scanf("%d", &e);

    if (0 < e && e < n && gcd(e, phi) == 1) {
        for (int i = 2; i < n; i++) {
            if ((e * i) % phi == 1) {
                printf("d value is: %d\n", i);
                d = i;
                break;
            }
        }

        printf("KU {%d %d}\n", e, n);
        printf("KR {%d %d}\n", d, n);

        printf("Enter message: ");
        scanf("%d", &m);

        em = modfun(m, n, e);
        dm = modfun(em, n, d);

        printf("Encrypted message: %d\n", em);
        printf("Decrypted message: %d\n", dm % n);
    } else {
        printf("Invalid e value\n");
    }
}
RSA
