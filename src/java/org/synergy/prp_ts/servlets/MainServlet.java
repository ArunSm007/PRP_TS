
package org.synergy.prp_ts.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.synergy.prp_ts.DAO.AssessmentDao;
import org.synergy.prp_ts.DAO.StreamDao;
import org.synergy.prp_ts.administrators.CategoryAdmin;
import org.synergy.prp_ts.administrators.TrainerAdmin;
import org.synergy.prp_ts.administrators.VenueAdmin;
import org.synergy.prp_ts.beans.AssessmentDetails;
import org.synergy.prp_ts.beans.ModuleDetails;
import org.synergy.prp_ts.beans.StreamDetails;
import org.synergy.prp_ts.beans.SubModuleDetails;
/**
 *
 * @author PraveenKumar
 */
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
            case "addVenue"         :   addVenue(request, response);
            break;
            case "addCategory"      :   addCategory(request, response);
            break;
            case "addTrainer"       :   addTrainer(request, response);
            break;
            case "updateVenue"      :   updateVenue(request, response);
            break;
            case "updateCategory"   :   updateCategory(request, response);
            break;
            case "updateTrainer"    :   updateTrainer(request, response);
            break;
            case "deleteVenue"      :   deleteVenue(request, response);
            break;
            case "deleteCategory"   :   deleteCategory(request, response);
            break;
            case "deleteTrainer"    :   deleteTrainer(request, response);
            break;
            case "addStream"        :   addStream(request, response);
            break;
            case "deleteStream"     :   deleteStream(request, response);
            break;
            case "updateStream"     :   updateStream(request, response);
            break;
        }
    }
    
    protected void updateStream(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    protected void deleteStream(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String streamId = request.getParameter("streamId");
        StreamDao.deleteStream(streamId);
        response.sendRedirect("deleteStream.jsp");
    }
    
    protected void addStream(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String streamName = request.getParameter("streamName");
            String categoryId = request.getParameter("categoryName");
            String jsonString = request.getParameter("jsonString");
            JSONParser jSONParser = new JSONParser();
            JSONArray jSONArray = (JSONArray) ((JSONObject)(jSONParser.parse(jsonString))).get("modules");
            StreamDetails streamDetails = new StreamDetails();
            streamDetails.setStreamName(streamName);
            JSONObject tmpJSONObject;
            JSONArray tmpJSONArray;
            ModuleDetails moduleDetails;
            SubModuleDetails subModuleDetails;
            String assessmentName;
            for(int i = 0;i < jSONArray.size();i++){
                tmpJSONObject = (JSONObject) jSONArray.get(i);
                moduleDetails = new ModuleDetails();
                moduleDetails.setModuleName((String)tmpJSONObject.get("name"));
                assessmentName = ((String)tmpJSONObject.get("assessmentName"));
                if(assessmentName != null){
                    AssessmentDetails assessmentDetails = new AssessmentDetails();
                    assessmentDetails.setAssessmentName(assessmentName);
                    AssessmentDao.setAssessmentDetails(assessmentDetails);
                    moduleDetails.setAssessmentId(assessmentDetails.getAssessmentId());
                }
                tmpJSONArray = (JSONArray) tmpJSONObject.get("subModules");
                if(tmpJSONArray != null){
                    for(int j = 0;j < tmpJSONArray.size();j++){
                        tmpJSONObject = (JSONObject) tmpJSONArray.get(j);
                        subModuleDetails = new SubModuleDetails();
                        subModuleDetails.setSubModuleName((String) tmpJSONObject.get("name"));
                        assessmentName = ((String)tmpJSONObject.get("assessmentName"));
                        if(assessmentName != null){
                            AssessmentDetails assessmentDetails = new AssessmentDetails();
                            assessmentDetails.setAssessmentName(assessmentName);
                            AssessmentDao.setAssessmentDetails(assessmentDetails);
                            subModuleDetails.setAssessmentId(assessmentDetails.getAssessmentId());
                        }
                        moduleDetails.getSubModules().add(subModuleDetails);
                    }
                }
                streamDetails.getModuleDetailses().add(moduleDetails);
            }
            StreamDao.addStream(streamDetails);
            response.sendRedirect("addStream.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
     protected void deleteVenue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = VenueAdmin.deleteVenue(request.getParameter("venueName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("venueName", request.getParameter("venueName"));
            session.setAttribute("venueStatus", "true");
            request.getRequestDispatcher("deleteVenue.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("venueName", request.getParameter("venueName"));
            session.setAttribute("venueStatus", "false");
            response.sendRedirect("deleteVenue.jsp");
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
      
       protected void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = CategoryAdmin.deleteCategory(request.getParameter("categoryName"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("categoryName", request.getParameter("categoryName"));
            session.setAttribute("categoryStatus", "true");
            request.getRequestDispatcher("deleteCategory.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("categoryName", request.getParameter("categoryName"));
            session.setAttribute("categoryStatus", "false");
            response.sendRedirect("deleteCategory.jsp");
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
     
     protected void deleteTrainer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int result = TrainerAdmin.deleteTrainer(request.getParameter("wcfId"));
        
        if(result == 1){
            HttpSession session = request.getSession(false);
            session.setAttribute("wcfId", request.getParameter("wcfId"));
            session.setAttribute("trainerStatus", "true");
            request.getRequestDispatcher("deleteTrainer.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession(false);
            session.setAttribute("wcfId", request.getParameter("wcfId"));
            session.setAttribute("trainerStatus", "false");
            response.sendRedirect("deleteTrainer.jsp");
        }
        
    }

}
