package com.cyyz.spt.platform.common.util.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;

public interface ExcelCallback<T> {
    void fillCellValue(HSSFRow row, Integer orderNum, T bean);
}
