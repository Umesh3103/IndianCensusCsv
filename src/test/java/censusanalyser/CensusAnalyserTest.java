package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/java/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/java/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_TYPE = "./src/test/java/resources/IndiaStateCode.txt";
	private static final String INCORRECT_DELIMETER_CSV_FILE = "./src/test/java/resources/IndiaStateCensusWrongData.csv";
	private static final String INCORRECT_HEADER_INDIA_STATE_CSV_FILE = "./src/test/java/resources/IndiaStateCensusIncorrectHeaderData.csv";
	private static final String INDIA_STATE_CSV_FILE = "./src/test/java/resources/IndiaStateCode.csv";
	private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "./src/main/java/resources/IndiaStateCode.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
	
	
	@Test
	public void givenIndiaCensusData_WithWrongDelimeter_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INCORRECT_DELIMETER_CSV_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_PROPER_CSV, e.type);
		}
	}
	
	@Test
	public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INCORRECT_HEADER_INDIA_STATE_CSV_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_PROPER_CSV, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCSV_ShouldReturnStateCount() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		try {
			int numOfStateCode = censusAnalyser.loadIndianStateCode(INDIA_STATE_CSV_FILE);
			Assert.assertEquals(37, numOfStateCode);
		} catch (CensusAnalyserException e) {
		}
	}
	
	@Test
	public void givenIndiaStateCSV_WithWrongFile_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_STATE_CODE_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
}
