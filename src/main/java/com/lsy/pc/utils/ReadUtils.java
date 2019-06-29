package com.lsy.pc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ReadUtils {

    public static String readTxtFile(String filePath) { //优化读取txt工具，防止io阻塞
        String content = null;
        try (Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            StringBuilder sb = new StringBuilder();
            char[] tempchars = new char[1024];
            while (reader.read(tempchars) != -1) {
                sb.append(tempchars);
            }
            content = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
