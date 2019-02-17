package kr.pe.nuti.home.api.pack.line.enumeration;

import lombok.Getter;

@Getter
public enum LineMessageType {
  TEXT,
  ;
  private String type;

  private LineMessageType() {
    this.type = name().toLowerCase();
  }
}
