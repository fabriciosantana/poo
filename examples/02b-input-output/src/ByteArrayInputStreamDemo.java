 
import java.io.ByteArrayInputStream;

class ByteArrayInputStreamDemo { 
    public static void main(String[] args) { 
        String tmp = "abcdefghijklmnopqrstuvwxyz"; 
        
        byte[] b = tmp.getBytes(); 
        
        ByteArrayInputStream input1 = new ByteArrayInputStream(b); 
        ByteArrayInputStream input2 = new ByteArrayInputStream(b,0,3);
        
        System.out.println((char) b[0]);
        System.out.println(b[0]);
        System.out.println((char) input1.read());
        System.out.println((char) input1.read());

        System.out.println((char) input2.read());
        System.out.println((char) input2.read());

        System.out.println();

        input1.reset();
        input2.reset();

        System.out.println((char) input1.read());
        System.out.println((char) input2.read());

    } 
} 