package kr.pe.nuti.home.api.core.constant

import spock.lang.Specification

import java.lang.reflect.InvocationTargetException

class ConstantsSpec extends Specification {

  def "Constants를 생성하면 IllegalAccessError가 발생한다."() {
    when: "생성한다."
    new Constants()

    then: "IllegalAccessError가 발생한다."
    thrown(IllegalAccessError)
  }

  def "Constants를 reflection으로 생성하면 InvocationTargetException이 발생한다."() {
    given: "reflection으로 생성자를 만든다."
    def constructor = Constants.class.getDeclaredConstructor();
    constructor.setAccessible(true)

    when: "생성한다."
    constructor.newInstance()

    then: "InvocationTargetException이 발생한다."
    thrown(InvocationTargetException)
  }
}
