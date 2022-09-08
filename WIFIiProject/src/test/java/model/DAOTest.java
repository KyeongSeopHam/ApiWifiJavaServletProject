package model;

import model.vo.WifiVO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOTest {

    private DAO dao = new DAO();
//37.511167,127.098328
    // 37.502982
//127.041564
    @Test
    void  serachTest(){
        List<WifiVO> search = dao.search( 37.502982,127.041564);
        assertEquals(20,search.size());
    }

}