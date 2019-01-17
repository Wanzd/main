package com.pd.it.common;

import org.junit.Test;

import Jama.Matrix;

public class JamaTest {

	@Test
	public void testJama() {
		double[][] person = new double[][] { { 1, 2 }, { 2, 1 } };
		Matrix personMatrix = new Matrix(person);
		double[][] person2 = new double[][] { { 1, 2 }, { 2, 1 } };
		Matrix person2Matrix = new Matrix(person2);

		double[][] attr = new double[][] { { 1, 2, 3 }, { 2, 1, 3 }, { 1, 1, 3 } };
		Matrix attrMatrix = new Matrix(attr);

		System.out.println(personMatrix.det());
		System.out.println(attrMatrix.det());
		personMatrix.plus(person2Matrix).print(4, 0);
		personMatrix.times(person2Matrix).print(3, 0);
	}
}
