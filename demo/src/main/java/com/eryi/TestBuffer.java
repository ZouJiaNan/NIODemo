package com.eryi;


import java.nio.ByteBuffer;

/*
缓冲区：在JAVA NIO中负责数据的存取，缓冲区就是数组，用于存储不同数据类型的数据。
        根据数据类型的不同，提供（除boolean外）相应类型的缓冲区：
        ByteBuffer
        CharBuffer
        ShortBuffer
        InBuffer
        LongBuffer
        FloatBuffer
        DoubleBuffer

        缓冲区的基本操作：
        1.获取缓冲区：allocate()
        2.存入数据到缓冲区中：put()
        3.从缓冲区中取出数据：get()

        所有缓冲区都继承于Buufer类，拥有几个核心属性：
        capacity：容量，缓冲区最大存储容量，一旦声明不能改变。
        limit：界限，缓冲区中可操作数据的范围。
        position：位置，缓冲区中正在操作的数据的位置。
        mark：标记，标记当前position的位置，缓冲区调用reset方法可以使position回到mark标记的位置


 */
public class TestBuffer {
    public static void main(String[] args) {
        //1.获取缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        String str="abcde";
        //2.存数据
        byteBuffer.put(str.getBytes());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //3.取数据
        //开启读取模式
        //position指向数据存储区间的首位
        //limit指向数据存储区间的末位
        byteBuffer.flip();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        //读取缓冲区中数据,获取的是一个字节数组。
        byte[] dst=new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //4.归位
        //position归位到数据存储区间的首位
        //limit归位到数据存储区间的末位
        byteBuffer.rewind();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //5.清空
        //清空只是假清空，只是核心参数全部回初始状态，以待重写覆盖，但缓冲区中原来的数据仍然存在且可读取。
        byteBuffer.clear();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        //6.判空
        if(byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.remaining());
        }

    }
}
