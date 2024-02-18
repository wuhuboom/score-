package com.score.system.mapper;

import java.util.List;
import com.score.system.domain.ScoreCountry;
import org.apache.ibatis.annotations.Update;

/**
 * 国家地区Mapper接口
 * 
 * @author score
 * @date 2024-02-18
 */
public interface ScoreCountryMapper 
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
     * 删除国家地区
     * 
     * @param id 国家地区主键
     * @return 结果
     */
    public int deleteScoreCountryById(Long id);

    /**
     * 批量删除国家地区
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteScoreCountryByIds(Long[] ids);

    public int batchCountry(List<ScoreCountry> list);

    @Update("truncate table score_country")
    public void deleteUserTemp();


    public List<ScoreCountry> selectScoreCyList();

}
