package model.vo;

import model.JdbcManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAO extends JdbcManager {


    public int save(Double lat, Double lnt) {
        Connection con = null;
        PreparedStatement ps = null;

        String insertQuery = "insert into history(lat,lnt,date)" +
                "values(?,?,now())";

        try {
            con = createConnection();
            // select 뺴고
            // insert,update,delete 트랜젝션
            con.setAutoCommit(false); // 트랜젝션시작

            ps = con.prepareStatement(insertQuery);
            ps.setDouble(1, lat);
            ps.setDouble(2, lnt);
            int resultCount = ps.executeUpdate();
            con.commit();
            return resultCount;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            closeStatement(ps);
            closeConnection(con);
        }


    }


    public List<HistoryVO> HistoryselectAll() {


        String searchSql = " select * from history " +
                " order by id desc ";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; // 한줄씩읽는애
        try {
            con = createConnection();
            ps = con.prepareStatement(searchSql);
            rs = ps.executeQuery();
            List<HistoryVO> historyVOList = new ArrayList<>();
            while (rs.next()) {

                historyVOList.add(new HistoryVO(
                        rs.getString("id"), rs.getDouble("lat"), rs.getDouble("lnt")
                        ,rs.getString("date"))
                );
            }
            return historyVOList;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(con);
        }


    }

    public int removeAllData(){

        Connection con = null;
        PreparedStatement ps = null;

        String removeOneQuery = "delete from history ";


        try {
            con = createConnection();
            // select 뺴고
            // insert,update,delete 트랜젝션
            con.setAutoCommit(false); // 트랜젝션시작

            ps = con.prepareStatement(removeOneQuery);

            int resultCount = ps.executeUpdate();
            con.commit();
            return resultCount;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            closeStatement(ps);
            closeConnection(con);
        }



    }


    public int removeOneData(int id){

        Connection con = null;
        PreparedStatement ps = null;

        String removeOneQuery = "delete from history "+
                "where id = ?";

        try {
            con = createConnection();
            // select 뺴고
            // insert,update,delete 트랜젝션
            con.setAutoCommit(false); // 트랜젝션시작

            ps = con.prepareStatement(removeOneQuery);
            ps.setInt(1,id);
            int resultCount = ps.executeUpdate();
            con.commit();
            return resultCount;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            closeStatement(ps);
            closeConnection(con);
        }



    }


}
