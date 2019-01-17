package com.pd.it.common;

import org.junit.Test;

import com.pd.it.common.util.Format;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.VO;

import junit.framework.TestCase;

public class FreemarkerTest extends TestCase {

	@Test
	public void testStr2Number() {
		VO vo = new VO(new Attr("v1", 1000), new Attr("v2", "1000"), new Attr("s2", "1.000"));
		// assertEquals("1000", Format.freeMark("'${v1?number}'", vo));
		assertEquals("1000", Format.freeMark("${v1?c}", vo));
		assertEquals("1,000", Format.freeMark("${s1?number}", vo));
		assertEquals("1000", Format.freeMark("${s1?number?c}", vo));
		assertEquals("1,000", Format.freeMark("${s2?number}", vo));
		assertEquals("1000", Format.freeMark("${s2?number?c}", vo));
	}
}
