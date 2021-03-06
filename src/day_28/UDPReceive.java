package day_28;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Java_Test
 * @description: UDP接收方
 * @author: Wang Jun
 * @create: 2020-03-25 21:30
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        /**
         * 创建接受端，必须要有端口号
         */
        DatagramSocket ds = new DatagramSocket(6000);
        /**
         * 创捷接受的字节数组
         */
        byte[] bytes = new byte[1024*64];
        while (true){
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            ds.receive(dp);
            int length = dp.getLength();
            System.out.println("接受信息："+new String(bytes,0,length));
            System.out.println("发送方IP:"+dp.getAddress().getHostAddress());
            System.out.println("发送方端口号："+dp.getPort());
        }
//        ds.close();
    }
}
