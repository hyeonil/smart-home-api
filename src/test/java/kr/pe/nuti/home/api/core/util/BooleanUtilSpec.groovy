package kr.pe.nuti.home.api.core.util

import spock.lang.Specification

class BooleanUtilSpec extends Specification {

  def "not은 #value의 반대값 #result를 반환한다."() {
    expect:
    BooleanUtil.not(value) == result

    where:
    value || result
    true  || false
    false || true
  }
}
