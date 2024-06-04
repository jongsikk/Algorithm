import java.util.*;

class programmers최솟값만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] IB = new Integer[B.length];
        for (int i = 0; i < B.length; i++) {
            IB[i] = B[i];
        }
        Arrays.sort(A);
        Arrays.sort(IB, (b1, b2) -> b2 - b1);
        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * IB[i]);
        }
        return answer;
    }
}