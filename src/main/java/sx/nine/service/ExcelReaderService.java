package sx.nine.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.io.InputStream;

public interface ExcelReaderService {
   void doReader(InputStream in) throws IOException, InvalidFormatException;
}
