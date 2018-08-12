/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;

        // this pass ensures that ppl with index afer candidate can't be candidate,
        // because someone(candidate) does not know this person
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
      // this pass check if ppl before candidate do know candidate and candidate do not know him/her
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}
