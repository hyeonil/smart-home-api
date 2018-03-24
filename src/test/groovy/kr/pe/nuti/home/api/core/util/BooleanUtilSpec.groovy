package kr.pe.nuti.home.api.core.util

import spock.lang.Specification

import java.lang.reflect.InvocationTargetException

class BooleanUtilSpec extends Specification {

  def "BooleanUtil을 생성하면 IllegalAccessError가 발생한다."() {
    when: "생성한다."
    new BooleanUtil()

    then: "IllegalAccessError가 발생한다."
    thrown(IllegalAccessError)
  }

  def "BooleanUtil을 reflection으로 생성하면 InvocationTargetException이 발생한다."() {
    given: "reflection으로 생성자를 만든다."
    def constructor = BooleanUtil.class.getDeclaredConstructor()
    constructor.setAccessible(true)

    when: "생성한다."
    constructor.newInstance()

    then: "InvocationTargetException이 발생한다."
    thrown(InvocationTargetException)
  }

  def "not #value의 반대값 #result를 반환한다."() {
    expect:
    BooleanUtil.not(value) == result

    where:
    value || result
    true  || false
    false || true
  }
}
