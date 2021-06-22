package com.jojoldu.book.namddww.web.dto;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;
        
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        
        //then
        assertThat(dto.getName()).isEqualTo(name); //assertThat: assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
        // 검증하고 싶은 대상을 메소드 인자로 받습니다. 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.
        // isEqualTo: assertj의 동등 비교 메소드입니다. asserThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공입니다.
        assertThat(dto.getAmount()).isEqualTo(amount); //
    }

    @GetMapping("/Hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        //@RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션입니다. 여기서는 외부에서 name(@RequestParam("name"))이란
        //이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 됩니다.
        return new HelloResponseDto(name, amount);
    }
}
