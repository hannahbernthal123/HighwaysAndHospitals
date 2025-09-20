import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Hannah Bernthal
 *
 */

public class HighwaysAndHospitals {

    public static long cost(int n, int hospitalCost, int highwayCost, int highways[][]) {
        // Int array that keeps track of each city's root where the index is the city and the int is the root.
        // Make it n + 1 so that there isn't a city at 0.
        int[] roots = new int[n + 1];
        // Go through and make each city have a root of itself;


        // Edge case for when the hospitals are less expensive than highways, so you build a hospital in each place.
        if (highwayCost > hospitalCost) {
            return ((long) hospitalCost * n);
        }


        // Implementation of union-find and path compression.
        for (int i = 0; i < highways.length; i++) {
            // X serves as a temporary holder for the first city of the highway that will move eventually.
            int x = highways[i][0];
            // A is just a shorthand for the first city of the highway.
            int a = highways[i][0];
            // This goes up the chain of roots until you find the top most root of City 1.
            while (roots[x] != 0) {
                x = i;
            }
            // This uses path compression to set City 1's root to be the top-most root (x).
            while (roots[a] != 0) {
                int temp = roots[a];
                roots[a] = x;
                a = temp;
            }
        }


        // This will go through the array after the roots have been sorted and count how many individual ecosystems there are.
        int ecosystemCount = 0;
        // The loop starts at 1 because there is no city labeled 0.
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] == 0) {
                ecosystemCount++;
            }
        }

        // Total is the number of hospitals times the number of ecosystems added to the number of highways (# of cities - # of ecosystems).
        long total = (long) ecosystemCount * hospitalCost + (long) highwayCost *(n - ecosystemCount);

        return total;
    }

}
