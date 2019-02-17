package kr.pe.nuti.home.api.pack.line.component

import kr.pe.nuti.home.api.pack.line.LineEnvironmentVariables
import kr.pe.nuti.home.api.pack.line.domain.LineMessage
import kr.pe.nuti.home.api.pack.line.domain.LineTextMessage
import spock.lang.Specification

class LineMessageSenderSpec extends Specification {

  private String token;

  private String owner;

  private LineMessageSender sender;

  def setup() {
    token = System.getProperty(LineEnvironmentVariables.AUTH_TOKEN);
    owner = System.getProperty(LineEnvironmentVariables.OWNER_ID);

    sender = new LineMessageSender(token);
  }

  def "단건 텍스트 메세지를 전송한다."() {
    given: "메세지"
    LineMessage lineMessage = new LineTextMessage(text: "test message content");

    when: "메세지 전성"
    String result = sender.sendMessage(owner, lineMessage);

    then: "결과"
    println result;
  }

  def "리스트 텍스트 메세지를 전송한다."() {
    given: "메세지"
    def list =  [
        new LineTextMessage(text: "test message content"),
        new LineTextMessage(text: "test message content2")
    ];

    when: "메세지 전성"
    String result = sender.sendMessage(owner, list);

    then: "결과"
    println result;
  }
}
