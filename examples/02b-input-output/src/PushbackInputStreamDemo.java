import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

class PushbackInputStreamDemo { 
    public static void main(String[] args) { 
        String s = "if (a == 4) a = 0;\n"; 

        byte[] buf = s.getBytes(); 

        ByteArrayInputStream in = new ByteArrayInputStream(buf); 

        int c; 

        try ( PushbackInputStream f = new PushbackInputStream(in) ) { 
            while ((c = f.read()) != -1) { 
                switch(c) { 
                    case '=' -> {
                        if ((c = f.read()) == '='){
                            System.out.print(".eq.");
                        }
                        else {
                            System.out.print("<-");
                            f.unread(c);
                        }
                    }
                    default -> System.out.print((char) c); 
                } 
            } 
        } catch(IOException e) { 
            System.out.println("I/O Error: " + e); 
        } 
    } 
}