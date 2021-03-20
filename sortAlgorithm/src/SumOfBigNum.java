public class SumOfBigNum {
    public String sumOfbigNum(int a, int b){
        String num1 = new StringBuilder(String.valueOf(a)).reverse().toString();
        String num2 = new StringBuilder(String.valueOf(b)).reverse().toString();
        StringBuilder sb = new StringBuilder();

        int len = Math.max(num1.length(), num2.length());
        int add = 0, mod = 0;
        for (int i = 0; i < len; i++){
            int numOfOne = i > num1.length() - 1 ? 0 : Integer.valueOf(num1.charAt(i) + "");
            int numOfTwo = i > num2.length() - 1 ? 0 : Integer.valueOf(num2.charAt(i) + "");
            int res = numOfOne + numOfTwo + add;
            add = res / 10;
            mod = res % 10;
            sb.append(mod);
        }
        if (add != 0){
            sb.append(add);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        //String result = new SumOfBigNum().sumOfbigNum(923, 78);
        //System.out.println(result);
        //char a = 3;
        char b = '3';
        String a = b + "";
        System.out.println(Integer.valueOf(b + ""));
    }
}
