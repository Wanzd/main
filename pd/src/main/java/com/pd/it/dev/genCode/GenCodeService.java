package com.pd.it.dev.genCode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pd.it.common.util.Formats;
import com.pd.it.common.util.x.Trans;
import com.pd.it.common.vo.VO;
import com.pd.it.dev.genModel.GenModelVO;
import com.pd.it.web.itf.service.ICommonService;

@Service
public class GenCodeService implements ICommonService {

	@Override
	public Object executeRa(VO vo) {
		List<GenCodeVO> rsList = new ArrayList<>();

		rsList.add(_getJavaVOFileVO(vo));// 获取Java VO代码

		rsList.add(_getMybatisSelectFileVO(vo));// 获取Mybatis 查询代码
		rsList.add(_getMybatisCreateFileVO(vo));// 获取Mybatis 插入代码
		rsList.add(_getMybatisUpdateFileVO(vo));// 获取Mybatis 修改代码
		return rsList;
	}

	private GenCodeVO _getMybatisUpdateFileVO(VO vo) {
		GenCodeVO genCodeVO = new GenCodeVO();
		genCodeVO.setFileName("mybatisUpdateFile");
		StringBuffer sBuffer = new StringBuffer();
		List<Object> modelList = (List) vo.v("model");
		List<GenModelVO> modelVOList = Trans.list(modelList, GenModelVO.class);

		for (GenModelVO eachVO : modelVOList) {
			sBuffer.append(Formats.freeMark("\t${mybatisName}=#{${javaName},jdbcType=${jdbcType}};\r\n", eachVO));
		}
		genCodeVO.setContent(sBuffer.toString());
		return genCodeVO;
	}

	private GenCodeVO _getMybatisCreateFileVO(VO vo) {
		GenCodeVO genCodeVO = new GenCodeVO();
		genCodeVO.setFileName("mybatisCreateFile");
		StringBuffer sBuffer = new StringBuffer();
		List<Object> modelList = (List) vo.v("model");
		List<GenModelVO> modelVOList = Trans.list(modelList, GenModelVO.class);

		sBuffer.append("insert into X(");
		for (GenModelVO eachVO : modelVOList) {
			sBuffer.append(Formats.freeMark("\t${mybatisName},\r\n", eachVO));
		}
		sBuffer.append(")values(");
		for (GenModelVO eachVO : modelVOList) {
			sBuffer.append(Formats.freeMark("\t${javaName},\r\n", eachVO));
		}
		sBuffer.append(");");
		genCodeVO.setContent(sBuffer.toString());
		return genCodeVO;
	}

	private GenCodeVO _getMybatisSelectFileVO(VO vo) {
		GenCodeVO genCodeVO = new GenCodeVO();
		genCodeVO.setFileName("mybatisSelectFile");
		StringBuffer sBuffer = new StringBuffer();
		List<Object> modelList = (List) vo.v("model");
		List<GenModelVO> modelVOList = Trans.list(modelList, GenModelVO.class);

		for (GenModelVO eachVO : modelVOList) {
			sBuffer.append(Formats.freeMark("\t${mybatisName} as \"${javaName}\";\r\n", eachVO));
		}
		genCodeVO.setContent(sBuffer.toString());
		return genCodeVO;
	}

	private GenCodeVO _getJavaVOFileVO(VO vo) {
		GenCodeVO genCodeVO = new GenCodeVO();
		genCodeVO.setFileName("voFile");
		StringBuffer sBuffer = new StringBuffer();
		List<Object> modelList = (List) vo.v("model");
		List<GenModelVO> modelVOList = Trans.list(modelList, GenModelVO.class);

		for (GenModelVO eachVO : modelVOList) {
			sBuffer.append(Formats.freeMark("\tprivate ${javaType} ${javaName};\r\n", eachVO));
		}
		genCodeVO.setContent(sBuffer.toString());
		return genCodeVO;
	};

}
