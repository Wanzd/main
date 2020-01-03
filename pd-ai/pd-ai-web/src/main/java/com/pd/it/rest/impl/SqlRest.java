package com.pd.it.rest.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

import javax.inject.Inject;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.model.MapVO;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/sql")
public class SqlRest {
	@Inject
	private SqlSessionFactory factory;

	@RequestMapping(value = "/merge")
	@ResponseBody
	public Object merge(@RequestBody MapVO fo) {
		Configuration configuration = factory.getConfiguration();
		BoundSql boundSql = configuration.getMappedStatement(fo.str("daoId")).getBoundSql(fo);
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		String sql=showSql(configuration,boundSql);
//		MapVO rsVO=new MapVO();
//		rsVO.p("sql",sql);
		return sql;
	}

	private static String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
		String sql = showSql(configuration, boundSql);
		StringBuilder str = new StringBuilder(100);
		str.append(sqlId);
		str.append(":");
		str.append(sql);
		return str.toString();
	}

	private static String showSql(Configuration configuration, BoundSql boundSql) {
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		String sql = boundSql.getSql();
		if (!parameterMappings.isEmpty() && parameterObject != null) {
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
				sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(parameterObject)));

			} else {
				MetaObject metaObject = configuration.newMetaObject(parameterObject);
				for (ParameterMapping parameterMapping : parameterMappings) {
					String propertyName = parameterMapping.getProperty();
					if (metaObject.hasGetter(propertyName)) {
						Object obj = metaObject.getValue(propertyName);
						sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						Object obj = boundSql.getAdditionalParameter(propertyName);
						sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
					} else {
						sql = sql.replaceFirst("\\?", "缺失");
					} // 打印出缺失，提醒该参数缺失并防止错位
				}
			}
		}
		return sql;
	}

	private static String getParameterValue(Object obj) {
		String value = null;
		if (obj instanceof String) {
			value = "'" + obj.toString() + "'";
		} else if (obj instanceof Date) {
			DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
			value = "'" + formatter.format(new Date()) + "'";
		} else {
			if (obj != null) {
				value = obj.toString();
			} else {
				value = "";
			}

		}
		return value;
	}
}
