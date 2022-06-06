package com.gdsanadev.springdatajpaexample.entity;

import lombok.*;

import javax.persistence.*;


@Entity // 해당 클래스가 엔티티를 위한 클래스임을 알려주는 어노테이션
@Table(name="table_guestbook") // 데이터베이스 상에서 엔티티 클래스를 어떤 테이블로 생성할 것인지에 대한 어노테이션
@ToString // ToString 메소드 생성
@Getter // 접근자를 생성해 줌, 클래스 밖에 써 줌으로서 모든 변수에 적용 가능
@Builder // Builder 패턴을 사용할 수 있도록 하는 코드 생성
@AllArgsConstructor // 모든 속성에 대해서 생성자를 만들어 줌
@NoArgsConstructor // 파라미터를 받지 않는 생성자를 만들어 줌

public class Guestbook {
    @Id // primary key 값을 지정해야 하는데, 그것을 알려주는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key 값을 자동으로 생성하도록 해 줌
    private Long gbk;

    @Column(length=200, nullable = false) // 새 컬럼이 필요한 경우, Column어노테이션을 활용
    private String guestBookMessage;
}
