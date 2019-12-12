package greedy;

public class RowSeats {
    public int seats(String A) {
        int countOccupied = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                countOccupied++;
            }
        }

        int currentOccupied = 0;
        for (int i = 0; i < countOccupied; i++) {
            if (A.charAt(i) == 'x') {
                currentOccupied++;
            }
        }

        int minimumSwaps = countOccupied - currentOccupied;
        int i = 1;
        int j = countOccupied;

        while (i < j && j < A.length()) {
            if (A.charAt(i - 1) == 'x') {
                currentOccupied--;
            }
            if (A.charAt(j) == 'x') {
                currentOccupied++;
            }
            int currentSwap = countOccupied - currentOccupied;
            minimumSwaps = Math.min(minimumSwaps, currentSwap);
            i++;
            j++;
        }
        return minimumSwaps;
    }

    public static void main(String[] args) {
        RowSeats rowSeats = new RowSeats();
        System.out.println(rowSeats.seats("....x..xx...x.."));
    }
}
