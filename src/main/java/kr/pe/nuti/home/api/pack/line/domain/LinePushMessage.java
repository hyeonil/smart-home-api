package kr.pe.nuti.home.api.pack.line.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LinePushMessage {

  private String to;

  private List<LineMessage> messages;
}
