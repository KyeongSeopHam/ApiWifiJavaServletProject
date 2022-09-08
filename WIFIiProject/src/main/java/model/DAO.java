package model;

import apidto.RowInfoDto;
import apidto.WifiDto;
import model.vo.WifiVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO extends JdbcManager {

    // DB 커넥션 부분
    Connection coon = null;  // db연결해주는 구분 인터페이스처럼
    PreparedStatement ps = null;   // sql 실행시켜주는 구문
    ResultSet rs = null; // 한줄씩읽는애


    public void Select() {

        String memberType = "일본";
        try {
            coon = createConnection();


            String sql = "select code, country, domain, pilmo" +
                    " from actor  " +
                    " where country = ? " +
                    " limit 5 ";

            ps = coon.prepareStatement(sql);
            ps.setString(1, memberType);
            rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("code");
                String country = rs.getString("country");
                String domain = rs.getString("domain");
                String pilmo = rs.getString("pilmo");
                System.out.println(code + ", " + country + ", " + domain + ", " + pilmo + ", ");
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(coon);

        }

    }


//     잘들어왔니? 반환된 행의수만 반환됨 그 값을보고 0보다클떄면 정상적이구나
//     예로들어 5개가 반영되길원하는데 5개가 아니려라면 문제가있다봄
//     affected : 영향을미치다 라는뜻  -> 어펙티드 로우라고부름
//
//
//    public void Insert(RowInfoDto infoDto) throws SQLException, ClassNotFoundException {
//
//       String sql = "INSERT INTO wifi(관리번호, 자치구, 와이파이명, 도로명주소, 상세주소, 설치위치, 설치유형, 설치기간, 서비스구분," +
//               " 망종류, 설치년도, 실내외구분, wifi접속환경, x좌표, y좌표, 작업일자) " +
//               " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
//
//        coon =createConnection();   // 디비연결
//
//        ps = coon.prepareStatement(sql);  // 객체자체를 prepareStatement 에 넣자 => 이뜻은  prepareStatement를 만들어준다.
//     for(int i=0; i<10;  i++) {
//
//         ps.setString(1, infoDto.getMgrNo());
//         ps.setString(2, infoDto.getWrdofc());
//         ps.setString(3, infoDto.getMainNm());
//         ps.setString(4, infoDto.getAdres1());
//         ps.setString(5, infoDto.getAdres2());
//         ps.setString(6, infoDto.getFloor());
//         ps.setString(7, infoDto.getTy());
//         ps.setString(8, infoDto.getSvcSe());
//         ps.setString(9, infoDto.getCmcwr());
//         ps.setString(10, infoDto.getYear());
//         ps.setString(11, infoDto.getDoor());
//         ps.setString(12, infoDto.getRemars3());
//         ps.setString(13, infoDto.getLat());
//         ps.setString(14, infoDto.getLnt());
//         ps.setString(15, infoDto.getDttm());
//
//
//         ps.addBatch();
//         ps.clearParameters();
//
//         if(i%2000==0){
//             ps.executeBatch();
//             ps.clearBatch();
//             coon.commit();
//         }
//     }
//        ps.executeBatch() ;
//        coon.commit() ;
//
//
//        closeStatement(ps);
//        closeConnection(coon);
//
//
//
//    }

    public void Update() {


        String domain = "연어좋아요";
        String code = "666666";


        try {
            coon = createConnection();

            String sql = "update actor" +
                    " set " +
                    " domain = ?  " +
                    " where code =? ";


            ps = coon.prepareStatement(sql);
            ps.setString(1, domain);
            ps.setString(2, code);

            int affetedRows = ps.executeUpdate();

            if (affetedRows > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            closeStatement(ps);
            closeConnection(coon);

        }


    }

    public void Delete() {


        String country = "한국2";
        String code = "6666";


        try {
            coon = createConnection();

            String sql =
                    "delete from actor " +
                            " where country= ? " +
                            " and code =? ";


            ps = coon.prepareStatement(sql);
            ps.setString(1, country);
            ps.setString(2, code);

            int affetedRows = ps.executeUpdate();

            if (affetedRows > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            closeStatement(ps);
            closeConnection(coon);

        }


    }







    public void saveAllWifiDetailList(List<RowInfoDto> lists) throws Exception {

        String sql = "insert into wifi(x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm, \n" +
                "                 x_swifi_adres1, x_swifi_adres2, x_swifi_instl_floor, \n" +
                "                 x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se, \n" +
                "                 x_swifi_cmcwr, x_swifi_cnstc_year, x_swifi_inout_door, \n" +
                "                 x_swifi_remars3, lat, lnt, work_dttm) \n" +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            coon = createConnection();   // 디비연결

            coon.setAutoCommit(false);


            ps = coon.prepareStatement(sql);  // 객체자체를 prepareStatement 에 넣자 => 이뜻은  prepareStatement를 만들어준다.


            int basicBactchSize = 1000; // 배치사이즈는 500 /  밖에서 1000개씩 짜르기로했으니까 배치를 총 2번만들겠다.

            int count = 0;  // 배치가 가득찾는지 확인하는 용도.

            for (int i = 0; i < lists.size(); i++) {   // 처음에 0~ 999까지 돌면서

                RowInfoDto infoDto = lists.get(i);    // 1개씩( 16개)  RowInfoDto 객체하나
                ps.setString(1, infoDto.getMgrNo());
                ps.setString(2, infoDto.getWrdofc());
                ps.setString(3, infoDto.getMainNm());
                ps.setString(4, infoDto.getAdres1());
                ps.setString(5, infoDto.getAdres2());
                ps.setString(6, infoDto.getFloor());
                ps.setString(7, infoDto.getTy());
                ps.setString(8, infoDto.getMby());
                ps.setString(9, infoDto.getSvcSe());
                ps.setString(10, infoDto.getCmcwr());
                ps.setString(11, infoDto.getYear());
                ps.setString(12, infoDto.getDoor());
                ps.setString(13, infoDto.getRemars3());
                ps.setString(14, infoDto.getLat());
                ps.setString(15, infoDto.getLnt());
                ps.setString(16, infoDto.getDttm());

                ps.addBatch(); // 배치에 1개넣어주고
                count++; // 카운트값을 1 증가시켜주고

                if (basicBactchSize == count) {    //500 == count
                    ps.executeBatch(); // 배치를 실행하고 총2개날릴거 일단 1개
                    ps.clearBatch(); // 배치 청소
                    count = 0; // 카운트 초기화시켜주고
                }
            }
        /*
         18003개있는데 얘가 19번 반복할떄
         18번동안 실행안되다가 배치가 500씩 / 2번 날리는건데
         500 = 3 이 안되므로 그 나머지 3개에 대한부분을 마지막 횟수에서 처리해준다.
         */

            ps.executeBatch();
            coon.commit();
        } catch (Exception e) {
            coon.rollback();
        } finally {
            coon.setAutoCommit(true);
            closeStatement(ps);
            closeConnection(coon);
        }
    }

    /**
     * dao.search(latDouble,lntDouble);
     */



    public List<WifiVO> search(Double latDouble, Double lntDouble) {

        String selectNearWifiQuery = "select * " +
                ", format((6371 * acos(cos(radians(" + lntDouble + ")) * cos(radians(lat)) * cos(radians(lnt) - radians(" + latDouble + ")) " +
                "+ sin(radians(" + lntDouble + ")) * sin(radians(lat)))), 4) as distance " +
                " from wifi " +
                " order by distance , X_SWIFI_MGR_NO" +
                " limit 20";

        try {
            coon = createConnection();
            ps = coon.prepareStatement(selectNearWifiQuery);
            rs = ps.executeQuery(); // 20개씩


            List<WifiVO> list = new ArrayList<>();


            while (rs.next()) {
                WifiVO wifiVO = new WifiVO(
                        rs.getString("distance"),
                        rs.getString("X_SWIFI_MGR_NO"),
                        rs.getString("X_SWIFI_WRDOFC"),
                        rs.getString("X_SWIFI_MAIN_NM"),
                        rs.getString("X_SWIFI_ADRES1"),
                        rs.getString("X_SWIFI_ADRES2"),
                        rs.getString("X_SWIFI_INSTL_FLOOR"),
                        rs.getString("X_SWIFI_INSTL_TY"),
                        rs.getString("X_SWIFI_INSTL_MBY"),
                        rs.getString("X_SWIFI_SVC_SE"),
                        rs.getString("X_SWIFI_CMCWR"),
                        rs.getString("X_SWIFI_CNSTC_YEAR"),
                        rs.getString("X_SWIFI_INOUT_DOOR"),
                        rs.getString("X_SWIFI_REMARS3"),
                        rs.getString("LAT"),
                        rs.getString("LNT"),
                        rs.getString("WORK_DTTM")

                );

                list.add(wifiVO);


            }
            return list;


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeConnection(coon);
        }


    }







 // 데이터 자꾸쌓이니까 삭제해줄 쿼리
    public int removeAllData(){

        Connection con = null;
        PreparedStatement ps = null;

        String removeOneQuery = "delete from wifi ";


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


}






