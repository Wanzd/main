package com.pd.it.base.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = format.format(date);
		gen.writeString(formattedDate);
	}

}