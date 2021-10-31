package AwsSpringBoot.demo.web;


import AwsSpringBoot.demo.service.posts.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * JPA는 Entity들의 생성 및 수정 LocalDateTime을 자동으로 관리해주는 Audting 기능이 있다.
 * 해당 기능을 사용하기 위해 @EnableJpaAuditing을 추가했었는데, @SpringBootApplication 클래스에
 * 등록해놓은 것이 에러의 원인이었다.
 *
 * 모든 테스트는 가장 기본이 되는 XXXApplication 클래스가 항상 로드되는데, @EnableJpaAuditing이
 * 해당 클래스에 등록되어 있어서 모든 테스트들이 항상 JPA 관련 Bean들을 필요로 하고 있는 상태였다.
 *
 * 통합 테스트야 전체 컨텍스트를 로드하고 JPA를 포함한 모든 Bean들을 주입받기 때문에 에러가 발생하지 않았지만,
 * @WebMvcTest같은 슬라이스 테스트는 JPA 관련 Bean들을 로드하지 않기 때문에 에러가 발생했다.
 */
@WebMvcTest(MainController.class)
@ExtendWith(SpringExtension.class)
@MockBean(JpaMetamodelMappingContext.class)
class MainControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("hello test")
    public void helloTest() throws Exception {
        String hello = "hi it is maked by response body annotation";
        mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}