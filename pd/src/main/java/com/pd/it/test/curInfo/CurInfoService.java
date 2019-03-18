package com.pd.it.test.curInfo;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.service.IQueryService;

@Service
public class CurInfoService implements IQueryService {
	@Override
	public Object executeRa(VO vo) {
		SecurityContext context = SecurityContextHolder.getContext();
		return context.getAuthentication();
	};

}
