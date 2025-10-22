import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VampireNumbers {

    public static boolean isVampire(int v) {
        String vStr = String.valueOf(v);
        int len = vStr.length();

        if (len % 2 != 0) return false; // Must have even number of digits

        int halfLen = len / 2;
        int start = (int) Math.pow(10, halfLen - 1);
        int end = (int) Math.pow(10, halfLen);

        char[] vDigits = vStr.toCharArray();
        Arrays.sort(vDigits);

        for (int x = start; x < end; x++) {
            if (v % x != 0) continue; // x must divide v
            int y = v / x;

            if (y < start || y >= end) continue; // y must have n/2 digits
            if (x % 10 == 0 && y % 10 == 0) continue; // trailing zero rule

            char[] xyDigits = ("" + x + y).toCharArray();
            Arrays.sort(xyDigits);

            if (Arrays.equals(vDigits, xyDigits)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> vampireNumbers = new ArrayList<>();
        int num = 10;

        while (vampireNumbers.size() < 100) {
            if (isVampire(num)) {
                vampireNumbers.add(num);
            }
            num++;
        }

        System.out.println("First 100 Vampire Numbers:");
        vampireNumbers.forEach(System.out::println);
    }
}
