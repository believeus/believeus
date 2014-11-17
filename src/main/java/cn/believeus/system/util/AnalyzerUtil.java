package cn.believeus.system.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;

/**
 * @author wuqiwei
 * Date:2013-09-24 分词查看器
 */
public class AnalyzerUtil {
	public static void displayToken(Reader reader,Analyzer analyzer){
		try {
			// 此处已经分好词了
			TokenStream tokenStream = analyzer.tokenStream("content", reader);
			CharTermAttribute charAttribute = tokenStream.addAttribute(CharTermAttribute.class);
			PositionIncrementAttribute positionAttribute = tokenStream.addAttribute(PositionIncrementAttribute.class);
			OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
			while (tokenStream.incrementToken()) {
				System.out.println("["+charAttribute+"]"+"["+positionAttribute.getPositionIncrement()+"]"+"["+offsetAttribute.endOffset()+"]");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
