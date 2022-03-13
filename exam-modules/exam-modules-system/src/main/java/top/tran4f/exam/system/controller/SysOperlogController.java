package top.tran4f.exam.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.tran4f.exam.common.core.utils.poi.ExcelUtil;
import top.tran4f.exam.common.core.web.controller.BaseController;
import top.tran4f.exam.common.core.web.domain.AjaxResult;
import top.tran4f.exam.common.core.web.page.TableDataInfo;
import top.tran4f.exam.common.log.annotation.Log;
import top.tran4f.exam.common.log.enums.BusinessType;
import top.tran4f.exam.common.security.annotation.InnerAuth;
import top.tran4f.exam.common.security.annotation.RequiresPermissions;
import top.tran4f.exam.system.api.domain.SysOperLog;
import top.tran4f.exam.system.service.ISysOperLogService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 操作日志记录
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/operlog")
public class SysOperlogController extends BaseController {
    @Autowired
    private ISysOperLogService operLogService;

    @RequiresPermissions("system:operlog:list")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLog operLog) {
        startPage();
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:operlog:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLog operLog) {
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:operlog:remove")
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds) {
        return toAjax(operLogService.deleteOperLogByIds(operIds));
    }

    @RequiresPermissions("system:operlog:remove")
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        operLogService.cleanOperLog();
        return AjaxResult.success();
    }

    @InnerAuth
    @PostMapping
    public AjaxResult add(@RequestBody SysOperLog operLog) {
        return toAjax(operLogService.insertOperlog(operLog));
    }
}
