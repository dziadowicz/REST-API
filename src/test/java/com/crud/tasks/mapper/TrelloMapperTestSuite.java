package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {

    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("0", "name", new ArrayList<TrelloListDto>());
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "name1", new ArrayList<TrelloListDto>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        trelloBoardDtoList.add(trelloBoardDto1);

        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(resultList.get(0).getClass(), TrelloBoard.class);
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("0", "name", new ArrayList<TrelloList>());
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "name1", new ArrayList<TrelloList>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        trelloBoardList.add(trelloBoard1);

        //When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(resultList.get(0).getClass(), TrelloBoardDto.class);
    }

    @Test
    public void mapToListTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("0", "name", true);
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name1", false);
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto);
        trelloListDtoList.add(trelloListDto1);

        //When
        List<TrelloList> resultList = trelloMapper.mapToList(trelloListDtoList);

        //Then
        assertEquals(TrelloList.class, resultList.get(0).getClass());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("0", "name", true);
        TrelloList trelloList1 = new TrelloList("1", "name1", false);
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList);
        trelloListList.add(trelloList1);

        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(trelloListList);

        //Then
        assertEquals(TrelloListDto.class, resultList.get(0).getClass());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "a", "b", "0");

        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(TrelloCard.class, result.getClass());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "a", "b", "0");

        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(TrelloCardDto.class, result.getClass());
    }
}
