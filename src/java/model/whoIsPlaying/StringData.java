/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.whoIsPlaying;

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

    public String whoIsPlayingId = "";
    public String joinTime = "";
    public String definitelyPlaying = "";
    public String tabletopPlayerId = "";
    public String tabletopGameId = "";

    public String errorMsg = "";

    // default constructor leaves all data members with empty string (Nothing null).
    public StringData() {
    }

    // overloaded constructor sets all data members by extracting from resultSet.
    public StringData(ResultSet results) {
        try {
            this.whoIsPlayingId = FormatUtils.formatInteger(results.getObject("who_is_playing_id"));
            this.joinTime = FormatUtils.formatDate(results.getObject("join_time"));
            this.definitelyPlaying = FormatUtils.formatInteger(results.getObject("definitely_playing"));
            this.tabletopPlayerId = FormatUtils.formatInteger(results.getObject("tabletop_player_id"));
            this.tabletopGameId = FormatUtils.formatInteger(results.getObject("tabletop_game_id"));
        } catch (Exception e) {
            this.errorMsg = "Exception thrown in model.whoIsPlaying.StringData (the constructor that takes a ResultSet): " + e.getMessage();
        }
    }

    public int getCharacterCount() {
        String s = this.whoIsPlayingId + this.joinTime + this.definitelyPlaying + this.tabletopPlayerId
                + this.tabletopGameId;
        return s.length();
    }

    public String toString() {
        return "Who Is Playing Id:" + this.whoIsPlayingId
                + ", Join Time: " + this.joinTime
                + ", Definitely Playing: " + this.definitelyPlaying
                + ", Tabletop Player Id: " + this.tabletopPlayerId
                + ", Tabletop Game Id: " + this.tabletopGameId;

    }
}
