package com.huike.report.mapper;

import java.util.List;
import java.util.Map;

import com.huike.report.domain.vo.PieVO;
import com.huike.report.domain.vo.TargetIndexVo;
import org.apache.ibatis.annotations.Param;

import com.huike.clues.domain.vo.IndexStatisticsVo;

/**
 * 首页统计分析的Mapper
 * @author Administrator
 *
 */
public interface ReportMapper {
	/**=========================================基本数据========================================*/
	/**
	 * 获取线索数量
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Integer getCluesNum(@Param("startTime") String beginCreateTime,
						@Param("endTime") String endCreateTime,
						@Param("username") String username);

	/**
	 * 获取商机数量
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Integer getBusinessNum(@Param("startTime") String beginCreateTime,
						   @Param("endTime") String endCreateTime,
						   @Param("username") String username);

	/**
	 * 获取合同数量
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Integer getContractNum(@Param("startTime") String beginCreateTime,
						   @Param("endTime") String endCreateTime,
						   @Param("username") String username);

	/**
	 * 获取合同金额
	 * @param beginCreateTime	开始时间
	 * @param endCreateTime		结束时间
	 * @param username			用户名
	 * @return
	 */
	Double getSalesAmount(@Param("startTime") String beginCreateTime,
						  @Param("endTime") String endCreateTime,
						  @Param("username") String username);

	/**
	 * 用户的线索数量
	 * @param username
	 * @param format 当前时间
	 * @return
	 */


	/**=========================================今日简报========================================*/

	Integer getTodayClue(@Param("username") String username, @Param("format") String format);

	Integer getTodyBusiness(@Param("username")String username, @Param("format")String format);

	Integer getTodayContract(@Param("username")String username, @Param("format")String format);

	Double getTodaySales(@Param("username")String username, @Param("format")String format);

    List<PieVO> subjectStatistics(@Param("beginCreateTime") String beginCreateTime,@Param("endCreateTime") String endCreateTime);

    /**=========================================待办========================================*/
	List<TargetIndexVo> salesStatistic(@Param("beginCreateTime")String beginCreateTime,
									   @Param("endCreateTime")String endCreateTime);

    Integer getToallocatedCluesNum(@Param("startTime") String beginCreateTime, @Param("endTime")String endCreateTime,@Param("username") String username);

	Integer getToallocatedBusinessNum(@Param("startTime")String beginCreateTime, @Param("endTime")String endCreateTime, @Param("username")String username);

	Integer getTofollowedCluesNum(@Param("startTime")String beginCreateTime, @Param("endTime")String endCreateTime, @Param("username")String username);

	Integer getTofollowedBusinessNum(@Param("startTime")String beginCreateTime,@Param("endTime") String endCreateTime, @Param("username")String username);
}
