package sx.nine.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

/**
 * @Author NineEr
 * @Description //TODO $
 * @Date $ $
 **/
@Data
public class WorkArea extends BaseRowModel {
    //private static final long serialVersionUID = 1L;
    /*@ExcelProperty(value = "姓名", index = 0)
    private String id ;

    private String createBy;


    private Date createTime;


    private String updateBy;


    private Date updateTime;


    private Integer delFlag ;*/

    @ExcelProperty(value = "区域名称", index = 0)
    private String areaName;

    @ExcelProperty(value = "项目id", index = 1)
    private String projectId;

    @ExcelProperty(value = "项目区域", index = 2)
    private String roi;

    @ExcelProperty(value = "工点区域经度", index = 3)
    private String pointLocationx;

    @ExcelProperty(value = "工点区域纬度", index = 4)
    private String pointLocationy;

    @ExcelProperty(value = "项目区域类型", index = 5)
    private Integer typeId;

    @ExcelProperty(value = "点位区域类型不能为空", index = 6)
    private Integer pointType;
}
