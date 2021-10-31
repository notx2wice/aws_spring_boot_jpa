package AwsSpringBoot.demo.web.dto;

import AwsSpringBoot.demo.domain.posts.Posts;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Posts entity){
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.title = entity.getTitle();
        this.modifiedDate = entity.getModifiedDate();
    }
}
