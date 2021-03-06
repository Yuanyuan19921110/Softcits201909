package catchup_5;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BinaryNumbers {

	

	// 使用迭代的方式将十进制转化二进制
	static String myToBinaryString(int n) {

		int shang = n / 2;
		int yu = n % 2;
		String s = Integer.toString(yu);
		if (shang != 0) {
			 s = myToBinaryString(shang) + s;
		}

		return s;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		// integer转化为二进制
        // String str = Integer.toBinaryString(n);
        String str = myToBinaryString(n);

        // String转化为char
        char[] c_arr = str.toCharArray();

        int max_consecutive = 0;
        int tmp_consecutive = 0;
        for (int i = 0; i < c_arr.length; i++) {
            if (c_arr[i] == '1') {
                tmp_consecutive++;
                if (tmp_consecutive > max_consecutive)
                    max_consecutive = tmp_consecutive;
            } else {
                tmp_consecutive = 0;
            }
        }
        System.out.println(max_consecutive);

        scanner.close();
	}
}
