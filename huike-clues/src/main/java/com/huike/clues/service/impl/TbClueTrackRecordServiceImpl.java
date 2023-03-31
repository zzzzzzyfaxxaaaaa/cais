package com.huike.clues.service.impl;


import com.huike.clues.domain.TbClue;
import com.huike.clues.domain.TbClueTrackRecord;
import com.huike.clues.domain.vo.ClueTrackRecordVo;
import com.huike.clues.mapper.TbClueMapper;
import com.huike.clues.mapper.TbClueTrackRecordMapper;
import com.huike.clues.service.ITbClueTrackRecordService;
import com.huike.common.utils.DateUtils;
import com.huike.common.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 线索跟进记录Service业务层处理
 * @date 2022-04-22
 */
@Service
public class TbClueTrackRecordServiceImpl implements ITbClueTrackRecordService {
    @Autowired
    private TbClueTrackRecordMapper tbClueTrackRecordMapper;
    @Autowired
    private TbClueMapper tbClueMapper;
    /**
     * 操作记录
     * @param clueId 线索id
     * @return
     */
    @Override
    public List<TbClueTrackRecord> selectById(Long clueId) {
      return tbClueTrackRecordMapper.selectById(clueId);
    }

    /**
     * 新增线索跟进记录
     * @param tbClueTrackRecord
     */
    @Override
    public void add(ClueTrackRecordVo tbClueTrackRecord) {
        TbClueTrackRecord clueTrackRecord=new TbClueTrackRecord();//跟进记录对象
        BeanUtils.copyProperties(tbClueTrackRecord,clueTrackRecord);
        clueTrackRecord.setCreateTime(DateUtils.getNowDate());//跟进时间
        clueTrackRecord.setCreateBy(SecurityUtils.getUsername());//跟进人
        TbClue clue=new TbClue();//线索信息-用户信息
        BeanUtils.copyProperties(tbClueTrackRecord,clue);
        clue.setId(tbClueTrackRecord.getClueId());
        clue.setStatus(TbClue.StatusType.FOLLOWING.getValue());//跟进中
        tbClueMapper.updateTbClue(clue);
        tbClueTrackRecordMapper.insert(clueTrackRecord);
    }
}
