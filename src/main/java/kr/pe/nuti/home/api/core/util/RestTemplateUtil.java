package kr.pe.nuti.home.api.core.util;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class RestTemplateUtil {
  /**
   * 기본 타임아웃<br>
   * 문제가 없을 시 전체 반영하도록
   */
  public static final int TIMEOUT_DEFAULT = 5 * 1000;

  public static final int TIMEOUT_DEPENDS_ON_SERVER = 0;

  private RestTemplateUtil() {
    throw new IllegalAccessError("illegal access");
  }

  public static RestTemplate newInstance() {
    return newInstance(TIMEOUT_DEFAULT);
  }

  public static RestTemplate newInstance(int timeout) {
    return newInstance(timeout, timeout);
  }

  public static RestTemplate newInstance(int connectionTimeout, int readTimeout) {
    SSLContext sslContext = null;
    try {
      sslContext = SSLContexts.custom()
          .loadTrustMaterial(null, new TrustSelfSignedStrategy())
          .useProtocol("TLS")
          .build();
    } catch (KeyManagementException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (KeyStoreException e) {
      e.printStackTrace();
    }

    String[] protocols = {"TLSv1", "TLSv1.1", "TLSv1.2"};

    NoopHostnameVerifier noopHostnameVerifier = new NoopHostnameVerifier();
    SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, protocols, null, noopHostnameVerifier);
    CloseableHttpClient httpClient = HttpClients.custom()
        .setSSLSocketFactory(sslConnectionSocketFactory)
        .build();
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

    factory.setConnectTimeout(connectionTimeout);
    factory.setReadTimeout(readTimeout);

    return new RestTemplate(factory);
  }
}
