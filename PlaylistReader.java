/**
 * 
 */
package dailymixes;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author nakyahv
 * @version 04.13
 *
 */
/**
 * @author nakya
 *
 */
public class PlaylistReader {
    private ArrayQueue<Song> queue;
    private Playlist[] playlists;

    /**
     * @param songsFileName
     * @param playlistsFileName
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public PlaylistReader(String songsFileName, String playlistsFileName)
        throws FileNotFoundException,
        ParseException,
        DailyMixDataException {
        queue = readQueueFile(songsFileName);
        playlists = readPlaylistFile(playlistsFileName);
        PlaylistWindow window = new PlaylistWindow(new PlaylistCalculator(queue,
            playlists));
    }


    /**
     * @param num1
     * @param num2
     * @param num3
     * @return if its in range
     */
    private boolean isInValidPercentRange(int num1, int num2, int num3) {
        return ((num1 >= PlaylistCalculator.MIN_PERCENT
            && num1 <= PlaylistCalculator.MAX_PERCENT)
            && (num2 >= PlaylistCalculator.MIN_PERCENT
                && num2 <= PlaylistCalculator.MAX_PERCENT)
            && (num3 >= PlaylistCalculator.MIN_PERCENT
                && num3 <= PlaylistCalculator.MAX_PERCENT));
    }


    /**
     * @param playlistFileName
     * @return playlist array
     * @throws FileNotFoundException
     * @throws DailyMixDataException
     * @throws ParseException
     */
    private Playlist[] readPlaylistFile(String playlistFileName)
        throws FileNotFoundException,
        DailyMixDataException,
        ParseException {
        Playlist[] temp = new Playlist[PlaylistCalculator.NUM_PLAYLISTS];
        File file = new File(playlistFileName);
        Scanner s = new Scanner(file);
        String[] str = new String[8];

        int i = 0;
        s.useDelimiter(",\\s*");
        while (s.hasNextLine() && i < 3) {
            Scanner scan = new Scanner(s.nextLine());
            scan.useDelimiter(",\\s*");
            int j = 0;
            while (scan.hasNext()) {
                if (j == 8) {
                    scan.close();
                    throw new ParseException("Parse Exception thrown", 1);

                }

                str[j] = scan.next();
                j++;
            }
            scan.close();

            if (j != 8) {
                throw new ParseException("Parse Exception", 1);

            }

            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            for (int x = 1; i <= 4; i = i + 3) {
                num1 = Integer.parseInt(str[x]);
                num2 = Integer.parseInt(str[x + 1]);
                num3 = Integer.parseInt(str[x + 2]);
                if (!(this.isInValidPercentRange(num1, num2, num3))) {
                    throw new DailyMixDataException(playlistFileName);

                }
            }

            String name = str[0];
            int minimum = Integer.parseInt(str[1]);
            int min2 = Integer.parseInt(str[2]);
            int min3 = Integer.parseInt(str[3]);
            int maximum = Integer.parseInt(str[4]);
            int max2 = Integer.parseInt(str[5]);
            int max3 = Integer.parseInt(str[6]);
            int top = Integer.parseInt(str[7]);

            temp[i] = new Playlist(name, minimum, min2, min3, maximum, max2,
                max3, top);
            i++;

        }
        s.close();

        if (i <= 2) {
            throw new DailyMixDataException(playlistFileName);

        }

        return temp;

    }


    /**
     * @param songFileName
     * @return
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws DailyMixDataException
     */
    private ArrayQueue<Song> readQueueFile(String songFileName)
        throws FileNotFoundException,
        ParseException,
        DailyMixDataException {

        ArrayQueue<Song> temp = new ArrayQueue<Song>(
            ArrayQueue.DEFAULT_CAPACITY);
        File file = new File(songFileName);
        Scanner scan = new Scanner(file);

        scan.useDelimiter(",\\s*");
        while (scan.hasNextLine()) {
            Scanner scanner = new Scanner(scan.nextLine());
            scanner.useDelimiter(",\\s*");
            int i = 0;
            String[] string = new String[5];
            while (scanner.hasNext()) {
                if (i == 5) {
                    scanner.close();
                    throw new ParseException("Parse Exception thrown", 1);
                }

                string[i] = scanner.next();
                i++;
            }
            scanner.close();

            String name = string[0];
            String suggested = "";
            int p = Integer.parseInt(string[1]);
            int r = Integer.parseInt(string[2]);
            int c = Integer.parseInt(string[3]);
            if (!(this.isInValidPercentRange(p, r, c))) {
                throw new DailyMixDataException(songFileName);
            }
            if (string[4] == null) {
                throw new ParseException("Parse Exception thrown", 1);

            }
            else {
                suggested = string[4];

            }
            Song song = new Song(name, p, r, c, suggested);
            temp.enqueue(song);

        }
        scan.close();
        return temp;

    }

}
