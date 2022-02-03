import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(99999999, 1 + 1);
    }
    @Test
   public void checkContent() {
    
       try {
           Path filePath = Path.of("test-file3.md");
           String contents = Files.readString(filePath);
           
        
       } catch(Exception e) {
            System.out.println(e.toString());
       }
   }
   @Test
   public void jTestPlat() {
    
       try {
           Path filePath = Path.of("breaking4.md");
           String contents = Files.readString(filePath);
           
        
       } catch(Exception e) {
            System.out.println(e.toString());
       }
   }
}
