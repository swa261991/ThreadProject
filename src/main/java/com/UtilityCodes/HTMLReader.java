package com.UtilityCodes;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLReader {
    public static void main(String[] args) {
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("E:\\\\Projects\\\\ThreadProject\\\\src\\\\main\\\\java\\\\com\\\\UtilityCodes\\\\input.html"), "ISO-8859-1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String h1 = htmlFile.body().getElementsByTag("h1").text();

        Elements span = htmlFile.getElementsByTag("span");
        Pattern p = Pattern.compile("<span>(.*?)</span>");
        Pattern p1 = Pattern.compile("<br><span>(.*?)</span></span>");
        Pattern p2 = Pattern.compile("<span>(.*?)min</span>");
        Matcher m = null;
        boolean readThisLine = false, containsBR = false, eligibleForNewLine = true;
        String str;
        for (Element element : span) {
            str = element.toString();
            if(str.contains("<span width="))continue;
            m = p.matcher(str);
            containsBR = str.contains("<br>");
            while(m.find()) {
                String group = m.group(1);
                if (group.contains("<span>") || readThisLine) {
                    System.out.print("\n");
                    System.out.print(group.replaceAll("<span>","")+(containsBR?" ":""));
                }
                //System.out.println((element.toString().contains("<br>")?"<br>":"")+m.group(1));
                break;
            }
            m = p1.matcher(str);
            while (m.find()) {
                String group = m.group(1);
                System.out.print(group);
                break;
            }
            m = p2.matcher(str);
            while (m.find()) {
                eligibleForNewLine = true;
                System.out.print("\t"+m.group(1)+"\tmin");
            }
        }
    }
}
