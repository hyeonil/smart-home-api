package kr.pe.nuti.home.api.pack.book.service

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("도서 정보를 저장한다.")
@Narrative("""
도서 정보를 저장한다.
도서 정보는 제목, 부제, 출판사, 저자 이름, ISBN, Reference Site를 포함한다.
저자의 이름과 Reference Site는 1개 이상을 저장할 수 있다.
부제와 Reference Site는 필수 정보가 아니다.
""")
class BookSaveSpec extends Specification {

  def "도서 정보를 저장한다."() {
    given: "책 제목"
    and: "부제"
    and: "출판사"
    and: "저자 이름"
    and: "ISBN"
    and: "Reference Site"
  }

  def "여러 저자가 작성한 도서 정보를 저장한다."() {

  }

  def "부제가 없는 도서정보를 저장한다."() {

  }

  def "Reference Site가 없는 도서 정보를 저장한다."() {

  }

  def "Reference Site가 여러개인 도서 정보를 저장한다."() {

  }
}
