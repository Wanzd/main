package com.pd.it.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pd.it.common.vo.VO;

public class PermissionUtil {

	public static boolean check(HttpServletRequest request, VO path) {
		if (true) {
			return true;
		}
		if (request == null) {
			return false;
		}
		HttpSession session = request.getSession();
		if (session == null) {
			return false;
		}
		Object permissionObj = session.getAttribute("permission");

		if (!(permissionObj instanceof HashSet)) {
			return false;
		}
		Set<String> permissionSet = (HashSet<String>) permissionObj;
		String permissionKey = String.format("%s.%s", path.v("module"), path.v("action"));
		return permissionSet.contains(permissionKey);
	}

}
