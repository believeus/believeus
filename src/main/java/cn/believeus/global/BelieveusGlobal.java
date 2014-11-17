package cn.believeus.global;

public class BelieveusGlobal {
	public static final String SessionUser = "SessionUser";
	public static final String validateCode = "SessionValidateCode";
	public static final int perPageCount = 12;
	public final static String mailSenderTemplete = "mailSenderTemplete";
	public static final Integer adminBowenPerCount = 5;
	public static final Integer adminCasesPerCount = 5;
	public static final Integer adminYaoShanPerCount = 5;
	public static int adminArgumentPerCount = 5;
	public static final String SessionAdmin = "sessionAdmin";
	/* 正常状态 */
	public static final short NormalStatus = 0;
	/* 封禁 */
	public static final short StopStatus = 1;
	/* 推荐 */
	public static final short Recommend = 2;
	/*页数的操作*/
	public static final Integer IgnoreCurrentPage=null;
	public static final Integer IgnorePerPageCount=null;
	public static final Integer IgnoreTotalCount=null;
}
