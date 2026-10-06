class Solution {

    private final String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();

        int billion = num / 1000000000;
        num %= 1000000000;

        int million = num / 1000000;
        num %= 1000000;

        int thousand = num / 1000;
        num %= 1000;

        if (billion > 0) {
            result.append(convert(billion)).append(" Billion ");
        }

        if (million > 0) {
            result.append(convert(million)).append(" Million ");
        }

        if (thousand > 0) {
            result.append(convert(thousand)).append(" Thousand ");
        }

        if (num > 0) {
            result.append(convert(num));
        }

        return result.toString().trim().replaceAll("\\s+", " ");
    }

    private String convert(int num) {
        StringBuilder result = new StringBuilder();

        if (num >= 100) {
            result.append(ones[num / 100]).append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            result.append(tens[num / 10]).append(" ");
            num %= 10;
        }

        if (num > 0) {
            result.append(ones[num]).append(" ");
        }

        return result.toString().trim();
    }
}