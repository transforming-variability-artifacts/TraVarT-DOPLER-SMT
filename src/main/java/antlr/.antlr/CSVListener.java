// Generated from c:/Users/david/eclipse-workspace/TraVarT-DOPLER-SMT/src/main/antlr/CSV.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

***REMOVED****
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSVParser}.
 ***REMOVED***
public interface CSVListener extends ParseTreeListener {
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#csvFile}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterCsvFile(CSVParser.CsvFileContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#csvFile}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitCsvFile(CSVParser.CsvFileContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#hdr}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterHdr(CSVParser.HdrContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#hdr}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitHdr(CSVParser.HdrContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterRow(CSVParser.RowContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#row}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitRow(CSVParser.RowContext ctx);
	***REMOVED****
	 * Enter a parse tree produced by {@link CSVParser#field}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void enterField(CSVParser.FieldContext ctx);
	***REMOVED****
	 * Exit a parse tree produced by {@link CSVParser#field}.
	 * @param ctx the parse tree
	 ***REMOVED***
	void exitField(CSVParser.FieldContext ctx);
}