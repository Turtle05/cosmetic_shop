package controller;

import com.google.gson.Gson;
import model.bean.Category;
import model.bo.ShowCatListBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetCategoriesByGroup")
public class GetCategoriesByGroupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryGroupID = request.getParameter("categoryGroupID");

        // Log để kiểm tra servlet có nhận được tham số không
        System.out.println("Received request for categoryGroupID: " + categoryGroupID);

        ShowCatListBO showCategoryBO = new ShowCatListBO();
        List<Category> categories = showCategoryBO.getCategoriesByGroup(categoryGroupID);

        // Log để kiểm tra danh sách categories có được lấy ra không
        System.out.println("Categories fetched: " + categories);

        Gson gson = new Gson();
        String json = gson.toJson(categories);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
