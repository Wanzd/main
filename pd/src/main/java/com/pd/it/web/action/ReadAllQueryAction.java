package com.pd.it.web.action;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.itf.IAction;
import com.pd.it.common.itf.IDao;

public class ReadAllQueryAction implements IAction {

	@Override
	public Object execute(Object in) {
		IDao dao = Reflects.field(this, "dao");
		return dao.ra(in);
	};

}
