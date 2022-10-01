import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4948_베르트랑공준 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			int ans = 0;
			if(n == 1) {
				sb.append(1 + "\n");
				continue;
			}
			
			for (int i = n + 1; i <= 2 * n; i ++) {
				if(i % 2 == 0) continue;  // 짝수는 무시
				boolean isPrime = true;
				for (int j = 2; j * j <= i; j ++) {
					if(i % j == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) ans++;
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
