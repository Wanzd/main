package com.pd.it.app.user;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.ICommonService;

@Service
public class PersonRelationService implements ICommonService {

	@Inject
	protected IPersonRelationDao dao;

	@Inject
	protected HttpServletResponse response;

	protected Class exportClass = PersonRelationExportVO.class;

}

class PersonRelationExportVO {
	private String fromPerson;
	private String toPerson;
	private String relTag;

	public String getFromPerson() {
		return fromPerson;
	}

	public void setFromPerson(String fromPerson) {
		this.fromPerson = fromPerson;
	}

	public String getToPerson() {
		return toPerson;
	}

	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}

	public String getRelTag() {
		return relTag;
	}

	public void setRelTag(String relTag) {
		this.relTag = relTag;
	}
}
