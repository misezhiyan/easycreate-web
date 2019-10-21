package com.kimmy.easycreate.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kimmy.easycreate.etity.result.TableFieldRelationWithField;
import com.kimmy.easycreate.po.Table;

public class ExcelUtil {

	// 从Excel中抽取表结构
	public static List<Table> getTableListFromExcelInputStream(InputStream inputStream) throws IOException {

		List<Table> tableList = new ArrayList<Table>();

		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(inputStream);

		Iterator<Sheet> sheetIterator = workBook.sheetIterator();
		while (sheetIterator.hasNext()) {

			Sheet sheet = sheetIterator.next();

			Table table = new Table();

			int lastRowNum = sheet.getLastRowNum();
			if (lastRowNum < 2)
				continue;
			for (int i = 0; i <= lastRowNum; i++) {
				if (i == 0 || i == 2)
					continue;
				Row row = sheet.getRow(i);
				if (i == 1) {

					Cell cell_tableName = row.getCell(0);
					Cell cell_tableComment = row.getCell(1);
					Cell cell_tableAutoIncri = row.getCell(2);
					Cell cell_tableSequence = row.getCell(3);

					String tableName = cell_tableName.getStringCellValue();
					String tableComment = cell_tableComment.getStringCellValue();
					String tableAutoIncri = cell_tableAutoIncri.getStringCellValue();
					String tableSequence = cell_tableSequence.getStringCellValue();

					table.setTableName(tableName);
					table.setTableComment(tableComment);
					table.setAutoIncri(tableAutoIncri);
					table.setSequence(tableSequence);

				} else {

					TableFieldRelationWithField field = new TableFieldRelationWithField();

					Cell cell_fieldRef = row.getCell(0);
					Cell cell_fieldName = row.getCell(1);
					Cell cell_fieldComment = row.getCell(2);
					Cell cell_fieldType = row.getCell(3);
					Cell cell_fieldIsPri = row.getCell(4);

					if (!isEmptyCell(cell_fieldRef)) {
						Double fieldRefD = cell_fieldRef.getNumericCellValue();
						Integer fieldRef = fieldRefD.intValue();

						field.setFieldRef(fieldRef);
					} else {

						if (null == cell_fieldName)
							System.out.println(1);

						String fieldName = cell_fieldName.getStringCellValue();
						String fieldComment = cell_fieldComment.getStringCellValue();
						String fieldType = cell_fieldType.getStringCellValue();
						String fieldIsPri = "";
						if (!isEmptyCell(cell_fieldIsPri)) {
							fieldIsPri = cell_fieldIsPri.getStringCellValue();
						}

						field.setFieldName(fieldName);
						field.setFieldComment(fieldComment);
						field.setFieldType(fieldType);
						field.setIsPri(fieldIsPri);
					}

					table.addTfr(field);

					// Cell cell = cellIterator.next();
					// CellType cellType = cell.getCellType();
					//
					// if ("STRING".equals(cellType.toString())) {
					// String value = cell.getStringCellValue();
					// }
					// if ("NUMERIC".equals(cellType.toString())) {
					// double value = cell.getNumericCellValue();
					// }
					// if ("BLANK".equals(cellType.toString())) {
					// }

					// System.out.println(cellType);
					// System.out.println(cell.getStringCellValue());
				}
			}

			tableList.add(table);
		}

		return tableList;
	}

	private static boolean isEmptyCell(Cell cell) {

		return null == cell || "BLANK".equals(cell.getCellType().toString());
	}

}
