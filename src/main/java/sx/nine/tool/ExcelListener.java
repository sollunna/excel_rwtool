package sx.nine.tool;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuShukai
 * @version V1.0
 * @description 处理Excel，将读取到数据保存为对象并输出
 * @date 2018/11/6  16:44
 */
@Slf4j
public class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T> {
    /**
     * 自定义用于暂时存储data。
     * 可以通过实例获取该值
     */
    private final List<T> data = new ArrayList<>();

    @Override
    public void invoke(T object, AnalysisContext context) {
        System.out.println(object.toString());
        //将读取的内容添加到对象中
        data.add(object);
        //根据自己业务做处理
        doSomething(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //读取完当前sheet表格的所有内容调用
        if(data.size()>0){
            //当sheet不为null
            log.info("read {} rows %n", data.size());
        }
        //解析结束销毁不用的资源
        data.clear();
    }

    /**
     * 根据业务自行实现该方法
     */
    private void doSomething(Object object) {
    }


    public List<T> getData() {
        //获取数据
        return data;
    }

}
