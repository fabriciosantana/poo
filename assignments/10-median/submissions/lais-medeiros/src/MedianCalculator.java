class MedianCalculator {

    public static int findMedian(int a, int b, int c) {

        if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return a;
        }

        else if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        }

        else {
            return c;
        }
    }
}