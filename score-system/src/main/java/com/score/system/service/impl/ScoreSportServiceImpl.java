package com.score.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.score.system.mapper.ScoreSportMapper;
import com.score.system.domain.ScoreSport;
import com.score.system.service.IScoreSportService;

/**
 * 足球列表Service业务层处理
 * 
 * @author score
 * @date 2024-02-01
 */
@Service
public class ScoreSportServiceImpl implements IScoreSportService 
{
    @Autowired
    private ScoreSportMapper scoreSportMapper;

    /**
     * 查询足球列表
     * 
     * @param id 足球列表主键
     * @return 足球列表
     */
    @Override
    public ScoreSport selectScoreSportById(Long id)
    {
        return scoreSportMapper.selectScoreSportById(id);
    }

    /**
     * 查询足球列表列表
     * 
     * @param scoreSport 足球列表
     * @return 足球列表
     */
    @Override
    public List<ScoreSport> selectScoreSportList(ScoreSport scoreSport)
    {
        return scoreSportMapper.selectScoreSportList(scoreSport);
    }

    /**
     * 新增足球列表
     * 
     * @param scoreSport 足球列表
     * @return 结果
     */
    @Override
    public int insertScoreSport(ScoreSport scoreSport)
    {
        return scoreSportMapper.insertScoreSport(scoreSport);
    }

    /**
     * 修改足球列表
     * 
     * @param scoreSport 足球列表
     * @return 结果
     */
    @Override
    public int updateScoreSport(ScoreSport scoreSport)
    {
        return scoreSportMapper.updateScoreSport(scoreSport);
    }

    /**
     * 批量删除足球列表
     * 
     * @param ids 需要删除的足球列表主键
     * @return 结果
     */
    @Override
    public int deleteScoreSportByIds(Long[] ids)
    {
        return scoreSportMapper.deleteScoreSportByIds(ids);
    }

    /**
     * 删除足球列表信息
     * 
     * @param id 足球列表主键
     * @return 结果
     */
    @Override
    public int deleteScoreSportById(Long id)
    {
        return scoreSportMapper.deleteScoreSportById(id);
    }

    @Override
    public ScoreSport selectScoreSportBySportId(String sportId) {
        return scoreSportMapper.selectScoreSportBySportId(sportId);
    }

    @Override
    public List<ScoreSport> selectScoreSportByTimeStatus(String timeStatus) {
        return scoreSportMapper.selectScoreSportByTimeStatus(timeStatus);
    }

    @Override
    public int deleteScoreSportByTimeStatus(String timeStatus) {
        return scoreSportMapper.deleteScoreSportByTimeStatus(timeStatus);
    }

    @Override
    public int deleteScoreSportBySportId(String sportId) {
        return scoreSportMapper.deleteScoreSportBySportId(sportId);
    }
}
