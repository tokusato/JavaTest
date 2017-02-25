package antlr.verify;

import static util.CommonUtil.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.autogen.MySQLLexer;
import antlr.autogen.MySQLParser;

public class SqlSyntax {

	public SqlSyntax() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		System.out.println("hello");
		//ANTLRによる構文解析
//		InputStream is = System.in;
//		test(is);
//		System.out.println(new File(".\\src\\main\\java\\antlr\\resource\\sql.txt").getAbsolutePath());
		try(InputStream is = new FileInputStream(new File(FILE_SQL_PATH1))){
			new SqlSyntax().parse(is);
		}catch (IOException ioe){
			ioe.printStackTrace();
		}

	}


	private void parse(InputStream is) {

		try{
			//標準入力を読み込み、CharStreamを生成する。
			//Input will be -> select * from tab;
			ANTLRInputStream ais = new ANTLRInputStream(is);
			System.out.println(ais);

			//create Lexer
			MySQLLexer msl = new MySQLLexer(ais);

			//cerate token buffer from lexer
			CommonTokenStream cts = new CommonTokenStream(msl);

			//create parser from tokens
			MySQLParser msp = new MySQLParser(cts);

			//begin parsing at rule
//			msp.stat();

			//TODO I want to get both table name natural joined!! but how to ??
			msp.setBuildParseTree(true);
		    ParseTree tree = msp.stat();

		    ParseTreeWalker walker = new ParseTreeWalker();

		    System.out.println(walker.toString());

		} catch (IOException ioe){
			ioe.printStackTrace();
		}

	}

	/**
	 * @author toku
	 * just test that InputStream is read
	 * */
	private static void test(InputStream is) {

		String line = null;

		try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){

			while (Objects.nonNull(line = br.readLine())){
				System.out.println(line);
			}

		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

}
