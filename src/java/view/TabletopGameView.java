/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author rpbat
 */
// classes imported from java.sql.*
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.tabletopGame.*;

// classes in my project
import dbUtils.*;

public class TabletopGameView {

    public static StringDataList allGamesAPI(DbConn dbc) {

        //PreparedStatement stmt = null;
        //ResultSet results = null;
        StringDataList sdl = new StringDataList();
        try {
            String sql = "SELECT tabletop_game_id, game_name, game_host, game_time, game_location, max_player, buy_in, "+
                    "game_location "+
                    "FROM tabletop_game" + 
                    "ORDER BY tabletop_game_id ";  // you always want to order by something, not just random order.
            PreparedStatement stmt = dbc.getConn().prepareStatement(sql);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                sdl.add(results);
            }
            results.close();
            stmt.close();
        } catch (Exception e) {
            StringData sd = new StringData();
            sd.errorMsg = "Exception thrown in TabletopGameView.allUsersAPI(): " + e.getMessage();
            sdl.add(sd);
        }
        return sdl;
    }

}