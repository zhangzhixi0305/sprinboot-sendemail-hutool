package com.zhixi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootEmailApplicationTests {

    @Test
    void contextLoads() {
        /*视频时长：s*/
        // 0d
        // 1h   3600秒
        // 26m  1560秒
        // 40s
//        10天1小时25分30秒

        String str = "6000";
        int seconds = Integer.parseInt(str);
        int temp = 0;
        StringBuffer videolengh = new StringBuffer();
        temp = seconds / 86400;
        videolengh.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");

        temp = (seconds % 86400) / 3600;
        videolengh.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");

        temp = seconds % 3600 / 60;
        videolengh.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");

        temp = seconds % 3600 % 60;
        videolengh.append((temp < 10) ? "0" + temp : "" + temp);

        System.out.println(videolengh.toString());

    }

    @Test
    public void test() {
        System.out.println(secondToTime(520000));
    }

    /**
     * 将秒数转换为日时分秒，
     *
     * @param second
     * @return
     */
    public static String secondToTime(long second) {
        long days = second / 86400;            //转换天数
        second = second % 86400;            //剩余秒数
        long hours = second / 3600;            //转换小时
        second = second % 3600;                //剩余秒数
        long minutes = second / 60;            //转换分钟
        second = second % 60;                //剩余秒数
        if (days > 0) {
            return "0" + days + ":" + hours + ":" + minutes + ":" + second + ":";
        } else {
            return hours + ":" + minutes + ":" + second + ":";
        }
    }
}
