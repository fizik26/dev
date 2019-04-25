// example of a foregroung color 
XSSFCellStyle style = workbook.createCellStyle();
style.setFillForegroundColor(new XSSFColor(new java.awt.Color(146, 208, 80), null));

// with this method you will don't have the deprecated issue
