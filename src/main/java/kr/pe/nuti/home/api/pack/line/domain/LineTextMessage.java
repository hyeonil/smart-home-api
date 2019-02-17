package kr.pe.nuti.home.api.pack.line.domain;

import kr.pe.nuti.home.api.pack.line.enumeration.LineMessageType;
import lombok.Data;

@Data
public class LineTextMessage implements LineMessage {
  private String text;


  @Override
  public String getType() {
    return LineMessageType.TEXT.getType();
  }
}
