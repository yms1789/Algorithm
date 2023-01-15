import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MiddleNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		String [] numArr = br.readLine().split(" ");
		Arrays.sort(numArr);
		int middle = count / 2;
		System.out.println(Integer.parseInt(numArr[middle - 2]));
	}
}

