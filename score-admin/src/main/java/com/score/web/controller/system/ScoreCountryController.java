package com.score.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.score.common.annotation.Log;
import com.score.common.core.controller.BaseController;
import com.score.common.core.domain.AjaxResult;
import com.score.common.enums.BusinessType;
import com.score.system.domain.ScoreCountry;
import com.score.system.service.IScoreCountryService;
import com.score.common.utils.poi.ExcelUtil;
import com.score.common.core.page.TableDataInfo;

/**
 * 国家地区Controller
 * 
 * @author score
 * @date 2024-02-18
 */
@RestController
@RequestMapping("/system/country")
public class ScoreCountryController extends BaseController
{
    @Autowired
    private IScoreCountryService scoreCountryService;

    /**
     * 查询国家地区列表
     */
    @PreAuthorize("@ss.hasPermi('system:country:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScoreCountry scoreCountry)
    {
        startPage();
        List<ScoreCountry> list = scoreCountryService.selectScoreCountryList(scoreCountry);
        return getDataTable(list);
    }

    /**
     * 导出国家地区列表
     */
    @PreAuthorize("@ss.hasPermi('system:country:export')")
    @Log(title = "国家地区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScoreCountry scoreCountry)
    {
        List<ScoreCountry> list = scoreCountryService.selectScoreCountryList(scoreCountry);
        ExcelUtil<ScoreCountry> util = new ExcelUtil<ScoreCountry>(ScoreCountry.class);
        util.exportExcel(response, list, "国家地区数据");
    }

    /**
     * 获取国家地区详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:country:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(scoreCountryService.selectScoreCountryById(id));
    }

    /**
     * 新增国家地区
     */
    @PreAuthorize("@ss.hasPermi('system:country:add')")
    @Log(title = "国家地区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScoreCountry scoreCountry)
    {
        return toAjax(scoreCountryService.insertScoreCountry(scoreCountry));
    }

    /**
     * 修改国家地区
     */
    @PreAuthorize("@ss.hasPermi('system:country:edit')")
    @Log(title = "国家地区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScoreCountry scoreCountry)
    {
        return toAjax(scoreCountryService.updateScoreCountry(scoreCountry));
    }

    /**
     * 删除国家地区
     */
    @PreAuthorize("@ss.hasPermi('system:country:remove')")
    @Log(title = "国家地区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scoreCountryService.deleteScoreCountryByIds(ids));
    }
}
