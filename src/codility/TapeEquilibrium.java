/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

/*
A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such taht 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P-1] and A[P], A[P+1], ... P[N-1].
The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P-1]) - (A[P] + A[P+1] + ... + A[N-1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
For example, consider array A such that:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 4
    A[4] = 3
We can split this tape in four places:
    P = 1, difference = |3 - 10| = 7
    P = 2, difference = |4 - 9| = 5
    P = 3, difference = |6 - 7| = 1
    P = 4, difference = |10 - 3| = 7
Write a function:
    int solution(int A[], int N);
    that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.
    For example, given:
        A[0] = 3
        A[1] = 1
        A[2] = 2
        A[3] = 4
        A[4] = 3
    the function should return 1, as explained above.
    Assum that:
        N is an integer within the range [2..100,000];
        each element of array A is an integer within the range [-1,000..1,000].
    Complexity:
        expected worst-case time complexity is O(N);
        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
*/

/**
 *
 * @author jiseonoh
 */
public class TapeEquilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int len = A.length;
        int[] sum = new int[len];
        // get the sum from 0 to n and store it in the sum[n]
        sum[0] = A[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + A[i];
        }
        int min = Math.abs(sum[len-1] - 2 * sum[0]);
        for (int i = 2; i < len; i++) {
            int temp = Math.abs(sum[len-1] - 2 * sum[i-1]);
            if(temp < min) min = temp;
        }
        return min;
    }
}
