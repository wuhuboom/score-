package com.score.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.score.common.annotation.Excel;
import com.score.common.core.domain.BaseEntity;

/**
 * 国家地区对象 score_country
 * 
 * @author score
 * @date 2024-02-18
 */
public class ScoreCountry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** cc */
    @Excel(name = "cc")
    private String cc;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 图标 */
    @Excel(name = "图标")
    private String img;

    /** 联赛数 */
    @Excel(name = "联赛数")
    private Integer leagueNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCc(String cc) 
    {
        this.cc = cc;
    }

    public String getCc() 
    {
        return cc;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setLeagueNum(Integer leagueNum) 
    {
        this.leagueNum = leagueNum;
    }

    public Integer getLeagueNum() 
    {
        return leagueNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cc", getCc())
            .append("name", getName())
            .append("img", getImg())
            .append("leagueNum", getLeagueNum())
            .toString();
    }
}
