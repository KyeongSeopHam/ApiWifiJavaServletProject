package model.vo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryDAOTest {




    HistoryDAO historyDAO = new HistoryDAO();



    @Test
    void svaeTest(){
        int result = historyDAO.save(35.232, 127.323);

        assertEquals(1,result);

    }
    
    
    @Test
    void selectInfo(){
        List<HistoryVO> result = historyDAO.HistoryselectAll();
        
        assertEquals(4,result.size());
    }


    @Test
    void removeOneData(){

        int result = historyDAO.removeOneData(1);

        assertEquals(1,result);

    }





}