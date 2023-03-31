package com.huike.business.mapper;

import java.util.List;
import com.huike.business.domain.TbBusinessTrackRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 商机跟进记录Mapper接口
 * @date 2021-04-28
 */
public interface TbBusinessTrackRecordMapper {

    void insert(TbBusinessTrackRecord businessTrackRecord);

    List<TbBusinessTrackRecord> selectById(@Param("id") Long id);
}