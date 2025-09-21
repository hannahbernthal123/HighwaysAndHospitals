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

        for (int i = 1; i <= n; i++) {
            roots[i] = -1;
        }

        // Edge case for when the hospitals are less expensive than highways, so you build a hospital in each place.
        if (highwayCost > hospitalCost) {
            return ((long) hospitalCost * n);
        }

        // Implementation of union-find and path compression.
        for (int[] highway : highways) {
            // One is the first city of the highway.
            int one = highway[0];
            // Two is the second city of the highway.
            int two = highway[1];

            // These variables represent the roots of each of the nodes in the current highway.
            int root1 = find(one, roots);
            int root2 = find(two, roots);

            // This calculates the order of each of the roots.
            int order1 = roots[root1];
            int order2 = roots[root2];

            // When the roots are not equal, you check which one has a higher order.
            if (root1 != root2) {
                // If root1 has a higher order, you add root2's chain onto root 1 therefore making the root of root2 become root1.
                if (order1 < order2) {
                    roots[root1] += roots[root2] - 1;
                    roots[root2] = root1;
                }
                // Same as above but flipped.
                else {
                    roots[root2] += roots[root1] - 1;
                    roots[root1] = root2;
                }
            }
        }


        // This will go through the array after the roots have been sorted and count how many individual ecosystems there are.
        int ecosystemCount = 0;
        // The loop starts at 1 because there is no city labeled 0.
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] <= 0) {
                ecosystemCount++;
            }
        }

        // Total is the number of hospitals times the number of ecosystems added to the number of highways (# of cities - # of ecosystems).
        long total = (long) ecosystemCount * hospitalCost + (long) highwayCost * (n - ecosystemCount);
        return total;
    }

    // Finds the root of a node using union-find and applies path compression for efficiency.
    public static int find(int i, int[] roots) {
        // Root becomes the city passed in. (When city 1 is passed in, int i = 1 so root = 1).
        int root = i;

        // While the root of the city is greater than 0 (i.e. not itself) you set the current city to the root of the city you were looking at.
        // This allows you to move up the chain to find the top-most root.
        while (roots[root] > 0) {
            root = roots[root];
        }

        // Once you find the top-most root, you go back up the chain, and you set each root in the chain to the top root to compress the lookups.
        while (roots[root] > 0) {
            int temp = roots[root];
            roots[root] = root;
            root = temp;
        }

        // Return the top-most root.
        return root;
    }

}




