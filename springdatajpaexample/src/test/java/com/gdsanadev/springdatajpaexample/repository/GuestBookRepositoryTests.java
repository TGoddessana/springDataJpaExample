package com.gdsanadev.springdatajpaexample.repository;

import com.gdsanadev.springdatajpaexample.entity.Guestbook;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
public class GuestBookRepositoryTests {
    @Autowired
    GuestBookRepository guestBookRepository;


//    @Test
//    // GuestBookRepository 클래스가 정상 처리되고 의존성 주입에 문제가 없는지 확인
//    public void testDisplayClassName() {
//        System.out.println(guestBookRepository.getClass().getName());
//    }
//
//    @Test
//    // Create 확인
//    public void testCreate(){
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//            Guestbook guestbook = Guestbook.builder().guestBookMessage("퍼가요~" + i).build();
//            // GuestBook 엔티티에서 객체를 하나 생성하고, 내용은 "퍼가요~ 숫자" 형식으로 100개를 생성
//            guestBookRepository.save(guestbook); // 위에서 만든 엔티티 객체들을 JpaRepository를 활용해서 저장
//        });
//    }
//
//    @Test
//    // findById() 메서드로 Read 확인, findById() 는 DB에 먼저 접근
//    // Optional 타입으로 반환됨
//    public void testRead_by_findById(){
//        Long gbk = 9L; // 위에서 만든 데이터 중, pk가 9번인 데이터를 조회할 것인데 그것을 변수에 저장
//        Optional<Guestbook> result = guestBookRepository.findById(gbk); // 결괏값이 없을 수도 있으므로 Optional으로 선언
//        System.out.println("READTEST1__________________________________________");
//        if(result.isPresent()){ // Optional이므로 데이터가 존재한다면..
//            Guestbook guestbook = result.get(); // 값이 있으면 value를 리턴
//            System.out.println(guestbook); // 리턴된 값 출력
//        }
//    }
//
//    @Transactional
//    @Test
//    // getOne() 메서드로 Read 확인, getOne() 은 실제 객체가 필요한 순간이 되어서야 DB에 접근
//    public void testRead_by_getOne(){
//        Long gbk = 19L;
//        Guestbook guestbook = guestBookRepository.getOne(gbk);
//        System.out.println("READTEST2__________________________________________");
//        System.out.println(guestbook); // 실제 데이터가 필요한 순간인데, 이때 SQL이 실행됨
//    }
//
//    @Test
//    // Update 확인
//    public void testUpdate(){
//        // 메서드는 Create와 동일하게 save() 를 이용
//        Guestbook guestbook = Guestbook.builder().gbk(29L).guestBookMessage("Updated 29th message!").build();
//        System.out.println(guestBookRepository.save(guestbook)); // 수정된 객체를 출력
//    }
//
//    @Test
//    // Delete 확인
//    public void testDelete(){
//        Long gbk = 39L;
//        // deleteById 는 void를 리턴하고, 해당 데이터가 존재하지 않으면 에러를 발생시킴
//        guestBookRepository.deleteById(gbk);
//    }

    @Test
    public void testPagination() {
        Sort sortByDecending = Sort.by("gbk").descending(); // 내림차순 정리
        Pageable pageableByDecending = PageRequest.of(0, 10, sortByDecending);
        Page<Guestbook> result1 = guestBookRepository.findAll(pageableByDecending);
        System.out.println("내림차순 정리 확인________________________________");
        result1.get().forEach(guestbook -> {
            System.out.println(guestbook);
        });

        Sort sortByAscending = Sort.by("gbk").ascending(); // 오름차순 정리
        Pageable pageableByAscending = PageRequest.of(0, 10, sortByAscending);
        Page<Guestbook> result2 = guestBookRepository.findAll(pageableByAscending);
        System.out.println("오름차순 정리 확인________________________________");
        result2.get().forEach(guestbook -> {
            System.out.println(guestbook);
        });

        Sort sortByAll = sortByAscending.and(sortByDecending);
        Pageable pageableByAll = PageRequest.of(0, 10, sortByAll);
        Page<Guestbook> result3 = guestBookRepository.findAll(pageableByAll);
        System.out.println("And로 연결된 정렬 처리 확인________________________________");
        result3.get().forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }


}
