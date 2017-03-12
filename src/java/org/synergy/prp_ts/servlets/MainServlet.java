
package org.synergy.prp_ts.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.synergy.prp_ts.administrators.VenueAdmin;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String pageIdentifier = request.getParameter("action");
        
        if(pageIdentifier.equals("addVenue")){
            addVenue(request, response);
        }
    }
    
    protected void addVenue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = VenueAdmin.addVenue(request.getParameter("venueName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("venueName", request.getParameter("venueName"));
            session.setAttribute("venueStatus", "true");
            request.getRequestDispatcher("addVenue.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("venueName", request.getParameter("venueName"));
            session.setAttribute("venueStatus", "false");
            response.sendRedirect("addVenue.jsp");
        }
        
    }

}
