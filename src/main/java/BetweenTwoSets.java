import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 02/01/17.
 * https://www.hackerrank.com/challenges/between-two-sets
 * Though this problem can be solved with bruteforce, there is a nice fast solution.
 is divisible by all numbers of  if and only if it is divisible by their least common multiple. Denote it as .
 All numbers of  are divisible by  if and only if the greatest common divisor of all numbers of  is divisible by . Denote it as .
 Now we have to find the number of  such that  is divisible by  and  is divisible by . If  is not divisible by , no such  exists. Otherwise, we can divide ,  and  by . Now it's just the number of divisors of  which can be found in  time or even faster, where  is the maximum number in the sets.
 In this solution, one need to carefully calculate  as this number could be huge. If  becomes more than , then we need to stop calculating and say that our answer is zero.

 #include <bits/stdc++.h>
 using namespace std;
 #define forn(i,n) for (int i = 0; i < int(n); ++i)

 const int maxc = 100;

 int gcd(int a, int b) {
 while (a && b) {
 if (a >= b)
 a %= b;
 else
 b %= a;
 }
 return a + b;
 }

 int lcm(int a, int b) {
 return (a / gcd(a, b)) * b;
 }

 int main() {
 #ifdef LOCAL
 assert(freopen("test.in", "r", stdin));
 #endif
 int n, m;
 cin >> n >> m;
 int A = 1, B = 0;
 forn (i, n) {
 int x;
 cin >> x;
 A = lcm(A, x);
 if (A > maxc) {
 cout << 0 << '\n';
 return 0;
 }
 }
 forn (i, m) {
 int x;
 cin >> x;
 B = gcd(B, x);
 }
 if (B % A != 0) {
 cout << 0 << '\n';
 return 0;
 }
 B /= A;
 int res = 0;
 for (int i = 1; i * i <= B; ++i) {
 if (B % i == 0) {
 ++res;
 if (i * i != B)
 ++res;
 }
 }
 cout << res << '\n';
 }
 *
 */
public class BetweenTwoSets {

    static int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }

        int a_lcm = a[0];
        for(int a_i=1; a_i < n; a_i++){
            a_lcm = lcm(a_lcm,a[a_i]);
        }

        int b_gcd = b[0];
        for(int b_i=1; b_i < m; b_i++){
            b_gcd = gcd(b_gcd,b[b_i]);
        }

        int multiple = a_lcm, count = 0;
        for(int i = 1; multiple <= b_gcd; ++i) {
            multiple = i * a_lcm;
            if(b_gcd % multiple == 0) count++;
        }
        System.out.println(count);
    }
}
