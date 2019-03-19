package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListX {
	public static <In> List<In> from(Set<In> inSet) {
		List<In> rsList = new ArrayList<In>();
		for (In eachKey : inSet) {
			rsList.add(eachKey);
		}
		return rsList;
	}

	public static <In> List<In> from(In... in) {
		List<In> rsList = new ArrayList<In>();
		for (In eachIn : in) {
			rsList.add(eachIn);
		}
		return rsList;
	}

}
