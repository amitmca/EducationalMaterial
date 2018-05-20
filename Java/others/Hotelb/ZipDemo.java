
import java.io.*;

class ZipDemo
{

    ZipDemo(FileInputStream fileinputstream, FileOutputStream fileoutputstream)
    {
        outbuff = new byte[16384];
        inbuff = new byte[16384];
        hash_tbl = new int[4096];
        Verbose = false;
        total_bytes = 0L;
        in = fileinputstream;
        out = fileoutputstream;
        System.out.println("ZipDemo v1.0 3-15-96 (c) Master Creative Software, Inc\n");
    }

    ZipDemo(ByteArrayInputStream bytearrayinputstream, FileOutputStream fileoutputstream)
    {
        outbuff = new byte[16384];
        inbuff = new byte[16384];
        hash_tbl = new int[4096];
        Verbose = false;
        total_bytes = 0L;
        in = bytearrayinputstream;
        out = fileoutputstream;
        System.out.println("ZipDemo v1.0 3-15-96 (c) Master Creative Software, Inc\n");
    }

    ZipDemo(ByteArrayInputStream bytearrayinputstream, ByteArrayOutputStream bytearrayoutputstream)
    {
        outbuff = new byte[16384];
        inbuff = new byte[16384];
        hash_tbl = new int[4096];
        Verbose = false;
        total_bytes = 0L;
        in = bytearrayinputstream;
        out = bytearrayoutputstream;
        System.out.println("ZipDemo v1.0 3-15-96 (c) Master Creative Software, Inc\n");
    }

    ZipDemo(BufferedInputStream bufferedinputstream, BufferedOutputStream bufferedoutputstream)
    {
        outbuff = new byte[16384];
        inbuff = new byte[16384];
        hash_tbl = new int[4096];
        Verbose = false;
        total_bytes = 0L;
        in = bufferedinputstream;
        out = bufferedoutputstream;
        System.out.println("ZipDemo v1.0 3-15-96 (c) Master Creative Software, Inc\n");
    }

    private void InitArray(byte abyte0[])
    {
        for(int i = 0; i < abyte0.length; i++)
            abyte0[i] = 0;

    }

    private void InitArray(byte abyte0[], int i, int j, byte byte0)
    {
        for(; j > 0; j--)
        {
            abyte0[i] = byte0;
            i++;
        }

    }

    private void InitArray(int ai[])
    {
        for(int i = 0; i < ai.length; i++)
            ai[i] = 0;

    }

    public int ZipDemo_CompressStream()
    {
        boolean flag = false;
        boolean flag1 = false;
        long l = 0L;
        bytesproccessed = 0L;
        InitArray(hash_tbl);
        try
        {
            total_bytes = in.available();
            int i;
            while((i = in.read(inbuff, 0, 16384)) > 0) 
            {
                bytesproccessed += i;
                short word0 = compressbuf(i);
                l += word0;
                byte byte0 = (byte)(word0 >> 8 & 0xff);
                byte byte1 = (byte)word0;
                out.write(byte1);
                out.write(byte0);
                if(word0 < 0)
                    word0 = (short)(-word0);
                out.write(outbuff, 0, word0);
                if(Verbose)
                    System.out.print("Compressing (" + (int)((double)((float)bytesproccessed / (float)total_bytes) * 100D) + ") % Complete    \r ");
                if(i != 16384)
                    break;
            }
            boolean flag2 = false;
            out.write(0);
            out.write(0);
            if(Verbose)
                System.out.println("Compressed (" + (100 - (int)((double)((float)l / (float)total_bytes) * 100D)) + ") % done !     ");
        }
        catch(Exception exception)
        {
            System.err.println(exception);
            System.exit(1);
        }
        return 1;
    }

    private short compressbuf(int i)
    {
        int j = 0;
        int k = i;
        int j2 = 4095;
        char c = '\0';
        int k2 = 0;
        int l2 = 2;
        int i3 = 0;
        int j3 = i - 48 - 1;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        if(i <= 18)
        {
            System.arraycopy(inbuff, 0, outbuff, 0, i);
            return (short)(-i);
        }
        j2--;
        while(j < k) 
        {
            if(k2++ == 16)
            {
                outbuff[i3] = (byte)c;
                outbuff[i3 + 1] = (byte)(c >> 8 & 0xff);
                k2 = 1;
                i3 = l2;
                if((l2 += 2) > j3)
                {
                    System.arraycopy(inbuff, 0, outbuff, 0, i);
                    return (short)(-i);
                }
            }
            int l = j;
            byte byte0;
            for(byte0 = inbuff[j++]; j < k && inbuff[j] == byte0 && j - l < 4114; j++);
            int j1;
            if((j1 = j - l) > 2)
            {
                if(j1 <= 18)
                {
                    outbuff[l2++] = (byte)(j1 - 3);
                    outbuff[l2++] = byte0;
                } else
                {
                    j1 -= 19;
                    outbuff[l2++] = (byte)(16 + (j1 & 0xf));
                    outbuff[l2++] = (byte)(j1 >> 4);
                    outbuff[l2++] = byte0;
                }
                c = (char)(c << 1 | 1);
                continue;
            }
            j = l;
            if(k - j > 2)
            {
                char c1 = (char)inbuff[j];
                if(c1 > '\377')
                    c1 = (char)((char)(c1 << 8) >> 8);
                char c2 = (char)inbuff[j + 1];
                if(c2 > '\377')
                    c2 = (char)((char)(c2 << 8) >> 8);
                char c3 = (char)inbuff[j + 2];
                if(c3 > '\377')
                    c3 = (char)((char)(c3 << 8) >> 8);
                int i2 = (((c1 & 0xf) << 8 | c2) ^ (c1 >> 4 | c3 << 4)) & j2;
                int i1 = hash_tbl[i2];
                hash_tbl[i2] = j;
                int l1 = j - i1;
                if(l1 <= 4098)
                {
                    for(; j < k && i1 < l && inbuff[i1] == inbuff[j] && j - l < 271; i1++)
                        j++;

                    int k1 = j - l;
                    if(k1 > 2)
                    {
                        l1 -= 3;
                        if(k1 <= 15)
                        {
                            outbuff[l2++] = (byte)((k1 << 4) + (l1 & 0xf));
                            outbuff[l2++] = (byte)(l1 >> 4);
                        } else
                        {
                            outbuff[l2++] = (byte)(32 + (l1 & 0xf));
                            outbuff[l2++] = (byte)(l1 >> 4);
                            outbuff[l2++] = (byte)(k1 - 16);
                        }
                        c = (char)(c << 1 | 1);
                        continue;
                    }
                }
            }
            outbuff[l2++] = byte0;
            j = ++l;
            c <<= '\001';
        }
        c <<= 16 - k2;
        outbuff[i3] = (byte)c;
        outbuff[i3 + 1] = (byte)((short)c >> 8 & 0xff);
        return (short)l2;
    }

    public void ZipDemo_DeCompressStream()
    {
        boolean flag = false;
        boolean flag1 = false;
        long l = 0L;
        bytesproccessed = 0L;
        try
        {
            total_bytes = in.available();
        }
        catch(Exception _ex) { }
        do
            try
            {
                int j = in.read();
                int k = in.read();
                short word0 = (short)((short)k << 8 | (short)j);
                if(word0 == 0)
                    break;
                int i;
                if(word0 < 0)
                {
                    i = -word0;
                    in.read(outbuff, 0, i);
                } else
                {
                    in.read(inbuff, 0, word0);
                    i = decompress(word0);
                }
                bytesproccessed += word0 + 1;
                out.write(outbuff, 0, i);
                if(Verbose)
                    System.out.print("De-Compressing (" + (int)((double)((float)bytesproccessed / (float)total_bytes) * 100D) + ") % Complete     \r");
            }
            catch(Exception exception)
            {
                System.err.println(exception);
                System.out.println("Failed to READ Compressed Stream");
                System.exit(1);
            }
        while(true);
    }

    private int decompress(int i)
    {
        char c = '\0';
        int j = 0;
        boolean flag = false;
        boolean flag1 = false;
        int k = 0;
        int l = 0;
        for(int i1 = i; k < i1;)
        {
            if((j = (char)(j >> 1)) == 0)
            {
                char c1 = (char)inbuff[k + 1];
                char c4 = (char)inbuff[k];
                if(c1 > '\377')
                    c1 = (char)((char)(c1 << 8) >> 8);
                if(c4 > '\377')
                    c4 = (char)((char)(c4 << 8) >> 8);
                c = (char)((char)(c1 << 8) | c4);
                k += 2;
                j = 32768;
            }
            if((c & j) == 0)
            {
                outbuff[l++] = inbuff[k++];
            } else
            {
                char c5 = (char)(inbuff[k] >>> 4 & 0xf);
                int j1 = (char)(inbuff[k++] & 0xf);
                switch(c5)
                {
                case 0: // '\0'
                    j1 += 3;
                    byte abyte0[] = outbuff;
                    int i2 = l;
                    int k2 = j1;
                    byte byte0 = inbuff[k++];
                    for(; k2 > 0; k2--)
                    {
                        abyte0[i2] = byte0;
                        i2++;
                    }

                    l += j1;
                    break;

                case 1: // '\001'
                    j1 = (char)(j1 + (inbuff[k++] << 4));
                    j1 += 19;
                    byte abyte1[] = outbuff;
                    int j2 = l;
                    int l2 = j1;
                    byte byte1 = inbuff[k++];
                    for(; l2 > 0; l2--)
                    {
                        abyte1[j2] = byte1;
                        j2++;
                    }

                    l += j1;
                    break;

                case 2: // '\002'
                    int k1 = j1 + 3;
                    char c2 = (char)inbuff[k++];
                    if(c2 > '\377')
                        c2 = (char)((char)(c2 << 8) >> 8);
                    k1 += c2 << 4;
                    j1 = (char)inbuff[k++];
                    if(j1 > 255)
                        j1 = (char)((char)(j1 << 8) >> 8);
                    j1 += 16;
                    System.arraycopy(outbuff, l - k1, outbuff, l, j1);
                    l += j1;
                    break;

                default:
                    int l1 = j1 + 3;
                    char c3 = (char)inbuff[k++];
                    if(c3 > '\377')
                        c3 = (char)((char)(c3 << 8) >> 8);
                    l1 += c3 << 4;
                    System.arraycopy(outbuff, l - l1, outbuff, l, c5);
                    l += c5;
                    break;
                }
            }
        }

        return l;
    }

    private static final boolean DEBUG = false;
    private static final int HASH_LEN = 4096;
    private static final int BUFF_LEN = 16384;
    private byte outbuff[];
    private byte inbuff[];
    private int hash_tbl[];
    public boolean Verbose;
    private InputStream in;
    private OutputStream out;
    long total_bytes;
    long bytesproccessed;
}