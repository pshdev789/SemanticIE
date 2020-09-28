/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticie;

/**
 *
 * @author Kanchi
 */
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import java.net.URL;
import java.io.InputStreamReader;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import org.jdom2.input.JDOMParseException;
import org.jdom2.JDOMException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import edu.stanford.nlp.trees.TypedDependency;
import java.io.File;
import java.io.FileWriter;
import org.slf4j.impl.StaticLoggerBinder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import jdk.jfr.events.FileWriteEvent;

public class GetRSSFeeds {

    //public static OpenIE dp;
    public String getFeed() {

        String fileName;
        // = "Rss" + new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        boolean ok = false;
        String urlstr = "http://www.music-news.com/rss/UK/news?includeCover=true";
        ArrayList<String> as = null;
        if (urlstr != null) {
            try {
                URL feedUrl = new URL(urlstr);
//
//                SyndFeedInput input = new SyndFeedInput();
//                SyndFeed feed = input.build(new XmlReader(feedUrl));
//                List<SyndEntry> ld =feed.getEntries();
//                //System.out.println(ld);
//                
//                for (SyndEntry syndEntry : ld) {
//                    System.out.println("iii "+syndEntry.toString());
//                }
//
//                ok = true;

                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));

                // System.out.println("Feed Title: " + feed.getTitle());
                File f;
                FileWriter fw;
                int i = 1;
                String accessUrl = "";
                a:
                for (SyndEntry entry : feed.getEntries()) {

                    System.out.println("Entry Title: " + entry.getTitle());
//                   System.out.println("URL: " + entry.getUri());
//                    accessUrl = entry.getUri();
//                    fw.write(entry.getTitle().trim() + ".\n");
                    //comment when testing is done

                    f = new File("Text/" + entry.getTitle() + ".txt");
                    fileName = f.getPath();
                    fw = new FileWriter(fileName, true);
                 //   OpenIE op = new OpenIE();
                    //for the moment keep the return type of the parse fun Collection later revert bk to String
                    //And dependecy for each file is written in seperate file
                   // op.extractTripletes();
                    as = new ArrayList<>();
                    

                        //fw.write(entry.getTitle().toString());
                    
//                    for (SyndContent content : entry.getContents()) {
//                        System.out.println("Content: " + content.getValue());
//                    }
                    // GetWebData.getData(accessUrl);
                    fw.close();
                    System.out.println("");
                }

                if (as.get(0).startsWith("compound")) {

                } else if (as.get(0).startsWith("compound") && as.get(1).startsWith("compound")) {

                } else {

                }

            } catch (FeedException | IOException | IllegalArgumentException ex) {
                ex.printStackTrace();
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        if (!ok) {
            System.out.println();
            System.out.println("FeedReader reads and prints any RSS/Atom feed type.");
            System.out.println("The first parameter must be the URL of the feed to read.");
            System.out.println();
        }
        return "";
    }

}
