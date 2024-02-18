package com.score.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.score.system.mapper.ScoreCountryMapper;
import com.score.system.domain.ScoreCountry;
import com.score.system.service.IScoreCountryService;

/**
 * 国家地区Service业务层处理
 * 
 * @author score
 * @date 2024-02-18
 */
@Service
public class ScoreCountryServiceImpl implements IScoreCountryService 
{
    @Autowired
    private ScoreCountryMapper scoreCountryMapper;

    /**
     * 查询国家地区
     * 
     * @param id 国家地区主键
     * @return 国家地区
     */
    @Override
    public ScoreCountry selectScoreCountryById(Long id)
    {
        return scoreCountryMapper.selectScoreCountryById(id);
    }

    /**
     * 查询国家地区列表
     * 
     * @param scoreCountry 国家地区
     * @return 国家地区
     */
    @Override
    public List<ScoreCountry> selectScoreCountryList(ScoreCountry scoreCountry)
    {
        return scoreCountryMapper.selectScoreCountryList(scoreCountry);
    }

    /**
     * 新增国家地区
     * 
     * @param scoreCountry 国家地区
     * @return 结果
     */
    @Override
    public int insertScoreCountry(ScoreCountry scoreCountry)
    {
        return scoreCountryMapper.insertScoreCountry(scoreCountry);
    }

    /**
     * 修改国家地区
     * 
     * @param scoreCountry 国家地区
     * @return 结果
     */
    @Override
    public int updateScoreCountry(ScoreCountry scoreCountry)
    {
        return scoreCountryMapper.updateScoreCountry(scoreCountry);
    }

    /**
     * 批量删除国家地区
     * 
     * @param ids 需要删除的国家地区主键
     * @return 结果
     */
    @Override
    public int deleteScoreCountryByIds(Long[] ids)
    {
        return scoreCountryMapper.deleteScoreCountryByIds(ids);
    }

    /**
     * 删除国家地区信息
     * 
     * @param id 国家地区主键
     * @return 结果
     */
    @Override
    public int deleteScoreCountryById(Long id)
    {
        return scoreCountryMapper.deleteScoreCountryById(id);
    }

    @Override
    public int batchCountry(List<ScoreCountry> list) {
        scoreCountryMapper.deleteUserTemp();
        return scoreCountryMapper.batchCountry(list);
    }

    @Override
    public List<ScoreCountry> selectScoreCyList() {
        return scoreCountryMapper.selectScoreCyList();
    }
}
