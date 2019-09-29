package com.pd.it.common.vo;

import lombok.Data;

@Data
public class MailVO {
	private String from, to, cc, bcc;

	private String title, content;
}
