package com.gdsanadev.springdatajpaexample.repository;

import com.gdsanadev.springdatajpaexample.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<Guestbook, Long> {
    // JpaRepository를 상속하고, 1) 어떤 클래스 타입을 사용할 것인지, 2) @Id의 타입은 무엇인지를 지정한다.
    // 인터페이스 선언만 해도 자동으로 스프링의 bean으로 등록된다.
    // save(), fidById(), getOne(), deleteById(), delete() 와 같은 메서드를 활용한다.
}
