// Java program to find minimum 
// swaps required to club all 
// elements less than or equals 
// to k together 

import java.lang.*;

class Solution1 {

    // Utility function to find minimum swaps
// required to club all elements less than 
// or equals to k together 
    static int minSwap(int arr[], int n, int k) {

        // Find sortAndCount of elements which are
        // less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current
        // window of size 'sortAndCount'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of
        // current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement sortAndCount of previous window
            if (arr[i] > k)
                --bad;

            // Increment sortAndCount of current window
            if (arr[j] > k)
                ++bad;

            // Update ans if sortAndCount of 'bad'
            // is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.println(minSwap(arr, n, k));

        int arr1[] = {2, 7, 9, 5, 8, 7, 4};
        n = arr1.length;
        k = 5;
        System.out.println(minSwap(arr1, n, k));

        int[] arr2 = {2255, 6353, 7832, 9990, 516, 9853, 7018, 3337, 3008, 6158, 679, 2954, 2024, 2807, 1944, 6596, 7992, 2942, 9355, 788, 65, 2966, 9276, 1064, 1112, 6197, 4615, 8140, 30, 478, 5360, 7585, 8853, 9481, 1099, 8781, 9514, 4603, 8209, 7455, 5225, 6740, 4734, 4942, 4475, 4995, 4086, 6448, 1408, 2446, 4675, 92, 4942, 7421, 6302, 8226, 431, 2463, 5762, 2681, 1877, 2121, 3450, 5930, 9743, 5045, 9977, 906, 9293, 5441, 6825, 3244, 7021, 3910, 7866, 1013, 8227, 7926, 9226, 8710, 7088, 7761, 3413, 4200, 1671, 4526, 9890, 9594, 257, 3212, 8341, 9641, 2060, 5072, 2776, 4084, 4988, 501, 4304, 3685, 5424, 5713, 7920, 3115, 187, 3915, 3971, 7755, 8802, 4439, 8104, 5610, 5007, 1348, 4449, 9993, 17, 6395, 5539, 3415, 6500, 9899, 9049, 8197, 1419, 7112, 5823, 4739, 7975, 6915, 5852, 4072, 1694, 4353, 8867, 7362, 3410, 8415, 4060, 1353, 2342, 1712, 9038, 5421, 5772, 9291, 1611, 2822, 7927, 9644, 9236, 6052, 9592, 2206, 28, 3772, 1694, 2085, 6137, 4683, 655, 4604, 4979, 1948, 661, 9333, 6319, 257, 8146, 5744, 3533, 6508, 6792, 338, 5507, 4191, 7116, 8174, 1577, 1045, 3337, 86, 5667, 9341, 1606, 558, 7382, 8198, 7954, 225, 7154, 7780, 1290, 1269, 9782, 5909, 6713, 3605, 5672, 8661, 6988, 4669, 1954, 7852, 5580, 5893, 6242, 9970, 2892, 4471, 4272, 3072, 8475, 9925, 8930, 442, 5873, 1128, 2204, 2384, 3532, 970, 3543, 448, 4699, 2630, 7742, 1563, 1626, 3552, 3030, 3124, 4535, 650, 5330, 3862, 3799, 3011, 7809, 9538, 4567, 6431, 5775, 6903, 6675, 7459, 5750, 4193, 9102, 3352, 4107, 1483, 7454, 8293, 5044, 9638, 4995, 5558, 9882, 2316, 2614, 9934, 9669, 1486, 762, 4598, 883, 3279, 6893, 1958, 9703, 7636, 5217, 8460, 3711, 2173, 1677, 9273, 1191, 7967, 6001, 9935, 7241, 2552, 4373, 8518, 2801, 3310, 839, 3715, 7410, 2663, 2894, 1335, 8993, 4987, 6888, 4139, 4324, 4024};
        n = arr2.length;
        k = 1732;
        System.out.println(minSwap(arr2, n, k));
    }
}

// This code is contributed by Anant Agarwal. 
