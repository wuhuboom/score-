package com.score.system.service;

import java.util.List;
import com.score.system.domain.ScoreSport;

/**
 * 足球列表Service接口
 * 
 * @author score
 * @date 2024-02-01
 */
public interface IScoreSportService 
{
    /**
     * 查询足球列表
     * 
     * @param id 足球列表主键
     * @return 足球列表
     */
    public ScoreSport selectScoreSportById(Long id);

    /**
     * 查询足球列表列表
     * 
     * @param scoreSport 足球列表
     * @return 足球列表集合
     */
    public List<ScoreSport> selectScoreSportList(ScoreSport scoreSport);

    /**
     * 新增足球列表
     * 
     * @param scoreSport 足球列表
     * @return 结果
     */
    public int insertScoreSport(ScoreSport scoreSport);

    /**
     * 修改足球列表
     * 
     * @param scoreSport 足球列表
     * @return 结果
     */
    public int updateScoreSport(ScoreSport scoreSport);

    /**
     * 批量删除足球列表
     * 
     * @param ids 需要删除的足球列表主键集合
     * @return 结果
     */
    public int deleteScoreSportByIds(Long[] ids);

    /**
     * 删除足球列表信息
     * 
     * @param id 足球列表主键
     * @return 结果
     */
    public int deleteScoreSportById(Long id);

    public ScoreSport selectScoreSportBySportId(String sportId);

    public List<ScoreSport> selectScoreSportByTimeStatus(String timeStatus);

    public int deleteScoreSportByTimeStatus(String timeStatus);

    public int deleteScoreSportBySportId (String sportId);
}
