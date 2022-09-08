package controller;

import model.vo.HistoryDAO;
import model.vo.HistoryVO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;
@WebServlet("/removeOneData")
public class HistoryRemoveOneDataController extends HttpServlet {

    private HistoryDAO historyDAO;

    public HistoryRemoveOneDataController(){
        historyDAO = new HistoryDAO();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, HTTPException {


        int removeId = Integer.parseInt(request.getParameter("deleteIdnumber"));

        historyDAO.removeOneData(removeId);
//
//        response.sendRedirect("/removeOneData");
//
//        System.out.println(removeId);
//
    }


}
