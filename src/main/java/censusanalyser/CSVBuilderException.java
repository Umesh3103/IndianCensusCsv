package censusanalyser;

import censusanalyser.CensusAnalyserException.ExceptionType;

public class CSVBuilderException extends Exception {

	enum ExceptionType {
		UNABLE_TO_PARSE
	}

	ExceptionType type;

	public CSVBuilderException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

}
