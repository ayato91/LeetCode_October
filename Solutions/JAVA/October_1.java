class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Keeping track of all the mod values which are encountered
        int[] frequency = new int[k];

        for (int num : arr) {
            // Calculating the remainder and correcting it if negative
            int correctedRem = (num % k + k) % k;

            // Updating the mod frequency
            frequency[correctedRem]++;
        }

        // Checking if remainder 0 can form pairs (for that its frequency must be even)
        if (frequency[0] % 2 != 0) {
            return false;
        }

        // Checking if other remainder pairs (i, k-i) have equal frequencies
        for (int i = 1; i <= k / 2; i++) {
            if (frequency[i] != frequency[k - i]) {
                return false;
            }
        }

        // If all the conditions are satisfied, then return true
        return true;
    }
}