package cn.believeus.sglib.analyse;

public class AnalyseMain {
	public static void main(String[] args) {
		try {
			String srcName="";
			String dicName="";
			SogouLibAnalyse.analyse(srcName, dicName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
