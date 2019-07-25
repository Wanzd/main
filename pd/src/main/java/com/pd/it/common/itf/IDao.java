package com.pd.it.common.itf;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
public interface IDao<_VO, _FO, _DTO> extends IQueryDao<_VO, _FO, _DTO>, IUpdateDao<_VO, _FO, _DTO> {

}
