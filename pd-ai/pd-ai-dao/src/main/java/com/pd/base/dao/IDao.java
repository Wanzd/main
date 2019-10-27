package com.pd.base.dao;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
public interface IDao<_VO, _FO, _DTO> extends IQuery<_VO, _FO, _DTO>, IUpdate<_VO, _FO, _DTO> {

}
