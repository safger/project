package com.sn.controller.tyy;

import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.Doctors;
import com.sn.service.DoctorsService;
import com.sn.service.ImagesService;
import com.sn.type.Result;
import com.sn.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Controller
@RequestMapping("/backstage/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    private ComData com;


    /**
     */

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
    }

    /**
     * @param model
     * @return
     * @author xiao
     */
    @RequestMapping("show")
    public String show(String page, Map<String, Object> model) {
        String roleid = (String) request.getSession().getAttribute("roleid");
        com = CompetenceManager.getCom(roleid, "backstage/doctors/show.html");
        if (!com.getHisSelect()) {
            return "error";
        }
        model.put("active", "doctors");
        model.put("com", com);
        model.put("page", page);
        return "/tyy/doctors";
    }

    /**
     * @param model
     * @return
     * @author xiao
     */
    @RequestMapping("getDate")
    @ResponseBody
    public Map<String, Object> getDate(Integer draw, Map<String, Object> model) {
        //每页返回的条数
        int pageSize = 10;
        String length = request.getParameter("length");
        if (!StringUtils.isEmpty(length)) {
            pageSize = Integer.parseInt(length);
        }
        int start = Integer.parseInt(request.getParameter("start"));
        int indexPage = start / pageSize + 1;
        Map<String, String[]> params = request.getParameterMap();
        String[] sort = params.get("order[0][column]");
        String[] desc = params.get("order[0][dir]");
        String[] value = params.get("search[value]");

        String orderByStr = null;
        switch (sort[0]) {
            case "1":
                orderByStr = " name";
                break;
            case "2":
                orderByStr = " sex";
                break;
            case "3":
                orderByStr = " department";
                break;
            case "4":
                orderByStr = " expert";
                break;
            case "5":
                orderByStr = " phone";
                break;
            case "6":
                orderByStr = " job";
                break;
            case "7":
                orderByStr = " expertFee";
                break;
        }
        orderByStr = orderByStr + " " + desc[0];
        Doctors doctors = new Doctors();
        if (value != null && value[0].length() > 0) {
            doctors.setName(value[0]);
        }
        PagedResult<Doctors> page_list = doctorsService.findByPageCustom(doctors, indexPage, pageSize, orderByStr);
        model.put("recordsTotal", page_list.getTotal());
        model.put("recordsFiltered", page_list.getTotal());
        model.put("draw", draw);
        model.put("data", page_list.getDataList());
        return model;
    }

    /**
     * @throws IOException
     * @author xiao
     */
    @RequestMapping("getEditData")
    @ResponseBody
    public Result getEditData(String fuid, Map<String, Object> model) throws IOException {
        Result result = new Result();
        Doctors doctors = doctorsService.findById(fuid);
        model.put("doctors", doctors);
        result.setData(model);
        return result;
    }

    /**
     * @param doctors 实体参数
     * @param model
     * @return 列表显示页
     * @throws IOException
     * @author xiao
     */
    @RequestMapping("edit")
    public String edit(@RequestParam(value = "avatarFile", required = false) MultipartFile avatarFile, @RequestParam(value = "photoFile", required = false) MultipartFile photoFile, Doctors doctors, String page, Map<String, Object> model) throws IOException {
        String id = doctors.getFuid();
        if (id != null && id.length() > 0) {
            doctors.setModifydate(new Date());
            doctorsService.updateImgSelective(doctors, avatarFile, photoFile);
        } else {
            doctors.setFuid(UUIDCreater.getUUID());
            doctors.setModifydate(new Date());
            doctorsService.insertImgSelective(doctors, avatarFile, photoFile);
        }
        model.put("page", page);
        return "redirect:/backstage/doctors/show.html";
    }

    /**
     * @return 列表显示页
     * @throws IOException
     * @author xiao
     */
    @RequestMapping("showEdit")
    public String showEdit(String id, Map<String, Object> model) {
        if (id != null && id.length() > 0) {
            Doctors doctors = doctorsService.findById(id);
            model.put("doctors", doctors);
        }
        return "tyy/doctorsEdit";
    }

    /**
     */
    @RequestMapping("delete")
    @ResponseBody
    public Result delete(String fuid) {
        Result result = new Result();
        if (fuid != null && fuid.length() > 0) {
            doctorsService.deleteById(fuid);
        }
        return result;
    }

}
