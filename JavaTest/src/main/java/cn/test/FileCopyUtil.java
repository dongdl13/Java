package main.java.cn.test;

import org.springframework.util.Assert;

import java.io.*;

public class FileCopyUtil {

    public static void main(String[] args) {
        File in = new File("D://123.txt");
        File out = new File("D://123_copy.txt");
        int byteCount = 0;
        try {
            byteCount = copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(byteCount);
    }

    public static int copy(File in, File out) throws IOException {
        Assert.notNull(in, "No input File specified");
        Assert.notNull(in, "No output File specified");

        return copy(new BufferedInputStream(new FileInputStream(in)), new BufferedOutputStream(new FileOutputStream
                (out)));
    }

    public static int copy(InputStream in, OutputStream out) throws IOException {
        Assert.notNull(in, "No InputStream specified");
        Assert.notNull(out, "No outputStream specified");

        try {
            return doCopy(in, out);
        } finally {
            try {
                in.close();
            } catch (IOException ignored) {
                ;
            }
            try {
                out.close();
            } catch (IOException ignored) {
                ;
            }
        }
    }

    public static int doCopy(InputStream in, OutputStream out) throws IOException {
        Assert.notNull(in, "No InputStream specified");
        Assert.notNull(out, "No OutputStream specified");

        int byteCount = 0;
        byte[] buffer = new byte[1024];
        int bytesRead;

        for (boolean var1 = true; (bytesRead = in.read(buffer)) != -1; byteCount += bytesRead) {
            out.write(buffer, 0, bytesRead);
        }
        out.flush();
        return byteCount;
    }
}
