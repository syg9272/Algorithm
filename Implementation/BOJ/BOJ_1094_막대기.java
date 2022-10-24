import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1094_막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		
			int X = Integer.parseInt(br.readLine());
			int len = 64;	// 처음에 가지고 있는 막대 길이 64cm
			int cnt = 1;	// 처음에 가지고 있는 막대 개수 1개
			int minLen = len;	// 처음에 제일 짧은 막대 길이
			int sum = len;	// 처음에 모든 막대 길이의 합 
			while(sum > X) {	// 가지고 있는 막대 길이의 합이 X보다 클 경우에 반복
				if((sum - minLen / 2) >= X) {	// 제일 짧은 막대를 이등분한 걸 버렸을 때 X보다 크거나 같다면
					minLen /= 2;	// 제일 짧은 막대 길이 갱신
					sum -= minLen;	// 막대 길이에서 제일 짧은 막대 이등분한거 빼주기
				} else {	// 제일 짧은 막대를 이등분한 걸 버렸을 때 X보다 작아진다면
					minLen /= 2;	// 제일 짧은 막대 길이 갱신
					cnt ++;	// 막대 개수 한개 늘려주기
				}
			}
			
		System.out.println(cnt);
	}
}
