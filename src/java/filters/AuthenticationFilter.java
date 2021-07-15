package filters;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // before, will execute before the servlet
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        String email = (String) session.getAttribute("email");
        if (email == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("login");
            return;
        }

        chain.doFilter(request, response);

        // after will execute after the servlet, during response.
    }

    @Override
    public void destroy() {
    }

}
