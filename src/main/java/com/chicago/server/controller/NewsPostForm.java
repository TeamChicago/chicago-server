package com.chicago.server.controller;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter @Setter
public class NewsPostForm {

    private String title;
    private String content;
    private String writer;

}
