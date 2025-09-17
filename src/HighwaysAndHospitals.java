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

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        int total = 0;
        // Int array that keeps track of each city's root where the index is the city and the int is the root.
        // Make it n + 1 so that there isn't a city at 0.
        int[] roots = new int[n + 1];


        // Edge case for when the hospitals are less expensive than highways, so you build a hospital in each place.
        if (highwayCost > hospitalCost) {
            return ((long) hospitalCost * n);
        }

        // Goes through and sets the new roots.
        for (int i = 1; i <= roots.length; i++) {
            for (int j = 1; j <= cities.length; j++) {
                if (cities[j][0] == roots[i]) {
                    roots[i] = cities[j][1];
                }
            }

        }

        for (int i = 0; i < cities.length; i++) {
            int[] tempCity;


        }

        // This will go through the array after the roots have been sorted and count how many individual ecosystems there are.
        int ecosystemCount = 0;
        // The loop starts at 1 because there is no city labeled 0.
        for (int i = 1; i <= roots.length; i++) {
            if (roots[i] == 0) {
                ecosystemCount++;
            }
        }





        return -1;
    }

    // Recursive function to find the root of the node passed in.
    public static int find(int i, int[] roots) {
        // Base case
        if (roots[i] == 0) {
            return i;
        }

        // Recursive case
        roots[i] = find(roots[i], roots);
        return roots[i];
    }
}
