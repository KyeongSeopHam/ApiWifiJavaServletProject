package model;

import java.sql.*;


public class JdbcManager {

        public void closeResultSet(ResultSet rs){
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        }

        public void closeStatement(PreparedStatement st){
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void closeConnection(Connection con){


            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public Connection createConnection() throws ClassNotFoundException, SQLException {
            //아이피 포트 계정 패스워드 인스턴스
            String url = "jdbc:mariadb://localhost/wi_db";
            String id = "root";
            String password = "root";

            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);

        }


    }



