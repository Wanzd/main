package com.pd.it.common.util.cmd;

import java.util.ArrayList;
import java.util.List;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.vo.VO;

/**
 * ÃüÁîĞĞ¹¹½¨Æ÷
 * 
 * @author thinkpad
 *
 */
public class CmdBuilder implements IBuilder<VO, VO> {

	private List<CmdVO> cmdList = new ArrayList<CmdVO>();

	@Override
	public VO build(VO in) {
		for (CmdVO cmd : cmdList) {
			cmd.getType().build(in, cmd.getParam());
		}

		return in;
	}

	public void add(CmdVO in) {
		cmdList.add(in);
	}
}
