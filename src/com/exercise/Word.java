package com.exercise;

import java.util.Objects;

public class Word{
    private boolean show = false;
    private String text;

    public Word(String text){
        this.text= text;
    }

    public String getText() {
        return text;
    }

    public void uncover(){
        show = true;
    }

    public boolean isUncovered() {
        return show;
    }
    public void cover(){
        show = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return word.getText().equals(text);
    }
}
