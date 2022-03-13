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
import top.tran4f.exam.system.api.domain.SysLogininfor;
import top.tran4f.exam.system.service.ISysLogininforService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统访问记录
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/logininfor")
public class SysLogininforController extends BaseController {
    @Autowired
    private ISysLogininforService logininforService;

    @RequiresPermissions("system:logininfor:list")
    @GetMapping("/list")
    public TableDataInfo list(SysLogininfor logininfor) {
        startPage();
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:logininfor:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLogininfor logininfor) {
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
        util.exportExcel(response, list, "登录日志");
    }

    @RequiresPermissions("system:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds) {
        return toAjax(logininforService.deleteLogininforByIds(infoIds));
    }

    @RequiresPermissions("system:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        logininforService.cleanLogininfor();
        return AjaxResult.success();
    }

    @InnerAuth
    @PostMapping
    public AjaxResult add(@RequestBody SysLogininfor logininfor) {
        return toAjax(logininforService.insertLogininfor(logininfor));
    }
}
