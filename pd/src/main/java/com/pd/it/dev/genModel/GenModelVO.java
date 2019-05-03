package com.pd.it.dev.genModel;

import com.pd.it.base.itf.Nameable;
import com.pd.it.base.vo.RecordVO;
import com.pd.it.common.util.Formats;

public class GenModelVO extends RecordVO implements Nameable {

	private String name;
	private String type;
	private String comment;

	private String javaType;
	private String javaName;

	private String jdbcName;
	private String jdbcType;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getJavaType() {
		if (type.startsWith("varchar")) {
			return "String";
		}
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaName() {
		return name;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getJdbcName() {
		String jdbcStr=Formats.jdbc(name);
		return jdbcStr;
	}

	public void setJdbcName(String jdbcName) {
		this.jdbcName = jdbcName;
	}

	public String getJdbcType() {
		if (type.startsWith("varchar")) {
			return "VARCHAR";
		}
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
	}

}
