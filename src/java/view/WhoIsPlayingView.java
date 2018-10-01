/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

// classes imported from java.sql.*
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.whoIsPlaying.*;

// classes in my project
import dbUtils.*;

public class WhoIsPlayingView {

    public static StringDataList allUsersAPI(DbConn dbc) {

        //PreparedStatement stmt = null;
        //ResultSet results = null;
        StringDataList sdl = new StringDataList();
        try {
            String sql = "SELECT who_is_playing_id, join_time, definitely_playing, "+
                    "web_user.web_user_id, tabletop_game.tabletop_game_id, "+
                    "FROM who_is_playing, web_user, tableto;lp_game WHERE web_user.user_role_id = user_role.user_role_id " + 
                    "ORDER BY who_is_playing_id ";  // you always want to order by something, not just random order.
            PreparedStatement stmt = dbc.getConn().prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                sdl.add(results);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            StringData sd = new StringData();
            sd.errorMsg = "Exception thrown in WhoIsPlayingView.allUsersAPI(): " + e.getMessage();
            sdl.add(sd);
        }
        return sdl;
    }

}