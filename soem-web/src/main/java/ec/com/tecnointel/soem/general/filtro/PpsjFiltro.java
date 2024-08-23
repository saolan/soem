package ec.com.tecnointel.soem.general.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;

@WebFilter("/ppsj/*")
public class PpsjFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PersUsua persUsua = (PersUsua) ((HttpServletRequest) request).getSession().getAttribute("persUsua");

		if (persUsua == null) {

			((HttpServletResponse) response).sendRedirect("../accesoRestringido.xhtml");
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
