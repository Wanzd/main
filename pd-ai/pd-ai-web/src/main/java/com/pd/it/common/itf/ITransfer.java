package com.pd.it.common.itf;

public interface ITransfer<From, To> {
	To transform(From in);
}
