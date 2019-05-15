package com.vilniuscoding.hotel;

import java.io.IOException;
import java.io.OutputStream;

import javafx.scene.control.TextArea;

public class CustomOutputStream extends OutputStream {
    private TextArea textArea;
     
    public CustomOutputStream(TextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.appendText(String.valueOf((char)b));
        // scrolls the text area to the end of data
        //textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}