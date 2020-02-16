package sx.nine.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sx.nine.excel.ExcelUtils;
import sx.nine.pojo.User;
import sx.nine.service.ExcelReaderService;
import sx.nine.tool.ExcelUtil;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.List;

@RestController
public class EasyExcelController {
    @Autowired
    private ExcelReaderService excelReaderService;

    //本地文件读取位置
    //private static final String LOG_BASE_PATH = "C:\\Users\\psx09\\Desktop\\import";
    //服务器文件读取位置,指定文件夹
    private static final String LOG_BASE_PATH = "/tmp/cjd";
    @ResponseBody
    @GetMapping("/read_excel")
    public String read() throws IOException, InvalidFormatException {
        //获取桌面绝对位置
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        File file = null;
        try {
            //File f = new File(LOG_BASE_PATH, "read.xls");
            file = new File(desktopPath, "read.xlsx");
            if (file.isFile() == false){
                file = new File(LOG_BASE_PATH, "read.xlsx");
                if (file.isFile() == false){
                    return "请核对文件所在位置 window请放置在桌面 linux放置在 /tmp/cjd  文件名为 read.xlsx";
                }
            }
        }catch (Exception e){
            return desktopPath+" read.xlsx 文件不存在";
        }
        InputStream in = new FileInputStream(file);
        //通过业务层直接调,可以对每行数据进行单独处理
        //excelReaderService.doReader(in);
        //通过ExcelUtil读取,实际也是通过ExcelListener监听器读取,拿到对象以后进行处理,此种方式弊端在直接封装对象,只能对封装后的数据进行处理
        List<User> users = ExcelUtil.readExcel(new BufferedInputStream(in), User.class);
        return "success";

    }
}
