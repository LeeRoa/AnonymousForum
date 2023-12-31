package JspBoard.process;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JspBoard.dao.BoardListDAO;
import JspBoard.dao.BoardListDAO_Impl;

public class Remake2BusinessLogic implements BusinessLogic {
	
	BoardListDAO dao = new BoardListDAO_Impl();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String post_word = request.getParameter("content");
		String post_id = request.getParameter("post_id");
		String password = request.getParameter("password");
		String title = request.getParameter("title");
		
		System.out.println("포스트 아이디입니다." + post_id);
		System.out.println("니가 입력한 내용임." + post_word);
		System.out.println("니가 입력한 제목임." + title);
		System.out.println("니가 입력한 비번임." + password);
		
		if (dao.remakePost(Integer.parseInt(post_id), password, post_word, title) > 0) {
			return "redirect:" + request.getContextPath() + "/board_list";
		} else {
			return "./notJoin";
		}
	}
}
