package com.activemesa.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

class Sentence
{
  private String plainText;
  private List<WordToken> wordTokens = new ArrayList<>();

  public Sentence(String plainText)
  {
    this.plainText = plainText;
  }

  public WordToken getWord(int index)
  {
    WordToken wordToken = new WordToken(index);
    wordTokens.add(wordToken);

    return wordToken;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();

    String[] words = plainText.split(" ");

    for (int i = 0; i < words.length; i++) {
      String w = words[i];

      for (WordToken wordToken : wordTokens) {
        w = wordToken.existsWord(i) && wordToken.capitalize ? w.toUpperCase() : w;
      }
      sb.append(w).append(" ");
    }

    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
  }

  class WordToken
  {
    public int index;
    public boolean capitalize;

    public WordToken(int index) {
      this.index = index;
    }

    public boolean existsWord(int index) {
      return this.index == index;
    }
  }
}

public class Exercise {

  public static void main(String[] args) {
    Sentence sentence = new Sentence("hello world");
    sentence.getWord(1).capitalize = true;
    System.out.println(sentence);
  }

}
