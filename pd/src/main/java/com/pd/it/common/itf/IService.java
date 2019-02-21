package com.pd.it.common.itf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestBody;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.Errors;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
public interface IService<_Dao extends IDao> {
	default _Dao getDao() {
		return Reflects.field(this, "dao");
	};

	default Object query(@RequestBody(required = false) FO in) {
		try {
			Method method = getDao().getClass().getMethod(in.str("op"));
			Object invoke = method.invoke(getDao(), in);
			return X.jsonStr(invoke);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return X.jsonStr(Errors.NOT_CATCH);
	}

	default Object save(@RequestBody(required = false) FO in) {
		try {
			Method method = getDao().getClass().getMethod(in.str("op"));
			Object invoke = method.invoke(getDao(), in);
			return X.jsonStr(invoke);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return X.jsonStr(Errors.NOT_CATCH);
	}
}
