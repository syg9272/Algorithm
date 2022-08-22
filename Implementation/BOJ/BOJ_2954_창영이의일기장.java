import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algo2_대전_8반_서예지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split("");	// 입력받은 문자열에 대해 문자 하나하나, 공백도 포함해서 배열에 담아두기
		for (int i = 0; i < str.length; i++) {	// 배열을 돌면서
			if(str[i].equals("a") || str[i].equals("e") || 	
					str[i].equals("i") || str[i].equals("o") || str[i].equals("u")) {	// 모음이 있을 경우
				sb.append(str[i]);	// 해당 문자 저장해두고
				i += 2;	// 인덱스를 두칸 더 뒤로 보낸다 (해당 인덱스 뒤에 두개는 p와 해당 문자가 있기 때문에 저장할 필요가 없음)
			}else sb.append(str[i]);	// 모음이 아니면 그냥 해당 문자 저장
		}
		System.out.println(sb);	// 결과 출력
	}
}
