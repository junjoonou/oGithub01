package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet { //보통 명칭이 동일: add3
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("이미Up 내용을 수정...");
		// request 객체는 add3에서 정보를 담아서 server에 요청, response 객체는 로그인시 웹브라우저에 화면을 꾸며줌
		// TODO Auto-generated method stub
		System.out.println("doGet 여기왔네");
		// Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num->" + num);
		System.out.println("loc->" + loc);
		// 목표: 1부터 누적값 전달
		int sum = 0;
		for (int i = 1; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum->" + sum);
		
		
		// Encoding 적용
		// request.setCharacterEncoding("utf-8"); -> get방식에서는 생략해도 됨
		response.setContentType("text/html;charset=utf-8");
		
		
		// 공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); // 브라우저에 보여주는 out객체임
		out.printf("<h1>1부터 %d까지 합계</h1>",num);
		out.printf("<h4>LOC--> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		
	}
		
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost 여기왔네");
		// 시기 --> request 파라매타 받기 전에 Encoding를 적용해줘야 함(객체를 사용하기 직전에 인코딩 해야 함)
		request.setCharacterEncoding("utf-8");
		// Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num->" + num);
		System.out.println("loc->" + loc);
		// 목표: 1부터 누적값 전달
		int sum = 0;
		for (int i = 1; i<=num; i++) {
			sum += i;
		}
		System.out.println("sum->" + sum);
				
				
		// Encoding 적용(객체를 사용하기 직전에 인코딩 해야 함)
		response.setContentType("text/html;charset=utf-8");
	
		// 공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); // 브라우저에 보여주는 out객체임
		out.printf("<h1>1부터 %d까지 Post 합계</h1>",num);
		out.printf("<h4>LOC--> %s</h4>",loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}
}


