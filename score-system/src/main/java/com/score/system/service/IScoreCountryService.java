package com.score.system.service;

import java.util.List;
import com.score.system.domain.ScoreCountry;

/**
 * 国家地区Service接口
 * 
 * @author score
 * @date 2024-02-18
 */
public interface IScoreCountryService 
{
    /**
     * 查询国家地区
     * 
     * @param id 国家地区主键
     * @return 国家地区
     */
    public ScoreCountry selectScoreCountryById(Long id);

    /**
     * 查询国家地区列表
     * 
     * @param scoreCountry 国家地区
     * @return 国家地区集合
     */
    public List<ScoreCountry> selectScoreCountryList(ScoreCountry scoreCountry);

    /**
     * 新增国家地区
     * 
     * @param scoreCountry 国家地区
     * @return 结果
     */
    public int insertScoreCountry(ScoreCountry scoreCountry);

    /**
     * 修改国家地区
     * 
     * @param scoreCountry 国家地区
     * @return 结果
     */
    public int updateScoreCountry(ScoreCountry scoreCountry);

    /**
     * 批量删除国家地区
     * 
     * @param ids 需要删除的国家地区主键集合
     * @return 结果
     */
    public int deleteScoreCountryByIds(Long[] ids);

    /**
     * 删除国家地区信息
     * 
     * @param id 国家地区主键
     * @return 结果
     */
    public int deleteScoreCountryById(Long id);

    public int batchCountry(List<ScoreCountry> list);

    public List<ScoreCountry> selectScoreCyList();
}
