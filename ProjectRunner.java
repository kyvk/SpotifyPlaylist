/**
 * 
 */
package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author nakyah
 * @version 04.14
 *
 */
public class ProjectRunner {

    /**
     * @param args
     * @throws DailyMixDataException 
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException, DailyMixDataException {
        if(args.length==0) {
            PlaylistReader run= new PlaylistReader("input.txt", "playlists.txt");
        }
        if(args.length==2) {
            PlaylistReader arg2= new PlaylistReader(args[0], args[1]);
        }
       
    }
}
