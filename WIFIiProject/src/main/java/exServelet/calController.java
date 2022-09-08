package exServelet;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc.do")
public class calController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
                        throws IOException, ServletException {


        int su1= Integer.parseInt(request.getParameter("su1"));
        int su2= Integer.parseInt(request.getParameter("su2"));

        // su1~su2

        int sum=0;
        for(int i=su1; i<=su2; i++){
            sum+=i;
        }

        PrintWriter out = response.getWriter();
        out.println("total: "+sum);



    }

}
