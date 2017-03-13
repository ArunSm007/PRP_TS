
package org.synergy.prp_ts.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.synergy.prp_ts.administrators.CategoryAdmin;
import org.synergy.prp_ts.administrators.TrainerAdmin;
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
        else if(pageIdentifier.equals("addCategory")){
            addCategory(request, response);
        }
        else if(pageIdentifier.equals("addTrainer")){
            addTrainer(request, response);
        }
        else if(pageIdentifier.equals("updateVenue")){
            updateVenue(request, response);
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
    
     protected void updateVenue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = VenueAdmin.updateVenue(request.getParameter("currentVenueName"),request.getParameter("newVenueName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("currentVenueName", request.getParameter("currentVenueName"));
            session.setAttribute("newVenueName", request.getParameter("newVenueName"));
            session.setAttribute("venueStatus", "true");
            request.getRequestDispatcher("updateVenue.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("currentVenueName", request.getParameter("currentVenueName"));
            session.setAttribute("newVenueName", request.getParameter("newVenueName"));
            session.setAttribute("venueStatus", "false");
            response.sendRedirect("updateVenue.jsp");
        }
        
    }
    
    protected void addCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = CategoryAdmin.addCategory(request.getParameter("categoryName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("categoryName", request.getParameter("categoryName"));
            session.setAttribute("categoryStatus", "true");
            request.getRequestDispatcher("addCategory.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("categoryName", request.getParameter("categoryName"));
            session.setAttribute("categoryStatus", "false");
            response.sendRedirect("addCategory.jsp");
        }
        
    }
    
    protected void addTrainer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = TrainerAdmin.addTrainer(request.getParameter("trainerId"),request.getParameter("trainerName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("trainerId", request.getParameter("trainerId"));
            session.setAttribute("trainerName", request.getParameter("trainerName"));
            session.setAttribute("trainerStatus", "true");
            request.getRequestDispatcher("addTrainer.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("trainerId", request.getParameter("trainerId"));
            session.setAttribute("trainerName", request.getParameter("trainerName"));
            session.setAttribute("trainerStatus", "false");
            response.sendRedirect("addTrainer.jsp");
        }
        
    }

}
