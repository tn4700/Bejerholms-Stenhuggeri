/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NiklasRenner
 */
public class Utility {
    
    public static Timestamp getCurrentTime(){
        Date now = new Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        return timestamp;
    }
    
    public static String formatTimestampToString(Timestamp oldTime){
        String formattedTime = new SimpleDateFormat("dd. MMM yyyy").format(oldTime);
        return formattedTime;
    }
    
    public static String getCurrentTimeToString(){
        String timestamp = new SimpleDateFormat("dd. MMM yyyy").format(getCurrentTime());
        return timestamp;
    }
    
    public static Timestamp getNewTimestamp(String time) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd. MMM yyyy");
        Date date = sdf.parse(time);
        long seconds = date.getTime();
        Timestamp timeStamp = new Timestamp(seconds);  
        return timeStamp;
    }
    
    public static String formatDoubleToKr(double money){
        String moneyString = NumberFormat.getCurrencyInstance().format(money);
        return moneyString;
    }
    
}
