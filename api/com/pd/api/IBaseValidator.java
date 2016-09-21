package com.pd.api;

import java.util.List;

public interface IBaseValidator<VO, FilterVO>
{
    List<VO> list(FilterVO filterVO);
}
