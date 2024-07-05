package controller;

import com.google.gson.Gson;
import model.bean.Category;
import model.bo.ShowCategoryBO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetCategoriesByGroupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryGroupID = request.getParameter("categoryGroupID");
        
        ShowCategoryBO showCategoryBO = new ShowCategoryBO();
        List<Category> categories = showCategoryBO.getCategoriesByGroup(categoryGroupID);
        

        // Chuyển đổi danh sách category thành chuỗi JSON
        Gson gson = new Gson();
        String json = gson.toJson(categories);

        // Gửi chuỗi JSON như phản hồi
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}






