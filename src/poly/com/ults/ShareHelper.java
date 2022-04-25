package poly.com.ults;

import poly.com.entity.Users;
import poly.com.entity.Videos;

public class ShareHelper {
	public static Users USER = null;
	public static Videos Video = null;
	public static String tieude = "";
    public static void logoff() {
        ShareHelper.USER = null;
    }

    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
} 
