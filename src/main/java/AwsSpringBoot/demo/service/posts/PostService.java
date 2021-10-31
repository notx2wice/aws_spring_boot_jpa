package AwsSpringBoot.demo.service.posts;

import AwsSpringBoot.demo.domain.posts.Posts;
import AwsSpringBoot.demo.domain.posts.PostsRepository;
import AwsSpringBoot.demo.web.dto.PostListResponseDto;
import AwsSpringBoot.demo.web.dto.PostResponseDto;
import AwsSpringBoot.demo.web.dto.PostSaveRequestDto;
import AwsSpringBoot.demo.web.dto.PostUpdateRequestDto;
import javafx.geometry.Pos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Posts post = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 post가 없어요"));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostResponseDto findById(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 post가 없어요"));
        return new PostResponseDto(post);
    }

    @Transactional
    public List<PostListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("no article"));

        postsRepository.delete(posts);
    }

}
