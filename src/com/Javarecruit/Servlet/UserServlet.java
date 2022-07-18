package com.Javarecruit.Servlet;

import com.Javarecruit.Dao.DaoImpl.ShowDaoImpl;
import com.Javarecruit.Service.HrService;
import com.Javarecruit.Service.ServiceImpl.HrServiceImpl;
import com.Javarecruit.Service.ServiceImpl.ShowServiceImpl;
import com.Javarecruit.Service.ServiceImpl.UserServiceImpl;
import com.Javarecruit.Service.UserService;
import com.Javarecruit.pojo.Hr;
import com.Javarecruit.pojo.Show;
import com.Javarecruit.pojo.User;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        HttpSession session1 = request.getSession();
        HttpSession session=request.getSession();
        String phone = request.getParameter("phone");
        String upwd = request.getParameter("cpwd");
        UserService us=new UserServiceImpl();
        String login = us.login(phone, upwd);
        HrService hs=new HrServiceImpl();
        String login1 = hs.login(phone,upwd);
        //储存用户信息
        User u =us.sessionUser(phone,upwd);
        session.setAttribute("LoginU",u);
        //储存HR信息
        Hr h = hs.SessionH(phone,upwd);
        session.setAttribute("LoginH",h);
        //查询用户信息
        UserServiceImpl usi=new UserServiceImpl();
        List<User> ur=usi.queryAll();
        session.setAttribute("user",ur);
        //跳转页面
        if ("成功".equals(login)){
            session1.setAttribute("phone",phone);
            session1.setAttribute("upwd",upwd);
//           request.getRequestDispatcher("showMore.jsp").forward(request,response);
            out.print("hello");
            response.sendRedirect("TheShow.jsp");
        }else if ("成功".equals(login1)){
            ShowServiceImpl ss = new ShowServiceImpl();
            Integer s = h.getCompanyid();
            List<Show> showComp = ss.showComp(s);
            session.setAttribute("showComp", showComp);
                request.getRequestDispatcher("HrShow.jsp").forward(request,response);
        }else{
            response.sendRedirect("LoginFail.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
