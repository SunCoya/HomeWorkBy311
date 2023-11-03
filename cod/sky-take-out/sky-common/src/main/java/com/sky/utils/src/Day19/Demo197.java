package Day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//爬取网络上面的文档
//爬虫时如何忽略掉匹配字符串后面与前面的内容？
public class Demo197 {
    public static void main(String[] args) throws IOException {
        //创建URL对象
        URL url = new URL("https://wiki.52poke.com/wiki/%E5%AE%9D%E5%8F%AF%E6%A2%A6%E5%88%97%E8%A1%A8%EF%BC%88%E6%8C%89%E5%85%A8%E5%9B%BD%E5%9B%BE%E9%89%B4%E7%BC%96%E5%8F%B7%EF%BC%89");
        //连接网址
        URLConnection conn = url.openConnection();
        //创建对象去读取网络数据
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        System.out.println("？<=是忽略前面的内容，只保留后面的内容");
        System.out.println("？=是忽略后面的内容，只保留后面的内容");
        Pattern pattern = Pattern.compile("(?<=title=\").{1,8}(?=\"></span></a>)");
        //每次读取一行
        boolean flag = false;
        loop:
        while ((line = br.readLine()) != null) {
            Matcher m = pattern.matcher(line);
            while (m.find()) {
                if (flag == false) {
                    flag = true;
                    continue loop;
                }
                System.out.println(m.group());
                flag = false;
            }
        }
        br.close();
    }
}
