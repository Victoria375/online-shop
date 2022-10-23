package app.lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product_servlet")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double cost = 0;
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            Product product = new Product(i, i, cost + (int) (Math.random() * 100));
            resp.getWriter().printf("<h1>Product %s cost = %s </h1>\n", product.title, product.cost);
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();

    }

}


