package sx.nine.service;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sx.nine.tool.ExcelReaderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ExcelReaderServiceImpl implements ExcelReaderService {
    private Logger logger = LoggerFactory.getLogger(ExcelReaderServiceImpl.class);

    @Override
    public void doReader(InputStream in) throws IOException {
        AnalysisEventListener<List<String>> listener = new AnalysisEventListener<List<String>>() {
        //解析文件,并做相关处理,单线程,一个sheet生成一份list
            @Override
            public void invoke(List<String> obj, AnalysisContext analysisContext) {
               //obj为每行的数据
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                //每读完一个sheet调用
                logger.info("此次共读取数据"+context.getTotalCount()+"条,解析并存储完毕");
            }
        };
        ExcelReader excelReader = null;
        try {
            excelReader = ExcelReaderFactory.getExcelReader(in, null, listener);
            excelReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }finally {
            in.close();
        }
    }


}
