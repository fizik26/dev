import java.io.InputStream;

import javax.xml.XMLConstants;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Service that permot to proceed a huge excel file
 */
public class ExcelService {

	/**
	 * Read an Excel File and make some logic on it
	 * @param inputStream - {@link InputStream} of an Excel File
	 */
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
	
	/**
     * Parses and make some logic on a sheet
     * using the specified styles and shared-strings tables.
     *
     * @param styles The table of styles that may be referenced by cells in the sheet
     * @param strings The table of strings that may be referenced by cells in the sheet
	 * @param sheetHandler This allows to build functionality which reads huge files without needing large amounts of main memory.
     * @param sheetInputStream The stream to read the sheet-data from.
	 * 
     */
	private void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, XSSFSheetXMLHandler.SheetContentsHandler sheetHandler, InputStream sheetInputStream) {
		DataFormatter formatter = new DataFormatter();
		InputSource sheetSource = new InputSource(sheetInputStream);
		try {
			XMLReader sheetParser = XMLHelper.newXMLReader();
			ContentHandler handler = new XSSFSheetXMLHandler(
					styles, null, strings, sheetHandler, formatter, false);
			sheetParser.setContentHandler(handler);
		
			sheetParser.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			sheetParser.parse(sheetSource);
		} catch ( Exception e) {
			// exception
		}
	}

	/**
	 * Uses the XSSF Event to do most of the work
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
	{
		
	}
}	
