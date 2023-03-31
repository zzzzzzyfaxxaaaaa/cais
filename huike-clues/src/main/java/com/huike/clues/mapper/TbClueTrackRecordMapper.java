package com.huike.clues.mapper;


import com.huike.clues.domain.TbClueTrackRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 线索跟进记录Mapper接口
 * @date 2021-04-19
 */
public interface TbClueTrackRecordMapper {


    List<TbClueTrackRecord> selectById(@Param("clueId") Long clueId);

    void insert(TbClueTrackRecord clueTrackRecord);
}
