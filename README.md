# excel_rwtool
#看了官网和各路大神写的可直接使用的demo,有错误或者更好的方案请赐教

工具类解析:
1)ExcelException类:数据读取异常处理类

2)ExcelListener类:进行excel读取监听数据
方法:
    invoke:数据处理
    doSomething:自定义数据业务处理,被invoke调用
    doAfterAllAnalysed:解析后的数据处理,比如销毁数据释放资源

3)ExcelReaderFactory类:读取Excel
方法:
    是否去空做区别处理

2)ExcelUtils: excel处理工具类
方法:
    readExcel:读取 Excel(多个 sheet)
    读取Excel的某个sheet
    导出 Excel：一个sheet带表头
    导出 Excel：多个sheet带表头
    导出文件时为Writer生成OutputStream
    读取excel
