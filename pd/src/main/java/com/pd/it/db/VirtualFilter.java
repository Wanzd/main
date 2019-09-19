package com.pd.it.db;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.SpringUtil;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.VO;
import com.pd.it.system.redis.RedisKVService;

@RestController
@RequestMapping("/textarea")
public class VirtualFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI();
		if (url.matches("/.+[.](html|js|png|css|gif|jpg|json)")) {

			RedisKVService redisKV = SpringUtil.getBean("redisKVService", RedisKVService.class);
			VO redisFilterVO = new VO(new Attr("key", "textarea:" + url));
			InputStream in = null;
			try {
				if (redisKV.exists(redisFilterVO)) {
					Object readObj = redisKV.r(redisFilterVO);
					if (readObj != null) {
						String readStr = readObj.toString();
						in = new ByteArrayInputStream(readStr.getBytes());
					}

				} else {
					in = this.getClass().getClassLoader().getResourceAsStream("/web/" + url.substring("/".length()));
				}
				IOUtils.copy(in, arg1.getOutputStream());
			} catch (Exception e) {
				ServletOutputStream os = arg1.getOutputStream();
				os.println("404");
				os.flush();
			} finally {
				IOUtils.closeQuietly(in);
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
