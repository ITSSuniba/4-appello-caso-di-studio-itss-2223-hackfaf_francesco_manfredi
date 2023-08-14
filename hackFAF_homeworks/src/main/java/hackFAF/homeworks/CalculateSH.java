package hackFAF.homeworks;

public class CalculateSH {
    public static int calculateSumOfEvenNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && numbers[i] % 2 == 0) {
                if (numbers[i] > 10 && numbers[i] < 20) {
                    sum += numbers[i] * 2;
                } else if (numbers[i] > 20) {
                    sum += numbers[i] / 2;
                } else {
                    sum += numbers[i];
                }
            }
        }
        return sum;
    }
}
