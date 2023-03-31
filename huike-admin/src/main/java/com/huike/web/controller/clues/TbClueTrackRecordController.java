package com.huike.web.controller.clues;


import com.huike.clues.domain.TbClue;
import com.huike.clues.domain.TbClueTrackRecord;
import com.huike.clues.domain.vo.ClueTrackRecordVo;
import com.huike.clues.service.ITbClueTrackRecordService;
import com.huike.common.annotation.Log;
import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.common.core.page.TableDataInfo;
import com.huike.common.enums.BusinessType;
import com.huike.common.utils.DateUtils;
import com.huike.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 线索跟进记录Controller
 * @date 2021-04-22
 */
@Slf4j
@RestController
@RequestMapping("/clues/record")
public class TbClueTrackRecordController extends BaseController {
    @Autowired
    private ITbClueTrackRecordService tbClueTrackRecordService;
    /**
     * 查询线索跟进记录列表
     */
    @PreAuthorize("@ss.hasPermi('clues:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestParam("clueId")Long clueId) {
//        List<TbClueTrackRecord> clueTrackRecords=tbClueTrackRecordService.selectById(clueId);
//       return new TableDataInfo(clueTrackRecords,clueTrackRecords.size());
        startPage();
        List<TbClueTrackRecord> clueTrackRecords=tbClueTrackRecordService.selectById(clueId);
        return getDataTable(clueTrackRecords);
    }


    /**
     * 新增线索跟进记录
     */
    @PreAuthorize("@ss.hasPermi('clues:record:add')")
    @Log(title = "线索跟进记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClueTrackRecordVo tbClueTrackRecord) {
        log.info("tbClueTrackRecord:{}",tbClueTrackRecord.toString());
        tbClueTrackRecordService.add(tbClueTrackRecord);
        return AjaxResult.success();
    }
}
