package AwsSpringBoot.demo.web.dto;

import AwsSpringBoot.demo.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Posts entity){
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.content  = entity.getContent();
        this.title = entity.getTitle();
    }
}
