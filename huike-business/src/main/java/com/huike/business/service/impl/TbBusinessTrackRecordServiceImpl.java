package com.huike.business.service.impl;


import com.huike.business.domain.TbBusiness;
import com.huike.business.domain.TbBusinessTrackRecord;
import com.huike.business.domain.vo.BusinessTrackVo;
import com.huike.business.mapper.TbBusinessMapper;
import com.huike.business.mapper.TbBusinessTrackRecordMapper;
import com.huike.business.service.ITbBusinessTrackRecordService;
import com.huike.clues.domain.TbClue;
import com.huike.common.utils.DateUtils;
import com.huike.common.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商机跟进记录Service业务层处理
 * 
 * @author wgl
 * @date 2021-04-28
 */
@Service
public class TbBusinessTrackRecordServiceImpl implements ITbBusinessTrackRecordService {
    @Autowired
    private TbBusinessMapper businessMapper;
    @Autowired
    private TbBusinessTrackRecordMapper businessTrackRecordMapper;
    /**
     * 新增商机跟进记录
     * @param businessTrackVo
     */
    @Override
    public void add(BusinessTrackVo businessTrackVo) {
        TbBusiness business=new TbBusiness();//商机信息
        BeanUtils.copyProperties(businessTrackVo,business);
        business.setId(businessTrackVo.getBusinessId());
        business.setStatus(TbClue.StatusType.FOLLOWING.getValue());
        TbBusinessTrackRecord businessTrackRecord=new TbBusinessTrackRecord();//商机跟进信息
        BeanUtils.copyProperties(businessTrackVo,businessTrackRecord);
        businessTrackRecord.setCreateTime(DateUtils.getNowDate());
        businessTrackRecord.setCreateBy(SecurityUtils.getUsername());

        businessMapper.updateTbBusiness(business);
        businessTrackRecordMapper.insert(businessTrackRecord);
    }

    @Override
    public List<TbBusinessTrackRecord> selectById(Long id) {
      return businessTrackRecordMapper.selectById(id);
    }
}
