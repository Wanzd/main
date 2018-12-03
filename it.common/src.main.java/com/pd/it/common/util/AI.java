package com.pd.it.common.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pd.it.common.itf.IBridge;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ISender;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.vo.KV;

public class AI {
	public static <Out> Out c(Class<Out> outClass, Object... in) {
		return ObjectUtil.c(outClass, in);
	}

	public static <Out> Out u(Out inOut, Object... in) {
		return ObjectUtil.u(inOut, in);
	}

	public static BigInteger bigInt(String expression, Map<Object, Object> map) {
		return BigMathUtil.bigInt(expression, map);
	}

	public static <InOut, Attr> InOut s(InOut inOut, String k, Attr v) {
		return ObjectUtil.s(inOut, k, v);
	}

	public static <MsgVO, Sender> String send(MsgVO msgVO, ISender<MsgVO> sender) {
		return sender.send(msgVO);
	}

	public static <In, Out> Out bridge(In in, IBuilder<?, ?>... builders) {
		if (builders == null) {
			return null;
		}
		Object out = in;
		for (IBuilder eachBuilder : builders) {
			if (eachBuilder == null) {
				return null;
			}
			out = eachBuilder.build(out);
		}
		try {
			Out rs = (Out) out;
			return rs;
		} catch (Exception e) {
			LogUtil.err(e);
		}
		return null;
	}

	public static <In, Out> Out bridge(In in, IBridge<In, Out> bridge) {
		return bridge(in, bridge.getBuilders());
	}

	public static <In> In nvl(In in, In defaultValue) {
		return in != null ? in : defaultValue;
	}

	public static <K, V> Map<K, V> map(Map<K, V> map, Object... in) {
		if (map == null) {
			map = new HashMap<K, V>();
		}
		if (in.length % 2 != 0) {
			return map;
		}
		for (int i = 0; i < in.length; i += 2) {
			map.put((K) in[i], (V) in[i + 1]);
		}
		return map;
	}

	public static <K, V> Map<K, V> map(Object... in) {

		return map(new HashMap<K, V>(), in);
	}

	public static Object js(String string) {
		return JsUtil.js(string);
	}

	public static void execute(ITask task) {
		List<ITask> subList = task.sub();
		if (subList != null) {
			for (ITask itTask : subList) {
				itTask.execute();
			}
		} else {
			task.execute();
		}
	}

	public static void task(final ITask task) {
		Thread th = new Thread() {
			@Override
			public void run() {
				List<ITask> subList = task.sub();
				if (subList != null) {
					for (ITask itTask : subList) {
						itTask.execute();
					}
				} else {
					task.execute();
				}
			}
		};
		th.start();
	}

	public static KV kv(String... kvStr) {
		KV kv = new KV();
		for (int i = 0, total = kvStr.length; i < total; i += 2) {
			kv.put(kvStr[i], kvStr[i + 1]);
		}
		return kv;
	}

	public static <In> List<In> list(In... in) {
		List<In> rsList = new ArrayList<In>();
		for (In eachIn : in) {
			rsList.add(eachIn);
		}
		return rsList;
	}

	public static double num(String v) {
		try {
			return Double.valueOf(v.toString());
		} catch (Exception e) {
		}
		return 0;
	}

}
