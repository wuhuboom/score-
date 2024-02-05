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
import com.score.system.domain.ScoreSport;
import com.score.system.service.IScoreSportService;
import com.score.common.utils.poi.ExcelUtil;
import com.score.common.core.page.TableDataInfo;

/**
 * 足球列表Controller
 * 
 * @author score
 * @date 2024-02-01
 */
@RestController
@RequestMapping("/system/sport")
public class ScoreSportController extends BaseController
{
    @Autowired
    private IScoreSportService scoreSportService;

    /**
     * 查询足球列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:list')")
    @GetMapping("/list")
    public TableDataInfo list(ScoreSport scoreSport)
    {
        startPage();
        List<ScoreSport> list = scoreSportService.selectScoreSportList(scoreSport);
        return getDataTable(list);
    }

    /**
     * 导出足球列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:export')")
    @Log(title = "足球列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ScoreSport scoreSport)
    {
        List<ScoreSport> list = scoreSportService.selectScoreSportList(scoreSport);
        ExcelUtil<ScoreSport> util = new ExcelUtil<ScoreSport>(ScoreSport.class);
        util.exportExcel(response, list, "足球列表数据");
    }

    /**
     * 获取足球列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sport:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(scoreSportService.selectScoreSportById(id));
    }

    /**
     * 新增足球列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:add')")
    @Log(title = "足球列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScoreSport scoreSport)
    {
        return toAjax(scoreSportService.insertScoreSport(scoreSport));
    }

    /**
     * 修改足球列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:edit')")
    @Log(title = "足球列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScoreSport scoreSport)
    {
        return toAjax(scoreSportService.updateScoreSport(scoreSport));
    }

    /**
     * 删除足球列表
     */
    @PreAuthorize("@ss.hasPermi('system:sport:remove')")
    @Log(title = "足球列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scoreSportService.deleteScoreSportByIds(ids));
    }
}
