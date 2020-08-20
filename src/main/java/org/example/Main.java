package org.example;

import org.apache.commons.codec.digest.DigestUtils;
import scala.Int;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        System.out.println(Math.round(1.3));
        Random random = new Random();
        System.out.println(random.nextFloat());

        System.out.println(String.format("%.2f", random.nextFloat()));
        System.out.printf("%.2f", random.nextFloat());
        System.out.println();
        System.out.println("pro: " + Runtime.getRuntime().availableProcessors());

        System.out.println(5/2);
        System.out.println((float) 5/2);
        String dt = "2020-08-08";
        String sql1 = "select t1.install_channel, t1.mid, t2.oaid, t2.imei, t2.mac, t1.os, t1.machine, t2.ip, t2.atime,t1.product \n" +
                "from \n" +
                "(\n" +
                "SELECT mid,os,machine,insdttall_channel,product\n" +
                "FROM gamelive.dw_huya_new_user  \n" +
                "WHERE dt='" + dt + "' AND new_user_type='ukey' AND  new_data_type='product' AND " +
                //"(install_channel like 'a\\_%' or install_channel like '%baidusem%')\n" +
                "(install_channel = 'vivo')\n" +
                ") t1 \n" +
                "left join \n" +
                "(\n" +
                "select mid, imei, mac, ip, oaid, min(time) as atime from user_growth.dim_action_detail where dt='"+ dt +"' group by " +
                "mid, imei, mac, ip, oaid \n" +
                ") t2 on (t1.mid=t2.mid) WHERE t2.mid IS NOT NULL";
        System.out.println(sql1);
        System.out.println(DigestUtils.md5Hex("868396045267963"));
        System.out.println(DigestUtils.md5Hex("Huya2020"));
        System.out.println(DigestUtils.md5Hex("__IMEI2__"));
        System.out.println(DigestUtils.md5Hex("862498044040197"));
        System.out.println("test");
        long time  = 1597146138844L;
        System.out.println(time / 1000);
        System.out.println((int)(time / 1000));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(DigestUtils.md5Hex("862756043583495"));

//        String strIp = "183.199.130.166";
//        String strIp = "183|199|130|166";
//        String strIp = "183\\199\\130\\166";
//        String strIp = "";
//        String[]ip = strIp.split("\\\\");
//        System.out.println(ip.length);
//        System.out.println((Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]));
//        System.out.println((Integer.parseInt(ip[0]) << 24) + (Integer.parseInt(ip[1]) << 16) + (Integer.parseInt(ip[2]) << 8) + Integer.parseInt(ip[3]));
//
//        System.out.println(Long.valueOf("10110111110001111000001010100110", 2));
//
//        System.out.println(Integer.MAX_VALUE);

    }
}
