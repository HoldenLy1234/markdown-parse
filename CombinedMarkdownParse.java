
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CombinedMarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        int lastClosedParen=markdown.lastIndexOf(")");
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextOpenCarrot = markdown.indexOf("<", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int nextCloseCarrot = markdown.indexOf(">", nextOpenCarrot);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            System.out.println(currentIndex);
            currentIndex = closeParen + 1;
            if (nextOpenBracket == -1 || nextCloseBracket == -1 ||
            nextOpenCarrot == -1 || nextCloseCarrot == -1 ||
            openParen == -1 || closeParen == -1||closeParen==lastClosedParen){
                break;
            }
            if(markdown.charAt(nextOpenBracket-1) != '!'){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            toReturn.add(markdown.substring(nextOpenCarrot + 1, nextCloseCarrot));
            
        }
        
        System.out.println(currentIndex);
        int test = markdown.indexOf("]");
        System.out.println(test);
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
