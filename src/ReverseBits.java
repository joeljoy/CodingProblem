public class ReverseBits {
    public long reverse(long a) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((a & (1 << i)) != 0) {
                result |= 1;
            }
        }
        return result;
    }
}
