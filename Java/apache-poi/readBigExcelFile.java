// InputStream of a XLSX file
public void processOneSheetFile(InputStream inputStream) {
	try {
		OPCPackage pkg = OPCPackage.open(inputStream);

		XSSFReader r = new XSSFReader(pkg);
		ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);

		StylesTable styles = r.getStylesTable();
		XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator) r.getSheetsData();
		int index = 0;
		while (iter.hasNext()) {
			try (InputStream stream = iter.next()) {
				processSheet(styles, strings, new SheetToCSV(), stream);
			}
			++index;
		}
	} catch(Exception e) {
		// exception
	}

}

private void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, XSSFSheetXMLHandler.SheetContentsHandler sheetHandler, InputStream sheetInputStream) {
	DataFormatter formatter = new DataFormatter();
	InputSource sheetSource = new InputSource(sheetInputStream);
	try {
		XMLReader sheetParser = SAXHelper.newXMLReader();
		ContentHandler handler = new XSSFSheetXMLHandler(
				styles, null, strings, sheetHandler, formatter, false);
		sheetParser.setContentHandler(handler);
    // security
		sheetParser.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		sheetParser.parse(sheetSource);
	} catch ( Exception e) {
		// exception
	}
}

/**
 * Uses the XSSF Event SAX helpers to do most of the work
 * of parsing the Sheet XML, and outputs the contents
 * as a (basic) CSV.
 */
private class SheetToCSV implements XSSFSheetXMLHandler.SheetContentsHandler {
	

	@Override
	public void startRow(int rowNum) {
		
	}

	@Override
	public void endRow(int rowNum) {
		
	}

	@Override
	public void cell(String cellReference, String formattedValue,
					 XSSFComment comment) {
	
	}
}
