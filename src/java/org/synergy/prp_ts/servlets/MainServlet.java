
package org.synergy.prp_ts.servlets;

import java.io.IOException;
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
        
        
        switch(pageIdentifier){
            case "addVenue"     :   addVenue(request, response);
            break;
            case "addCategory"  :   addCategory(request, response);
            break;
            case "addTrainer"   :   addTrainer(request, response);
            break;
            case "updateVenue"   :   updateVenue(request, response);
            break;
            case "updateCategory"   :   updateCategory(request, response);
            break;
            case "updateTrainer"   :   updateTrainer(request, response);
            break;
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
    
      protected void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = CategoryAdmin.updateCategory(request.getParameter("currentCategoryName"),request.getParameter("newCategoryName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("currentCategoryName", request.getParameter("currentCategoryName"));
            session.setAttribute("newCategoryName", request.getParameter("newCategoryName"));
            session.setAttribute("categoryStatus", "true");
            request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("currentCategoryName", request.getParameter("currentCategoryName"));
            session.setAttribute("newCategoryName", request.getParameter("newCategoryName"));
            session.setAttribute("categoryStatus", "false");
            response.sendRedirect("updateCategory.jsp");
        }
        
    }
    protected void addTrainer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("wcfId"));
        int result = TrainerAdmin.addTrainer(request.getParameter("wcfId"),request.getParameter("trainerName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("wcfId", request.getParameter("wcfId"));
            session.setAttribute("trainerName", request.getParameter("trainerName"));
            session.setAttribute("trainerStatus", "true");
            request.getRequestDispatcher("addTrainer.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("wcfId", request.getParameter("wcfId"));
            session.setAttribute("trainerName", request.getParameter("trainerName"));
            session.setAttribute("trainerStatus", "false");
            response.sendRedirect("addTrainer.jsp");
        }
        
    }

     protected void updateTrainer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = TrainerAdmin.updateTrainer(request.getParameter("wcfId"),request.getParameter("trainerName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("wcfId", request.getParameter("wcfId"));
            session.setAttribute("trainerName", request.getParameter("trainerName"));
            session.setAttribute("trainerStatus", "true");
            request.getRequestDispatcher("updateTrainer.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("wcfId", request.getParameter("wcfId"));
            session.setAttribute("trainerName", request.getParameter("trainerName"));
            session.setAttribute("trainerStatus", "false");
            response.sendRedirect("updateTrainer.jsp");
        }
        
    }
}
