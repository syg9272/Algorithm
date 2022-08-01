import java.util.Scanner;

public class BJ1244 {
	
	static int n;	// 스위치 개수
	static int[] arr;	// 스위치 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	// 스위치 개수를 입력받는다
		arr = new int[n];	// 크기 할당
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();	// 스위치 상태 받아오기
		}
		
		int student = sc.nextInt();
		
		for (int i = 0; i < student; i++) {
			if(sc.nextInt() == 1) {	// 만약 남학생이면
				boy(sc.nextInt());	// boy에 받은 수를 넘겨준다
			}else {	// 여학생이면
				girl(sc.nextInt());	// girl에 받은 수를 넘겨준다
			}
		}
		
		for (int i = 1; i <= n; i++) {    // 결과 출력
            System.out.print(arr[i-1] + " ");
            if(i % 20 == 0) System.out.println();
		}
	}

	static void boy(int num) {
		for (int i = 0; i < n; i++) {	// 배열 모든 인덱스 중
			if((i+1) % num == 0) {	// 받은 수의 배수 인덱스이면 (스위치는 1번부터 시작이므로 i+1)
				change(i);
			}
			
		}
	}
	static void girl(int num) {
		num --;	// 스위치 번호가 인덱스보다 1 크기 때문에 맞춰줌
		change(num); // 받은 위치 스위치
		for (int i = 1; i < n; i++) {
			if((num - i) < 0 || (num + i) >= n) break;	// 인덱스 범위를 넘어가면 반복문 빠져나감
			if(arr[num - i] == arr[num + i]) {	// 만약 대칭일 경우
				change(num + i);	// 오른쪽 인덱스 변경
				change(num - i);	// 왼쪽 인덱스 변경
			}else break;
		}
	}
	
	static void change(int i) {	// 스위치
		if(arr[i] == 1) arr[i] = 0;
		else arr[i] = 1;
	}
}
