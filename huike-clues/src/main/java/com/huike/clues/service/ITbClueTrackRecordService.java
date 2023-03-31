package com.huike.clues.service;


import com.huike.clues.domain.TbClueTrackRecord;
import com.huike.clues.domain.vo.ClueTrackRecordVo;

import java.util.List;

/**
 * 线索跟进记录Service接口
 * 
 * @author WGL
 * @date 2022-04-19
 */
public interface ITbClueTrackRecordService {

    /**
     * 线索跟进记录
     * @param clueId 线索id
     * @return
     */
    List<TbClueTrackRecord> selectById(Long clueId);

    /**
     * 添加跟进记录
     * @param tbClueTrackRecord
     */
    void add(ClueTrackRecordVo tbClueTrackRecord);
}
