package unix;

import static org.junit.Assert.*;
import static util.CommonUtil.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.StandardInputSnatcher;

public class UnixUtilTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final StandardInputSnatcher in = new StandardInputSnatcher();

    //ストリームの設定
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(in);
    }

    //ストリームの設定解除
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
        System.setIn(System.in);
    }

    /**
     * @author toku
     * 1つのファイル内容が大文字に変換されていることを確認するためのテスト
     *
     * */
	@Test
	public void testCatAndCapitalize() {

		String testResult = null;
		Path p = new File(FILE_UNIX_TESTPATH1).toPath();
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(p)){
			Iterator<Path> ite = ds.iterator();
			while(ite.hasNext()){
				testResult = UnixUtil.catAndCapitalize(ite.next().toFile());
			}
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		if (Objects.nonNull(testResult))
		assertEquals("OK", (testResult.equals("AAA")));

	}



}
