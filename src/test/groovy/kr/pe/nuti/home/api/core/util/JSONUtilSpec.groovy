package kr.pe.nuti.home.api.core.util

import spock.lang.Specification

import java.lang.reflect.InvocationTargetException

class JSONUtilSpec extends Specification {

  def "JSONUtil을 생성하면 IllegalAccessError가 발생한다."() {
    when: "생성한다."
    new JSONUtil()

    then: "IllegalAccessError가 발생한다."
    thrown(IllegalAccessError)
  }

  def "JSONUtil을 reflection으로 생성하면 InvocationTargetException이 발생한다."() {
    given: "reflection으로 생성자를 만든다."
    def constructor = JSONUtil.class.getDeclaredConstructor()
    constructor.setAccessible(true)

    when: "생성한다."
    constructor.newInstance()

    then: "InvocationTargetException이 발생한다."
    thrown(InvocationTargetException)
  }
}
