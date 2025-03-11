package bitManipulation;

public class addBinary {
    public static String addBin(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int c = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int d = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = c + d + carry;
            carry = sum / 2;
            result.append(sum % 2);

        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "1010", b = "1011";  
        System.out.println(addBin(a, b));
    }
}
