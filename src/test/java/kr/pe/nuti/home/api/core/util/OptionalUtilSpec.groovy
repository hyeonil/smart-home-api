package kr.pe.nuti.home.api.core.util

import spock.lang.Specification

import java.lang.reflect.InvocationTargetException

class OptionalUtilSpec extends Specification {

  def "OptionalUtil을 생성하면 IllegalAccessError가 발생한다."() {
    when: "생성한다."
    new OptionalUtil()

    then: "IllegalAccessError가 발생한다."
    thrown(IllegalAccessError)
  }

  def "OptionalUtil을 reflection으로 생성하면 InvocationTargetException이 발생한다."() {
    given: "reflection으로 생성자를 만든다."
    def constructor = OptionalUtil.class.getDeclaredConstructor()
    constructor.setAccessible(true)

    when: "생성한다."
    constructor.newInstance()

    then: "InvocationTargetException이 발생한다."
    thrown(InvocationTargetException)
  }

  def "emptyStringIfNotPresent #value가 null이면 빈문자열을 반환하고 null이 아니면 #value를 반환한다."() {
    expect:
    result == OptionalUtil.emptyStringIfNotPresent(value)

    where:
    value || result
    "abc" || "abc"
    "def" || "def"
    null  || ""
  }

  def "zeroIfNotPresent #value가 null이 아니면 #value를 반환한다."() {
    expect:
    result == OptionalUtil.zeroIfNotPresent(value)

    where:
    value || result
    1     || 1
    1L    || 1L
    1.0f  || 1.0f
    1.1   || 1.1
  }

  def "zeroIfNotPresent #value가 null이면 0을 반환한다."() {
    given: "value는 null이다."
    def value = null

    when: "zeroIfNotPresent를 실행한다."
    def result = [
        OptionalUtil.zeroIfNotPresent((Integer)value),
        OptionalUtil.zeroIfNotPresent((Long)value),
        OptionalUtil.zeroIfNotPresent((Float)value),
        OptionalUtil.zeroIfNotPresent((Double)value)
    ]

    then: "#result는 0이다."
    result == [0, 0L, 0f, 0.0]
  }

  def "falseIfNotPresent #value가 null이면 false를 반환하고 null이 아니면 #value를 반환한다."() {
    expect:
    result == OptionalUtil.falseIfNotPresent(value)

    where:
    value || result
    true  || true
    false || false
    null  || false
  }

  def "throwIllegalArgumentExceptionIfNotPresent #value가 null이 아니면 #value를 반환한다."(value, result) {
    expect:
    result == OptionalUtil.throwIllegalArgumentExceptionIfNotPresent(value);

    where:
    value || result
    "abc" || "abc"
    123   || 123
  }

  def "throwIllegalArgumentExceptionIfNotPresent #value가 null이면 IllegalArgumentException을 throw한다."() {
    given: "value는 null이다."
    def value = null

    when: "throwIllegalArgumentExceptionIfNotPresent를 실행한다."
    OptionalUtil.throwIllegalArgumentExceptionIfNotPresent(value)

    then: "IllegalArgumentException이 발생한다."
    thrown(IllegalArgumentException)
  }
}
