package controller;

import apidto.WifiDto;
import model.DAO;
import model.vo.HistoryDAO;
import model.vo.WifiVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;



@WebServlet("/LocationServlet")
public class LocationHistoryController extends HttpServlet {

    private final DAO dao;    // 메모리에 한번에올려놓고 사용하려고
    private final HistoryDAO historyDAO;


    public LocationHistoryController(){
        this.dao = new DAO();
        this.historyDAO = new HistoryDAO();

    }

    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response) throws
            IOException, HTTPException, ServletException {

        /**
         *  1. 클라이언트로부터 얻기  ( lat x , lnt y ( X,Y좌표) )
         *
         */


        Double latDouble = Double.valueOf( request.getParameter("latitude-input"));
        Double lntDouble = Double.valueOf( request.getParameter("longitude-input"));

        System.out.println(latDouble);
        System.out.println(lntDouble);



       List<WifiVO> searchList =  dao.search(latDouble,lntDouble); // 20개가져오고
        System.out.println(searchList);

       historyDAO.save(latDouble,lntDouble); // hisoryDAO에 따로저장을한다.



        // jsp에서 사용
        request.setAttribute("searchList",searchList);// 데이터담기

        /**
         * 포워드
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");// 보내야함
        requestDispatcher.forward(request,response);




    }




}
