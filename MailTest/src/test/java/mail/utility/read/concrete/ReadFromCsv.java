package mail.utility.read.concrete;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import mail.configuration.ReadConfiguration;

public class ReadFromCsv {

    private static final String RECEIVER_MESSAGE = "receiver";
    private static final String SUBJECT_MESSAGE = "subject";
    private static final String MESSAGE_MESSAGE = "message";
    private static final String SAMPLE_CSV_FILE_PATH = ReadConfiguration.getPathToData();

    private static Object[][] data;

    public static Object[][] getData() {
	// Чтение из файла, парсер csv с заголовками
	try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		CSVParser csvParser = new CSVParser(reader,
			CSVFormat.DEFAULT.withHeader(RECEIVER_MESSAGE, SUBJECT_MESSAGE, MESSAGE_MESSAGE)
				.withIgnoreHeaderCase().withTrim());) {

	    List<CSVRecord> records = csvParser.getRecords();
	    data = new Object[records.size() - 1][3];
	    record(records);
	} catch (IOException e) {
	    e.printStackTrace();
	    return null;
	}
	return data;
    }

    public static void record(List<CSVRecord> records) {
	for (int i = 1; i <= 2; i++) {
	    CSVRecord csvRecord = records.get(i);
	    data[i - 1][0] = csvRecord.get(RECEIVER_MESSAGE);
	    data[i - 1][1] = csvRecord.get(SUBJECT_MESSAGE);
	    data[i - 1][2] = csvRecord.get(MESSAGE_MESSAGE);
	}
    }

}