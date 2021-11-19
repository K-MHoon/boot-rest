package com.community.rest.event;

import com.community.rest.domain.Board;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class BoardEventHandler {

    @HandleBeforeCreate
    public void beforeCreateBoard(Board board) {
        board.changeCreatedTime();
    }

    @HandleBeforeCreate
    public void beforeSaveBoard(Board board) {
        board.changeUpdatedTime();
    }
}
