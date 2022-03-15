package danggai.app.lockscreenexample.util;

import android.util.Log;

import danggai.app.lockscreenexample.BuildConfig;


public class log {
    private static final char[] wJ = "0123456789abcdef".toCharArray();
    public static String imsi = "204046330839890";
    public static String p = "0";
    public static String keyword = "Telephone";
    public static String tranlateKeyword = "%E7%94%B5%E8%AF%9D";

    public static final String tag = "danal";

    public final static boolean debug = BuildConfig.DEBUG;

    public static void l() {
        try {
            if (debug) {
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();

                Log.d(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() );

            }
        } catch (Exception ignore) {
        }

    }

    public static void e() {
        try {
            if (debug) {
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();

                Log.e(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() );

            }
        } catch (Exception ignore) {
        }

    }

    public static void d(String msg) {
        try {
            if (debug) {
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();
                Log.d(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() + " -> " + msg);
            }
        } catch (Exception ignore) {
        }
    }

    public static void d(String _tag, String msg) {
        try {
            if (debug){
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();
                Log.d(_tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() + " -> " + msg);
            }
        } catch (Exception ignore) {
        }
    }

    public static void e(String msg) {
        try {
            if (debug){
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();
                Log.e(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() + " -> " + msg);
            }

        } catch (Exception ignore) {
        }
    }

    public static void w(String msg) {
        try {
            if (debug){
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();
                Log.w(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() + " -> " + msg);
            }
        } catch (Exception ignore) {
        }
    }

    public static void i(String msg) {
        try {
            if (debug){
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();
                Log.i(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() + " -> " + msg);
            }
        } catch (Exception ignore) {
        }
    }

    public static void v(String msg) {
        try {
            if (debug){
                Exception e = new Exception();
                StackTraceElement[] element = e.getStackTrace();
                Log.v(tag, "("+element[1].getFileName()+":"+element[1].getLineNumber()+")"+"\t"+element[1].getMethodName() + " -> " + msg);
            }
        } catch (Exception ignore) {
        }
    }
}