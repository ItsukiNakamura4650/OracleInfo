package memo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberDTO;
import dao.DAOException;

@WebServlet("/memo_servlet/*")
public class MemoController {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		System.out.println("doPost()メソッド入場");


		String url = request.getRequestURI();		//リクエストアドレス
		System.out.println("URL: " + url);
		String context = request.getContextPath();	//プロジェクト名
		System.out.println("Context: " + context);

		String idx = request.getParameter("idx");
		String writer = request.getParameter("writer");
		String purpose = request.getParameter("purpose");
		String location = request.getParameter("location");
		String attendee = request.getParameter("attendee");
		String memo = request.getParameter("memo");
		String conclusion = request.getParameter("conclusion");
		String post_date = request.getParameter("post_date");



		try {
			MemoDAO memoDao = new MemoDAO();
			Map<String, String> map = new HashMap<>();

//			urlにlist.doという文字列がなければ-1をリターンするindexOf()メソッド
//			会員情報全件取得
//			インデックスが31を返すので、-1ではない(list.doという文字列はurlの31番目にある)
			if(url.indexOf("list.do") != -1) {
				System.out.println("list.do処理開始");
//				DAOの全検索メソッドを使い、議事録情報をサーブレットに持ってくる
				map = memoDao.memberList();
//				リストをリクエストスコープに格納してjspに送る準備をする
				request.setAttribute("memoList", memberList);

//				ページ移動
				String page = "/memo/list.jsp";
				goToPage(request, response, page);
				System.out.println("list.do処理終了");
			}else if (url.indexOf("join.do") != -1) {
				System.out.println("join.do処理開始");
//				エラーチェック(データ入力に異常があればfalse、異常がなければtrueを返してくる)
				boolean bRet = dataValidation(request,response,writer,purpose,location,attendee,memo,conclusion,post_date);
				if(bRet == false) return;

//				mapに画面から取得したパラメータをセットする
				map.put(writer, writer);
				map.put(purpose, purpose);
				map.put(location, location);
				map.put(attendee, attendee);
				map.put(memo, memo);
				map.put(conclusion, conclusion);
				map.put(post_date, post_date);

//				レコードの追加
				memoDao.insert(map);

//				リクエストを送らずにページ移動
				response.sendRedirect(context + "/memo_servlet/list.do");
				System.out.println("join.do処理終了");
			}else if (url.indexOf("detail.do") != -1) {
				System.out.println("detail.do処理開始");
				System.out.println("詳細画面で表示するユーザーのID: " + idx);

//				画面から受け取ったIDをもとに詳細画面を表示するユーザーの詳細情報をDBからもってくる
				MemberDTO memberDto = memoDao.memberDetail(idx);

				request.setAttribute("memberDto", memberDto);
				String page = "/member/detail.jsp";
				goToPage(request, response, page);
				System.out.println("detail.do処理終了");

			}else if (url.indexOf("update.do")!= -1) {
				System.out.println("update.do処理開始");
//				エラーチェック(データ入力に異常があればfalse、異常がなければtrueを返してくる)
				boolean bRet = dataValidation(request,response,writer,purpose,location,attendee,memo,conclusion,post_date);
				if(bRet == false) return;

//				MemberDTOに画面から取得したパラメータをセットする
				MemberDTO memberDto
					= new MemberDTO(userId ,password, name, gender, birthday, job, tel, email, address);

				memoDao.update(memberDto);

				response.sendRedirect(context + "/memo_servlet/list.do");
				System.out.println("update.do処理終了");
			}else if (url.indexOf("delete.do")!= -1) {
				System.out.println("delete.do処理開始");

				memoDao.delete(idx);

				response.sendRedirect(context + "/memo_servlet/list.do");
				System.out.println("delete.do処理終了");
			}
		}catch(DAOException e) {
			e.printStackTrace();
//			画面に表示するエラー
			request.setAttribute("message", "内部エラーが発生しました。");
			goToPage(request, response, "/common/errInternal.jsp");
			return;
		}
	}

//	ページ移動メソッド
	private void goToPage(HttpServletRequest request,
			HttpServletResponse response, String page)
					throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	
}
