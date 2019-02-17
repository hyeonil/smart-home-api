package kr.pe.nuti.home.api.pack.line.component;

import kr.pe.nuti.home.api.core.util.RestTemplateUtil;
import kr.pe.nuti.home.api.exception.ProxyException;
import kr.pe.nuti.home.api.pack.line.LineConstants;
import kr.pe.nuti.home.api.pack.line.domain.LineMessage;
import kr.pe.nuti.home.api.pack.line.domain.LinePushMessage;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class LineMessageSender {

  private String token;

  public LineMessageSender(String token) {
    this.token = token;
  }

  public void sendMessage(String to, LineMessage message) {
    this.sendMessage(to, Collections.singletonList(message));
  }

  public void sendMessage(String to, List<LineMessage> messageList) {
    final String url = LineConstants.URL_API_BASE + LineConstants.URL_MESSAGE_PUSH;
    final LinePushMessage message = new LinePushMessage(to, messageList);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    headers.put(LineConstants.AUTH_HEADER, Collections.singletonList(token));

    RestTemplate restTemplate = RestTemplateUtil.newInstance();

    HttpEntity<LinePushMessage> httpEntity = new HttpEntity<>(message, headers);
    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);

    if (!responseEntity.getStatusCode().is2xxSuccessful()) {
      throw new ProxyException();
    }
  }

  public void setToken(String token) {
    this.token = token;
  }
}
