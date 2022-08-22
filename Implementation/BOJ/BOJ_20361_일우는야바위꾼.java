import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_대전_8반_서예지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 입력받기
		for (int t = 1; t <= T; t++) {	// 테스트 케이스 동안 반복
			st = new StringTokenizer(br.readLine());	
			int N = Integer.parseInt(st.nextToken());	// 종이컵 개수
			int X = Integer.parseInt(st.nextToken());	// 간식이 들어있는 컵 위치
			int K = Integer.parseInt(st.nextToken());	// 스왑 횟수
			int[] cup = new int[N + 1];	// 1번부터 시작하기 때문에 N+1 배열 생성 (컵 배열)
			cup[X] = 1;	// X번째에 간식 넣어놓기
			int a, b, temp;	// 바꾼 두 컵의 위치, 바꾸기 전 컵의 정보 담아놓을 변수
			for (int i = 0; i < K; i++) {	// 스왑 횟수만큼 반복
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(cup[a] == 1 || cup[b] == 1) {	// 입력받은 위치에 간식이 들어있을 때만 스왑하기				
					temp = cup[a];	// 바꾸기 전 미리 담아놓을 변수 (덮어쓰기 때문에 미리 저장해둬야 함)
					cup[a] = cup[b];
					cup[b] = temp;
				}
			}
			for (int i = 0; i <= N; i++) {	// 간식이 들어있는 컵 찾기
				if(cup[i] != 1) continue;	// 간식이 없으면 다음 컵으로 이동
				sb.append("#" + t + " " + i + "\n");	// 간식이 있는 컵을 찾으면 결과 저장하기
				break;	// 반복문 나가기
			}
		}
		System.out.println(sb);	// 결과 출력
	}
}
