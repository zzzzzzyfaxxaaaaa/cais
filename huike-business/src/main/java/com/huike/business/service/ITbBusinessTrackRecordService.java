package com.huike.business.service;

import com.huike.business.domain.TbBusinessTrackRecord;
import com.huike.business.domain.vo.BusinessTrackVo;

import java.util.List;

/**
 * 商机跟进记录Service接口
 * @date 2021-04-28
 */
public interface ITbBusinessTrackRecordService {

    /**
     * 新增商机跟进记录
     * @param businessTrackVo
     */
    void add(BusinessTrackVo businessTrackVo);

    List<TbBusinessTrackRecord> selectById(Long id);
}
