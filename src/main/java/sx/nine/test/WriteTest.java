package sx.nine.test;

import com.alibaba.excel.EasyExcel;
import sx.nine.pojo.WorkArea;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author NineEr
 * @Description //导出案例
 * @Date $ $
 **/
public class WriteTest {
    public static void main(String[] args) {
        //写的数据对象
        List<WorkArea> workAreas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WorkArea workArea = new WorkArea();
            workArea.setAreaName(""+i);
            workArea.setPointLocationx(""+i);
            workArea.setPointLocationy(""+i);
            workArea.setProjectId(""+i);
            workArea.setRoi(""+i);
            workAreas.add(workArea);
        }
        //ExcelUtils.writeExcel();
        //String fileName = TestFileUtil.getPath() + "write" + System.currentTimeMillis() + ".xlsx";
        String fileName = "D:\\WorkArea.xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, WorkArea.class).sheet("模板").doWrite(workAreas);
        System.out.println("导出成功");
    }
}
