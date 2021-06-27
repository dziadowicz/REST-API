package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.apache.logging.log4j.Logger;
import org.apache.logging.slf4j.SLF4JLogger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloValidatorTestSuite {

    TrelloValidator trelloValidator = new TrelloValidator();

    @Test
    public void validateTrelloBoardsTest() {

        //Given
        TrelloBoard trelloBoard = new TrelloBoard("0", "test", new ArrayList<>());
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "name", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        trelloBoards.add(trelloBoard1);

        //When
        List<TrelloBoard> trelloBoards1 = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, trelloBoards1.size());
    }
}
