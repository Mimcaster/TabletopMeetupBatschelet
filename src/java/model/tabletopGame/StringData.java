/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tabletopGame;

import dbUtils.FormatUtils;
import java.sql.ResultSet;


/* The purpose of this class is just to "bundle together" all the 
 * character data that the user might type in when they want to 
 * add a new Customer or edit an existing customer.  This String
 * data is "pre-validated" data, meaning they might have typed 
 * in a character string where a number was expected.
 * 
 * There are no getter or setter methods since we are not trying to
 * protect this data in any way.  We want to let the JSP page have
 * free access to put data in or take it out. */
public class StringData {

    public String tabletopGameId = "";
    public String gameName = "";
    public String gameHost = "";
    public String gameTime = "";
    public String gameLocation = "";
    public String maxPlayer = "";   // Foreign Key
    public String buyIn = ""; // getting it from joined user_role table.
    public String gameDescription = ""; // getting it from joined user_role table.

    public String errorMsg = "";

    // default constructor leaves all data members with empty string (Nothing null).
    public StringData() {
    }

    // overloaded constructor sets all data members by extracting from resultSet.
    public StringData(ResultSet results) {
        try {
            this.tabletopGameId = FormatUtils.formatInteger(results.getObject("tabletop_game_id"));
            this.maxPlayer = FormatUtils.formatInteger(results.getObject("max_player"));
            this.gameTime = FormatUtils.formatDate(results.getObject("game_time"));
            this.gameName = FormatUtils.formatString(results.getObject("game_name"));
            this.gameLocation = FormatUtils.formatString(results.getObject("game_location"));
            this.gameHost = FormatUtils.formatInteger(results.getObject("game_host"));
            this.gameDescription = FormatUtils.formatString(results.getObject("user_role_type"));
            this.buyIn = FormatUtils.formatDollar(results.getObject("buy_in"));
        
        } catch (Exception e) {
            this.errorMsg = "Exception thrown in model.webUser.StringData (the constructor that takes a ResultSet): " + e.getMessage();
        }
    }

    public int getCharacterCount() {
        String s = this.tabletopGameId + this.maxPlayer + this.gameTime + this.gameName
                + this.gameLocation + this.gameHost + this.gameDescription + this.buyIn;
        return s.length();
    }

    public String toString() {
        return "Web User Id:" + this.tabletopGameId
                + ", User Email: " + this.maxPlayer
                + ", User Password: " + this.gameTime
                + ", Birthday: " + this.gameName
                + ", Membership Fee: " + this.gameLocation
                + ", User Role Id: " + this.gameHost
                + ", User Role Id: " + this.gameDescription                
                + ", User Role Type: " + this.buyIn;
    }
}

