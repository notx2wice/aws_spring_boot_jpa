package AwsSpringBoot.demo.web.dto;

import AwsSpringBoot.demo.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostSaveRequestDto(String title, String content, String author){
        this.author = author;
        this.content = content;
        this.title = title;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
