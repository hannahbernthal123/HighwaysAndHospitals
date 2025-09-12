import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        int total = hospitalCost * n;
        int[] costs = new int[cities.length];
        // Edge case for when the hospitals are less expensive than highways, so you build a hospital in each place.
        if (highwayCost > hospitalCost) {
            return ((long) hospitalCost * n);
        }

        for (int i = 0; i < cities.length; i++) {
            total -= hospitalCost;
            total += highwayCost;
            costs[i] = total;
        }

        int finalCost = hospitalCost * n;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] < finalCost) {
                finalCost = costs[i];
            }
        }




        return -1;
    }
}
