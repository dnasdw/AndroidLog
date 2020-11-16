import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

public class log {
    public static final String tag = "SystemErrLog";
    public static final String path = Environment.getExternalStorageDirectory()
            .getAbsolutePath() + "/AndroidLog/dnasdw/";

    public static int index = 0;

    public static boolean printStackTrace = true;

    public static synchronized int getIndex() {
        return index++;
    }

    public static void s(String value) throws IOException {
        int i = getIndex();
        String fileName = path + i + ".txt";
        File f = new File(fileName);
        f.getParentFile().mkdirs();
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(value.getBytes());
        fos.close();
    }

    public static void s(byte[] value) throws IOException {
        int i = getIndex();
        String fileName = path + i + ".txt";
        File f = new File(fileName);
        f.getParentFile().mkdirs();
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(value);
        fos.close();
    }

    public static void s(InputStream value) throws IOException {
        int i = getIndex();
        String fileName = path + i + ".txt";
        File f = new File(fileName);
        f.getParentFile().mkdirs();
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        BufferedInputStream bis = new BufferedInputStream(value);
        bis.mark(bis.available());
        byte[] buffer = new byte[2048];
        for (int j; (j = bis.read(buffer)) != -1; ) {
            fos.write(buffer, 0, j);
        }
        fos.close();
    }

    public static void l(InputStream value) throws IOException {
        Log.e(tag, "StreamLen: " + value.available());
    }

    public static void m0() {
        Log.e(tag, "mark:      0");
    }

    public static void m1() {
        Log.w(tag, "mark:      1");
    }

    public static void m2() {
        Log.e(tag, "mark:      2");
    }

    public static void m3() {
        Log.w(tag, "mark:      3");
    }

    public static void m4() {
        Log.e(tag, "mark:      4");
    }

    public static void m5() {
        Log.w(tag, "mark:      5");
    }

    public static void m6() {
        Log.e(tag, "mark:      6");
    }

    public static void m7() {
        Log.w(tag, "mark:      7");
    }

    public static void m8() {
        Log.e(tag, "mark:      8");
    }

    public static void m9() {
        Log.w(tag, "mark:      9");
    }

    public static void ma() {
        Log.e(tag, "mark:      a");
    }

    public static void mb() {
        Log.w(tag, "mark:      b");
    }

    public static void mc() {
        Log.e(tag, "mark:      c");
    }

    public static void md() {
        Log.w(tag, "mark:      d");
    }

    public static void me() {
        Log.e(tag, "mark:      e");
    }

    public static void mf() {
        Log.w(tag, "mark:      f");
    }

    public static void p() {
        Log.e(tag, "printStackTrace:");
        if (printStackTrace) {
            new Throwable().printStackTrace();
        }
    }

    public static void v(Object value) {
        Log.v(tag, "Object:    " + (value != null ? "is not null" : "is null"));
    }

    public static void v(boolean value) {
        Log.v(tag, "boolean:   " + Boolean.toString(value));
    }

    public static void v(boolean[] value) {
        if (value == null) {
            Log.v(tag, "boolean[]: Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "boolean[" + i + "]: " + Boolean.toString(value[i]));
            }
        }
    }

    public static void v(byte value) {
        Log.v(tag, "byte:      " + (value >= 0 && value < 16 ? "0" : "")
                + Integer.toHexString((int) value & 0xFF));
    }

    public static void v(byte[] value) {
        if (value == null) {
            Log.v(tag, "byte[]:    Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag,
                        "byte[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i] & 0xFF));
            }
        }
    }

    public static void v(char value) {
        Log.v(tag, "char:      " + Character.toString(value));
    }

    public static void v(char[] value) {
        if (value == null) {
            Log.v(tag, "char[]:    Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            Log.v(tag, "char[]:    " + String.valueOf(value));
            for (int i = 0; i < length; i++) {
                Log.v(tag,
                        "char[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i]));
            }
        }
    }

    public static void v(double value) {
        Log.v(tag, "double:    " + Double.toString(value));
    }

    public static void v(double[] value) {
        if (value == null) {
            Log.v(tag, "double[]:  Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "double[" + i + "]:  " + Double.toString(value[i]));
            }
        }
    }

    public static void v(float value) {
        Log.v(tag, "float:     " + Float.toString(value));
    }

    public static void v(float[] value) {
        if (value == null) {
            Log.v(tag, "float[]:   Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "float[" + i + "]:   " + Float.toString(value[i]));
            }
        }
    }

    public static void v(int value) {
        Log.v(tag, "int:       " + Integer.toString(value));
    }

    public static void v(int[] value) {
        if (value == null) {
            Log.v(tag, "int[]:     Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "int[" + i + "]:     " + Integer.toString(value[i]));
            }
        }
    }

    public static void v(long value) {
        Log.v(tag, "long:      " + Long.toString(value));
    }

    public static void v(long[] value) {
        if (value == null) {
            Log.v(tag, "long[]:    Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "long[" + i + "]:    " + Long.toString(value[i]));
            }
        }
    }

    public static void v(short value) {
        Log.v(tag, "short:     " + Short.toString(value));
    }

    public static void v(short[] value) {
        if (value == null) {
            Log.v(tag, "short[]:   Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "short[" + i + "]:   " + Short.toString(value[i]));
            }
        }
    }

    public static void v(String value) {
        if (TextUtils.isEmpty(value)) {
            value = "is empty";
        }
        Log.v(tag, "String:    " + value);
    }

    public static void v(String[] value) {
        if (value == null) {
            Log.v(tag, "String[]:  Empty");
        } else {
            int length = value.length;
            Log.v(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.v(tag, "String[" + i + "]:  " + value[i]);
            }
        }
    }

    public static void d(Object value) {
        Log.d(tag, "Object:    " + (value != null ? "is not null" : "is null"));
    }

    public static void d(boolean value) {
        Log.d(tag, "boolean:   " + Boolean.toString(value));
    }

    public static void d(boolean[] value) {
        if (value == null) {
            Log.d(tag, "boolean[]: Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "boolean[" + i + "]: " + Boolean.toString(value[i]));
            }
        }
    }

    public static void d(byte value) {
        Log.d(tag, "byte:      " + (value >= 0 && value < 16 ? "0" : "")
                + Integer.toHexString((int) value & 0xFF));
    }

    public static void d(byte[] value) {
        if (value == null) {
            Log.d(tag, "byte[]:    Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag,
                        "byte[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i] & 0xFF));
            }
        }
    }

    public static void d(char value) {
        Log.d(tag, "char:      " + Character.toString(value));
    }

    public static void d(char[] value) {
        if (value == null) {
            Log.d(tag, "char[]:    Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            Log.d(tag, "char[]:    " + String.valueOf(value));
            for (int i = 0; i < length; i++) {
                Log.d(tag,
                        "char[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i]));
            }
        }
    }

    public static void d(double value) {
        Log.d(tag, "double:    " + Double.toString(value));
    }

    public static void d(double[] value) {
        if (value == null) {
            Log.d(tag, "double[]:  Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "double[" + i + "]:  " + Double.toString(value[i]));
            }
        }
    }

    public static void d(float value) {
        Log.d(tag, "float:     " + Float.toString(value));
    }

    public static void d(float[] value) {
        if (value == null) {
            Log.d(tag, "float[]:   Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "float[" + i + "]:   " + Float.toString(value[i]));
            }
        }
    }

    public static void d(int value) {
        Log.d(tag, "int:       " + Integer.toString(value));
    }

    public static void d(int[] value) {
        if (value == null) {
            Log.d(tag, "int[]:     Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "int[" + i + "]:     " + Integer.toString(value[i]));
            }
        }
    }

    public static void d(long value) {
        Log.d(tag, "long:      " + Long.toString(value));
    }

    public static void d(long[] value) {
        if (value == null) {
            Log.d(tag, "long[]:    Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "long[" + i + "]:    " + Long.toString(value[i]));
            }
        }
    }

    public static void d(short value) {
        Log.d(tag, "short:     " + Short.toString(value));
    }

    public static void d(short[] value) {
        if (value == null) {
            Log.d(tag, "short[]:   Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "short[" + i + "]:   " + Short.toString(value[i]));
            }
        }
    }

    public static void d(String value) {
        if (TextUtils.isEmpty(value)) {
            value = "is empty";
        }
        Log.d(tag, "String:    " + value);
    }

    public static void d(String[] value) {
        if (value == null) {
            Log.d(tag, "String[]:  Empty");
        } else {
            int length = value.length;
            Log.d(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.d(tag, "String[" + i + "]:  " + value[i]);
            }
        }
    }

    public static void i(Object value) {
        Log.i(tag, "Object:    " + (value != null ? "is not null" : "is null"));
    }

    public static void i(boolean value) {
        Log.i(tag, "boolean:   " + Boolean.toString(value));
    }

    public static void i(boolean[] value) {
        if (value == null) {
            Log.i(tag, "boolean[]: Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "boolean[" + i + "]: " + Boolean.toString(value[i]));
            }
        }
    }

    public static void i(byte value) {
        Log.i(tag, "byte:      " + (value >= 0 && value < 16 ? "0" : "")
                + Integer.toHexString((int) value & 0xFF));
    }

    public static void i(byte[] value) {
        if (value == null) {
            Log.i(tag, "byte[]:    Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag,
                        "byte[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i] & 0xFF));
            }
        }
    }

    public static void i(char value) {
        Log.i(tag, "char:      " + Character.toString(value));
    }

    public static void i(char[] value) {
        if (value == null) {
            Log.i(tag, "char[]:    Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            Log.i(tag, "char[]:    " + String.valueOf(value));
            for (int i = 0; i < length; i++) {
                Log.i(tag,
                        "char[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i]));
            }
        }
    }

    public static void i(double value) {
        Log.i(tag, "double:    " + Double.toString(value));
    }

    public static void i(double[] value) {
        if (value == null) {
            Log.i(tag, "double[]:  Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "double[" + i + "]:  " + Double.toString(value[i]));
            }
        }
    }

    public static void i(float value) {
        Log.i(tag, "float:     " + Float.toString(value));
    }

    public static void i(float[] value) {
        if (value == null) {
            Log.i(tag, "float[]:   Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "float[" + i + "]:   " + Float.toString(value[i]));
            }
        }
    }

    public static void i(int value) {
        Log.i(tag, "int:       " + Integer.toString(value));
    }

    public static void i(int[] value) {
        if (value == null) {
            Log.i(tag, "int[]:     Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "int[" + i + "]:     " + Integer.toString(value[i]));
            }
        }
    }

    public static void i(long value) {
        Log.i(tag, "long:      " + Long.toString(value));
    }

    public static void i(long[] value) {
        if (value == null) {
            Log.i(tag, "long[]:    Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "long[" + i + "]:    " + Long.toString(value[i]));
            }
        }
    }

    public static void i(short value) {
        Log.i(tag, "short:     " + Short.toString(value));
    }

    public static void i(short[] value) {
        if (value == null) {
            Log.i(tag, "short[]:   Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "short[" + i + "]:   " + Short.toString(value[i]));
            }
        }
    }

    public static void i(String value) {
        if (TextUtils.isEmpty(value)) {
            value = "is empty";
        }
        Log.i(tag, "String:    " + value);
    }

    public static void i(String[] value) {
        if (value == null) {
            Log.i(tag, "String[]:  Empty");
        } else {
            int length = value.length;
            Log.i(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.i(tag, "String[" + i + "]:  " + value[i]);
            }
        }
    }

    public static void w(Object value) {
        Log.w(tag, "Object:    " + (value != null ? "is not null" : "is null"));
    }

    public static void w(boolean value) {
        Log.w(tag, "boolean:   " + Boolean.toString(value));
    }

    public static void w(boolean[] value) {
        if (value == null) {
            Log.w(tag, "boolean[]: Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "boolean[" + i + "]: " + Boolean.toString(value[i]));
            }
        }
    }

    public static void w(byte value) {
        Log.w(tag, "byte:      " + (value >= 0 && value < 16 ? "0" : "")
                + Integer.toHexString((int) value & 0xFF));
    }

    public static void w(byte[] value) {
        if (value == null) {
            Log.w(tag, "byte[]:    Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag,
                        "byte[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i] & 0xFF));
            }
        }
    }

    public static void w(char value) {
        Log.w(tag, "char:      " + Character.toString(value));
    }

    public static void w(char[] value) {
        if (value == null) {
            Log.w(tag, "char[]:    Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            Log.w(tag, "char[]:    " + String.valueOf(value));
            for (int i = 0; i < length; i++) {
                Log.w(tag,
                        "char[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i]));
            }
        }
    }

    public static void w(double value) {
        Log.w(tag, "double:    " + Double.toString(value));
    }

    public static void w(double[] value) {
        if (value == null) {
            Log.w(tag, "double[]:  Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "double[" + i + "]:  " + Double.toString(value[i]));
            }
        }
    }

    public static void w(float value) {
        Log.w(tag, "float:     " + Float.toString(value));
    }

    public static void w(float[] value) {
        if (value == null) {
            Log.w(tag, "float[]:   Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "float[" + i + "]:   " + Float.toString(value[i]));
            }
        }
    }

    public static void w(int value) {
        Log.w(tag, "int:       " + Integer.toString(value));
    }

    public static void w(int[] value) {
        if (value == null) {
            Log.w(tag, "int[]:     Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "int[" + i + "]:     " + Integer.toString(value[i]));
            }
        }
    }

    public static void w(long value) {
        Log.w(tag, "long:      " + Long.toString(value));
    }

    public static void w(long[] value) {
        if (value == null) {
            Log.w(tag, "long[]:    Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "long[" + i + "]:    " + Long.toString(value[i]));
            }
        }
    }

    public static void w(short value) {
        Log.w(tag, "short:     " + Short.toString(value));
    }

    public static void w(short[] value) {
        if (value == null) {
            Log.w(tag, "short[]:   Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "short[" + i + "]:   " + Short.toString(value[i]));
            }
        }
    }

    public static void w(String value) {
        if (TextUtils.isEmpty(value)) {
            value = "is empty";
        }
        Log.w(tag, "String:    " + value);
    }

    public static void w(String[] value) {
        if (value == null) {
            Log.w(tag, "String[]:  Empty");
        } else {
            int length = value.length;
            Log.w(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.w(tag, "String[" + i + "]:  " + value[i]);
            }
        }
    }

    public static void e(Object value) {
        Log.e(tag, "Object:    " + (value != null ? "is not null" : "is null"));
    }

    public static void e(boolean value) {
        Log.e(tag, "boolean:   " + Boolean.toString(value));
    }

    public static void e(boolean[] value) {
        if (value == null) {
            Log.e(tag, "boolean[]: Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "boolean[" + i + "]: " + Boolean.toString(value[i]));
            }
        }
    }

    public static void e(byte value) {
        Log.e(tag, "byte:      " + (value >= 0 && value < 16 ? "0" : "")
                + Integer.toHexString((int) value & 0xFF));
    }

    public static void e(byte[] value) {
        if (value == null) {
            Log.e(tag, "byte[]:    Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag,
                        "byte[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i] & 0xFF));
            }
        }
    }

    public static void e(char value) {
        Log.e(tag, "char:      " + Character.toString(value));
    }

    public static void e(char[] value) {
        if (value == null) {
            Log.e(tag, "char[]:    Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            Log.e(tag, "char[]:    " + String.valueOf(value));
            for (int i = 0; i < length; i++) {
                Log.e(tag,
                        "char[" + i + "]:    "
                                + (value[i] >= 0 && value[i] < 16 ? "0" : "")
                                + Integer.toHexString((int) value[i]));
            }
        }
    }

    public static void e(double value) {
        Log.e(tag, "double:    " + Double.toString(value));
    }

    public static void e(double[] value) {
        if (value == null) {
            Log.e(tag, "double[]:  Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "double[" + i + "]:  " + Double.toString(value[i]));
            }
        }
    }

    public static void e(float value) {
        Log.e(tag, "float:     " + Float.toString(value));
    }

    public static void e(float[] value) {
        if (value == null) {
            Log.e(tag, "float[]:   Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "float[" + i + "]:   " + Float.toString(value[i]));
            }
        }
    }

    public static void e(int value) {
        Log.e(tag, "int:       " + Integer.toString(value));
    }

    public static void e(int[] value) {
        if (value == null) {
            Log.e(tag, "int[]:     Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "int[" + i + "]:     " + Integer.toString(value[i]));
            }
        }
    }

    public static void e(long value) {
        Log.e(tag, "long:      " + Long.toString(value));
    }

    public static void e(long[] value) {
        if (value == null) {
            Log.e(tag, "long[]:    Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "long[" + i + "]:    " + Long.toString(value[i]));
            }
        }
    }

    public static void e(short value) {
        Log.e(tag, "short:     " + Short.toString(value));
    }

    public static void e(short[] value) {
        if (value == null) {
            Log.e(tag, "short[]:   Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "short[" + i + "]:   " + Short.toString(value[i]));
            }
        }
    }

    public static void e(String value) {
        if (TextUtils.isEmpty(value)) {
            value = "is empty";
        }
        Log.e(tag, "String:    " + value);
    }

    public static void e(String[] value) {
        if (value == null) {
            Log.e(tag, "String[]:  Empty");
        } else {
            int length = value.length;
            Log.e(tag, "length:    " + length);
            for (int i = 0; i < length; i++) {
                Log.e(tag, "String[" + i + "]:  " + value[i]);
            }
        }
    }
}
